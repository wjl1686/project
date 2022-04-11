package com.ejobim.opplat.service.impl;

import com.ejobim.opplat.common.Dict;
import com.ejobim.opplat.domain.TbProcessApply;
import com.ejobim.opplat.domain.TbProcessApplyExtend;
import com.ejobim.opplat.domain.TbProcessApplyExtendExample;
import com.ejobim.opplat.domain.vo.CheckVo;
import com.ejobim.opplat.domain.vo.TbProcessApplyVo;
import com.ejobim.opplat.mapper.TbFactoryInfoMapper;
import com.ejobim.opplat.mapper.TbProcessApplyExtendMapper;
import com.ejobim.opplat.mapper.TbProcessApplyMapper;
import com.ejobim.opplat.mapper.TbUserMapper;
import com.ejobim.opplat.service.ProcessService;
import com.ejobim.opplat.service.SysService;
import com.ejobim.opplat.util.StringTools;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
@Transactional(propagation = Propagation.REQUIRED ,  rollbackFor = Exception.class)
public class ProcessServiceImpl implements ProcessService {

    private Logger logger = LoggerFactory.getLogger(this.getClass());
    private int flag=0;

    @Autowired
    private TbProcessApplyMapper tbProcessApplyMapper;

    @Autowired
    private TbProcessApplyExtendMapper tbProcessApplyExtendMapper;

    @Autowired
    private SysService sysService;

    @Autowired
    private TbUserMapper tbUserMapper;

    @Autowired
    private TbFactoryInfoMapper tbFactoryInfoMapper;

    public String getUserName(String code){
        String name =null;
        if(tbUserMapper.selectByPrimaryKey(code)!=null){
            name= tbUserMapper.selectByPrimaryKey(code).getName();
        }
        return  name;
    }

    @Override
    @Transactional(propagation = Propagation.REQUIRED ,  rollbackFor = Exception.class)
    public int saveTbProcessApply(TbProcessApply tbProcessApply) {
       int result=0;
       int result1=0;
       int result2=0;
        if(tbProcessApply.getProcessNo()!=null && tbProcessApply.getProcessNo() !=""){
            result=tbProcessApplyMapper.updateByPrimaryKeySelective(tbProcessApply);
            if(result>0){
                flag=1;
            }
        }else{
            String processNo = StringTools.getUUID();
            tbProcessApply.setProcessNo(processNo);
            tbProcessApply.setApplyTime(new Date());
            tbProcessApply.setStatus(0);
            //主表
           result = tbProcessApplyMapper.insertSelective(tbProcessApply);

            TbProcessApplyExtend tbProcessApplyExtend = addTbProcessApplyExtend(tbProcessApply, processNo);
            tbProcessApplyExtend.setStep(0);
            tbProcessApplyExtend.setStepUser(tbProcessApply.getApplyUser());
            tbProcessApplyExtend.setStepUserName(getUserName(tbProcessApply.getApplyUser()));
            tbProcessApplyExtend.setStepTime(new Date());
            tbProcessApplyExtend.setVaildStatus(1);
            //明细表
            result1= tbProcessApplyExtendMapper.insertSelective(tbProcessApplyExtend);

            TbProcessApplyExtend tbProcessApplyExtendAgain = addTbProcessApplyExtend(tbProcessApply, processNo);
            tbProcessApplyExtendAgain.setStepUser(tbProcessApply.getChooseUser());
            tbProcessApplyExtendAgain.setStepUserName(getUserName(tbProcessApply.getChooseUser()));
            tbProcessApplyExtendAgain.setStep(1);
            result2= tbProcessApplyExtendMapper.insertSelective(tbProcessApplyExtendAgain);
            if(result>0 && result1>0 &&result2>0){
                flag=1;
            }
        }

        return flag;
    }
    public TbProcessApplyExtend addTbProcessApplyExtend(TbProcessApply tbProcessApply,String processNo){
        TbProcessApplyExtend tbProcessApplyExtend = new TbProcessApplyExtend();
        tbProcessApplyExtend.setCreateUser(tbProcessApply.getApplyUser());
        tbProcessApplyExtend.setCreateUserName(getUserName(tbProcessApply.getApplyUser()));
        tbProcessApplyExtend.setProcessApplyNo(StringTools.getUUID());
        tbProcessApplyExtend.setProcessNo(processNo);
        tbProcessApplyExtend.setRemark(tbProcessApply.getRemark());
        tbProcessApplyExtend.setVaildStatus(1);
        tbProcessApplyExtend.setCreateTime(new Date());
        return  tbProcessApplyExtend;
    }

