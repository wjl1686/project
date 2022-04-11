package com.ejobim.opplat.wjl;

import com.alibaba.fastjson.JSONObject;
import com.ejobim.opplat.OpplatApplicationTests;
import com.ejobim.opplat.domain.TbEquipType;
import com.ejobim.opplat.domain.TbParam;
import com.ejobim.opplat.domain.TbWorkFlowInfoExtend;
import com.ejobim.opplat.domain.TbWorkFlowInfoExtendExample;
import com.ejobim.opplat.domain.condition.MonitorCondition;
import com.ejobim.opplat.domain.condition.QueryConditon;
import com.ejobim.opplat.mapper.TbEquipTypeMapper;
import com.ejobim.opplat.mapper.TbWorkFlowInfoExtendMapper;
import com.ejobim.opplat.service.impl.BewgServiceImpl;
import com.ejobim.opplat.util.Tree;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class TestData extends OpplatApplicationTests {

    @Autowired
    private BewgServiceImpl bewgService;

    //测试获取token
    @Test
    public void testToken(){
        String token = bewgService.getToken();
        System.out.println(token);
    }
    //测试获取告警信息
    @Test
    public void testAlarmInfo(){
        QueryConditon queryConditon = new QueryConditon();
        List<String> list= new ArrayList<>();
        //  ["/Hollysys_Bewg_modelNew/5ca1b24d82ac7e0007cdb0c31","/Hollysys_Bewg_modelNew/5ca1b24d82ac7e0007cdb0c3","/Hollysys_Bewg_modelNew/5ca1b24d82ac7e0007cdb0c2","/Hollysys_Bewg_modelNew/5ca1b24d82ac7e0007cdb0c1"]
        list.add("/Hollysys_Bewg_modelNew/5ca1b24d82ac7e0007cdb0c31");
        list.add("/Hollysys_Bewg_modelNew/5ca1b24d82ac7e0007cdb0c3");
        list.add("/Hollysys_Bewg_modelNew/5ca1b24d82ac7e0007cdb0c2");
        list.add("/Hollysys_Bewg_modelNew/5ca1b24d82ac7e0007cdb0c1");
        queryConditon.setUriList(list);
        JSONObject alarmInfo = bewgService.getAlarmList(queryConditon);
    }

    @Test
    public void testCreate(){
        QueryConditon queryConditon = new QueryConditon();
        JSONObject alarmInfo = bewgService.createSubscription(queryConditon);
        System.out.println(alarmInfo);
    }
    @Test
    public void testCreateByUri(){
        MonitorCondition queryConditon = new MonitorCondition();
        List<MonitorCondition> monitorConditionList = new ArrayList<>();
        queryConditon.setNodeUri("/test/100");
        monitorConditionList.add(queryConditon);
        queryConditon.setSubscriptionId("6542b7362ca94b9f8c55ad3777369f56");
        queryConditon.setMonitoredItems(monitorConditionList);
        JSONObject alarmInfo = bewgService.createByUri(queryConditon);
        System.out.println(alarmInfo);
    }

    @Autowired
    TbWorkFlowInfoExtendMapper tbWorkFlowInfoExtendMapper;
    @Test
    public  void test111(){
      /*  TbInspcetTaskExample example = new TbInspcetTaskExample();

//        criteria.andInspModelNoEqualTo(inspcetModel.getInspModelNo());
        List<TbInspcetTask> tbInspcetTasks = inspcetTaskMapper.selectByExample(example);
        System.out.println(tbInspcetTasks.size());*/
        TbWorkFlowInfoExtendExample extendExample = new TbWorkFlowInfoExtendExample();
        TbWorkFlowInfoExtendExample.Criteria criteria = extendExample.createCriteria();
        criteria.andFlowNoEqualTo("0d65783b69344cdf8976ea1a135882d0");
        List<TbWorkFlowInfoExtend> tbWorkFlowInfoExtends = tbWorkFlowInfoExtendMapper.selectByExample(extendExample);
        System.out.println("总数==="+tbWorkFlowInfoExtends.size());
        for (TbWorkFlowInfoExtend tbWorkFlowInfoExtend : tbWorkFlowInfoExtends) {
                String sata= tbWorkFlowInfoExtend.getStatusCode();
                String ex= tbWorkFlowInfoExtend.getExtendNo();

            for (TbWorkFlowInfoExtend workFlowInfoExtend : tbWorkFlowInfoExtends) {
                if(sata.equals(workFlowInfoExtend.getStatusCode())){
                    System.out.println("cf===="+ex);
                    System.out.println("bc=="+workFlowInfoExtend.getExtendNo());

                    System.out.println("=====================");
                    //tbWorkFlowInfoExtendMapper.deleteByPrimaryKey(ex);

                }
            }


        }

    }
    private void freshTree(List<Tree<TbParam>> list, List<String> equipTypeList, String equipTypeName){
        for(int i=list.size()-1;i>=0;i-- ){
            Tree<TbParam> tree = list.get(i);
            if(tree.getChildren().size()>0){
                freshTree(tree.getChildren(),equipTypeList,equipTypeName);
                if(tree.getChildren().size()==0){
                    list.remove(tree);
                }
            }else{
                if(!equipTypeList.contains(tree.getId())){
                    list.remove(tree);
                }
                if(equipTypeName!=null){
                    if(tree.getText().indexOf(equipTypeName)<0){
                        list.remove(tree);
                    }
                }

            }
        }
    }
@Autowired
    TbEquipTypeMapper tbEquipTypeMapper;

    @Test
    public  void testTbequipTye() throws IOException {

        List<TbEquipType> list=new ArrayList<TbEquipType>();
        InputStream is = new FileInputStream("C:/222.xls");

        XSSFWorkbook excel = new XSSFWorkbook(is);
        TbEquipType stu = null;
        // 循环工作表Sheet
        for (int numSheet = 0; numSheet < excel.getNumberOfSheets(); numSheet++) {
            XSSFSheet sheet = excel.getSheetAt(numSheet);
            if (sheet == null)
                continue;
            // 循环行Row
            for (int rowNum = 0; rowNum <= sheet.getLastRowNum(); rowNum++) {
                XSSFRow row = sheet.getRow(rowNum);
                stu = new TbEquipType();
                if (row == null)
                    continue;
                if(rowNum==140)
                    break;
                XSSFCell cell0 = row.getCell(0);
                //equip_type_code  0和1
                //parent_id 取0

                String one =cell0+"";
                String[] s = one.split("\\.");
                stu.setParentId(Integer.valueOf(s[0]));
                if(s[0].length()==1){
                    s[0]="0"+s[0];
                }
                //stu.setId(Integer.valueOf(cell0.getStringCellValue().equals("")?null:cell0.getStringCellValue()));


                XSSFCell cell1 = row.getCell(1);

                String two =cell1+"";
                String[] split = two.split("\\.");
                if(split[0].length()==1){
                    split[0]="0"+split[0];
                }

                stu.setEquipTypeCode(s[0]+split[0]);
                XSSFCell cell2 = row.getCell(2);
                //equip_level_type
                stu.setEquipLevelType(cell2+"");
                //type_name
                XSSFCell cell3 = row.getCell(3);
                stu.setTypeName(cell3+"");
                stu.setStatus(1);
                stu.setCreateUserName("吴建龙");
                stu.setCreateUser("155684805667400020");
                stu.setCreateTime(new Date());
                list.add(stu);
            }
        }

       for (TbEquipType t:list) {
            tbEquipTypeMapper.insertSelective(t);
        }
        System.out.println(list.toString());

    }
}