    @Override
    public int passOrReject(CheckVo checkVo) {
        //修改主表状态
        TbProcessApply tbProcessApply = returnTbProcessApply(checkVo);

        TbProcessApplyExtend re = returnAgree(tbProcessApply.getProcessNo());
        re.setStep(2);
        re.setIdea(checkVo.getIdea());
        re.setRemark(checkVo.getRemark());

        TbProcessApplyExtend record = returnTbProcessApplyExtend(checkVo);
        record.setStep(3);
        if(checkVo.getType()==1){
            tbProcessApply.setStatus(2);
            flag=tbProcessApplyExtendMapper.updateByProcessNo(re);

            flag =tbProcessApplyExtendMapper.insertSelective(record);
        }else{
            tbProcessApply.setStatus(0);
            //驳回应该做修改
            re.setVaildStatus(2);
            flag=tbProcessApplyExtendMapper.updateByRejectProcessNo(re);

            TbProcessApplyExtend reUpdate = returnAgree(tbProcessApply.getProcessNo());
            reUpdate.setStep(1);
            reUpdate.setStepTime(null);
            reUpdate.setVaildStatus(1);
            flag=tbProcessApplyExtendMapper.updateByCondition(reUpdate);
        }
        tbProcessApplyMapper.updateByPrimaryKeySelective(tbProcessApply);
        //修改细表
        return flag;
    }


    @Override
    public List<TbProcessApplyVo> getTbProcessApplyList(TbProcessApply tbProcessApply) {
        List<TbProcessApplyVo> tbProcessApplyVos = tbProcessApplyMapper.selectTbProcessApplyList(tbProcessApply);
/*
        tbProcessApplyVos.forEach(tbProcessApplyVo -> {
            if(tbProcessApplyVo.getContent()!=null) {
                if (tbProcessApplyVo.getContent().length() > 20) {
                    tbProcessApplyVo.setContent(tbProcessApplyVo.getContent().substring(0, 20) + "...");
                }
            }
        });
*/
        return tbProcessApplyVos;
    }

    @Override
    public int goSubmit(TbProcessApply tbProcessApply) {
        TbProcessApply tbProcessApply1 = new TbProcessApply();
        tbProcessApply1.setStatus(1);
        tbProcessApply1.setProcessNo(tbProcessApply.getProcessNo());

        tbProcessApplyMapper.updateByPrimaryKeySelective(tbProcessApply1);

        List<TbProcessApplyExtend> list= tbProcessApplyExtendMapper.selectByProcessNo(tbProcessApply.getProcessNo());
        TbProcessApplyExtend tbProcessApplyExtend = new TbProcessApplyExtend();
        tbProcessApplyExtend.setStepUser(list.get(0).getStepUser());
        tbProcessApplyExtend.setStepUserName(getUserName(list.get(0).getStepUser()));
        tbProcessApplyExtend.setProcessApplyNo(StringTools.getUUID());
        tbProcessApplyExtend.setProcessNo(tbProcessApply.getProcessNo());
        tbProcessApplyExtend.setCreateUser(tbProcessApply.getApplyUser());
        tbProcessApplyExtend.setCreateTime(new Date());
        tbProcessApplyExtend.setCreateUserName(getUserName(tbProcessApply.getApplyUser()));
        tbProcessApplyExtend.setVaildStatus(1);
        tbProcessApplyExtend.setStep(2);
        tbProcessApplyExtendMapper.insertSelective(tbProcessApplyExtend);
        //修改
        TbProcessApplyExtend re = returnAgree(tbProcessApply.getProcessNo());
        re.setStep(1);
        re.setRemark(tbProcessApply.getRemark());
        re.setStepUser(null);
        flag=tbProcessApplyExtendMapper.updateByProcessNo(re);
        //新增
        //通过ProcessNo

        return flag;
    }

    @Override
    public Map getTbProcessApplyExtendInfo(String processNo) {
        Map map =new HashMap();
        TbProcessApply tbProcessApply = tbProcessApplyMapper.selectByPrimaryKey(processNo);
        tbProcessApply.setCreateUserName(getUserName(tbProcessApply.getApplyUser()));
        tbProcessApply.setFactoryName(tbFactoryInfoMapper.selectByPrimaryKey(tbProcessApply.getFactoryNo()).getFactoryName());
        map.put("tbProcessApply",tbProcessApply);
        List<TbProcessApplyExtend> tbProcessApplyExtendList=tbProcessApplyExtendMapper.selectByProcessNo(processNo);
        map.put("list",tbProcessApplyExtendList);
        return map;
    }

    @Override
    public int goCheck(CheckVo checkVo) {

        //修改主表状态
        TbProcessApply tbProcessApply = returnTbProcessApply(checkVo);

        TbProcessApplyExtend record = returnTbProcessApplyExtend(checkVo);
        record.setStep(4);

        TbProcessApplyExtend re = returnAgree(checkVo.getProcessNo());
        re.setStep(3);
        re.setIdea(checkVo.getIdea());
        re.setRemark(checkVo.getRemark());
        if(checkVo.getType()==1){
            tbProcessApply.setStatus(3);
            tbProcessApplyMapper.updateByPrimaryKeySelective(tbProcessApply);

            tbProcessApplyExtendMapper.updateByProcessNo(re);

            flag =tbProcessApplyExtendMapper.insertSelective(record);
        }else{
            //驳回 TODO
            tbProcessApply.setStatus(0);
            tbProcessApplyMapper.updateByPrimaryKeySelective(tbProcessApply);
            re.setVaildStatus(2);
            tbProcessApplyExtendMapper.updateByRejectProcessNo(re);

            TbProcessApplyExtend tbProcessApplyExtendUp = returnAgree(checkVo.getProcessNo());
            tbProcessApplyExtendUp.setStep(2);
            tbProcessApplyExtendUp.setVaildStatus(2);
            tbProcessApplyExtendMapper.updateByRejectProcessNo(tbProcessApplyExtendUp);

            TbProcessApplyExtend reUpdate = returnAgree(tbProcessApply.getProcessNo());
            reUpdate.setStep(1);
            reUpdate.setStepTime(null);
            reUpdate.setVaildStatus(1);
            flag=tbProcessApplyExtendMapper.updateByCondition(reUpdate);

        }
        //修改细表
        return flag;
    }

    public TbProcessApply returnTbProcessApply(CheckVo checkVo){
        TbProcessApply tbProcessApply = new TbProcessApply();
        tbProcessApply.setProcessNo(checkVo.getProcessNo());
        return  tbProcessApply;
    }
    public TbProcessApplyExtend returnTbProcessApplyExtend(CheckVo checkVo){
        TbProcessApplyExtend record = new TbProcessApplyExtend();
        record.setProcessApplyNo(StringTools.getUUID());
        record.setProcessNo(checkVo.getProcessNo());
        if(checkVo.getOperator()!=null){
            record.setStepUser(checkVo.getOperator());
            record.setStepUserName(getUserName(checkVo.getOperator()));
        }
        record.setCreateUser(checkVo.getApplyUser());
        record.setCreateUserName(getUserName(checkVo.getApplyUser()));
        record.setCreateTime(new Date());
        record.setVaildStatus(1);
        return  record;
    }
    public  TbProcessApplyExtend returnAgree(String process){
        TbProcessApplyExtend re  = new TbProcessApplyExtend();
        re.setStepTime(new Date());
        re.setProcessNo(process);
        return re;

    }


    @Override
    public int goDelivery(CheckVo checkVo) {
        //修改主表状态
        TbProcessApply tbProcessApply = returnTbProcessApply(checkVo);
        tbProcessApply.setStatus(4);
        tbProcessApplyMapper.updateByPrimaryKeySelective(tbProcessApply);
        //修改细表
        TbProcessApplyExtend re = returnAgree(checkVo.getProcessNo());
        re.setIdea(checkVo.getIdea());
        re.setRemark(checkVo.getRemark());
        re.setStep(4);
        tbProcessApplyExtendMapper.updateByProcessNo(re);
        //插入细表
        TbProcessApplyExtend record = returnTbProcessApplyExtend(checkVo);
        record.setStep(5);
        flag =tbProcessApplyExtendMapper.insertSelective(record);
        return flag;
    }

    @Override
    public List<TbProcessApply> getDeliveryList(TbProcessApply tbProcessApply) {
        tbProcessApply.setStatus(4);
        List<TbProcessApply> tbProcessApplyList=  tbProcessApplyMapper.selectTbProcessApplyLists(tbProcessApply);
        return tbProcessApplyList;
    }

    @Override
    public int appConfirmSubmit(CheckVo checkVo) {
        //修改主表状态
        //判断
        if(checkVo.getOperator()==null || checkVo.getProcessNo()==null){
            return  Dict.AjaxStatus.PARAM_IS_NULL.getStatusCode();
        }
        TbProcessApply tbProcessApplyDb = tbProcessApplyMapper.selectByPrimaryKey(checkVo.getProcessNo());
        if(tbProcessApplyDb==null){
            return Dict.AjaxStatus.NOFIND.getStatusCode();
        }else {
            TbProcessApplyExtendExample extendExample = new TbProcessApplyExtendExample();
            TbProcessApplyExtendExample.Criteria criteria = extendExample.createCriteria();
            criteria.andProcessNoEqualTo(checkVo.getProcessNo());
            criteria.andStepEqualTo(5);
            criteria.andVaildStatusEqualTo(1);
            List<TbProcessApplyExtend> tbProcessApplyExtendList = tbProcessApplyExtendMapper.selectByExample(extendExample);
            if(!checkVo.getApplyUser().equals(tbProcessApplyExtendList.get(0).getStepUser())){
                return Dict.AjaxStatus.NOROLE.getStatusCode();
            }
            //主表现在是0.需要改成1
            if (tbProcessApplyDb.getStatus() == 5) {
                return Dict.AjaxStatus.RECOMMITE.getStatusCode();
            }

            TbProcessApply tbProcessApply = returnTbProcessApply(checkVo);
            tbProcessApply.setStatus(5);
            tbProcessApplyMapper.updateByPrimaryKeySelective(tbProcessApply);
            //修改细表
            TbProcessApplyExtend re = returnAgree(checkVo.getProcessNo());
            re.setIdea(checkVo.getIdea());
            re.setRemark(checkVo.getRemark());
            re.setStep(5);
            tbProcessApplyExtendMapper.updateByProcessNo(re);
            //插入细表
            TbProcessApplyExtend record = returnTbProcessApplyExtend(checkVo);
            record.setStep(6);
            flag = tbProcessApplyExtendMapper.insertSelective(record);
        }
        return 1;
    }


    @Override
    public int appEffectConfirmSubmit(CheckVo checkVo) {

        if(checkVo.getProcessNo()==null){
            return  Dict.AjaxStatus.PARAM_IS_NULL.getStatusCode();
        }
        //修改主表状态
        TbProcessApply tbProcessApply = returnTbProcessApply(checkVo);
        TbProcessApplyExtend record = returnTbProcessApplyExtend(checkVo);
        TbProcessApplyExtend re = returnAgree(tbProcessApply.getProcessNo());
        re.setIdea(checkVo.getIdea());
        re.setRemark(checkVo.getRemark());

        if(checkVo.getType()==1){
            re.setStep(6);
            //通过
            tbProcessApply.setStatus(6);
            record.setStep(7);
            record.setStepUser(checkVo.getApplyUser());
            record.setStepUserName(getUserName(checkVo.getApplyUser()));
            flag=tbProcessApplyExtendMapper.updateByProcessNo(re);
            flag =tbProcessApplyExtendMapper.insertSelective(record);
        }else{
            //驳回
            tbProcessApply.setStatus(4);
            //改step =4 时间空
            re.setStep(6);
            //改step =5 vailstatus =0
            re.setVaildStatus(2);
            flag=tbProcessApplyExtendMapper.updateByRejectProcessNo(re);
            TbProcessApplyExtend reUpdate = returnAgree(tbProcessApply.getProcessNo());
            reUpdate.setStep(5);
            reUpdate.setStepTime(null);
            reUpdate.setVaildStatus(1);
            flag=tbProcessApplyExtendMapper.updateByCondition(reUpdate);
        }
        tbProcessApplyMapper.updateByPrimaryKeySelective(tbProcessApply);
        return flag;
    }

    @Override
    public List<TbProcessApply> getTbProcessApplyALLList(TbProcessApply tbProcessApply) {
        List<TbProcessApply> processApplyList = tbProcessApplyMapper.selectTbProcessApplyAllList(tbProcessApply);
        processApplyList.forEach(pro->{
            pro.setCreateUserName(getUserName(pro.getApplyUser()));
        });
        return processApplyList;
    }

    @Override
    @Transactional(propagation = Propagation.REQUIRED ,  rollbackFor = Exception.class)
    public int deleteTbProcessApply(TbProcessApply tbProcessApply) {
        tbProcessApplyMapper.deleteByPrimaryKey(tbProcessApply.getProcessNo());
        TbProcessApplyExtendExample tbProcessApplyExtendExample = new TbProcessApplyExtendExample();
        TbProcessApplyExtendExample.Criteria criteria = tbProcessApplyExtendExample.createCriteria();
        criteria.andProcessNoEqualTo(tbProcessApply.getProcessNo());
        int i = tbProcessApplyExtendMapper.deleteByExample(tbProcessApplyExtendExample);
        return i;
    }


}
