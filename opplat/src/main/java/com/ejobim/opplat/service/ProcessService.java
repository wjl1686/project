package com.ejobim.opplat.service;

import com.ejobim.opplat.domain.TbProcessApply;
import com.ejobim.opplat.domain.vo.CheckVo;
import com.ejobim.opplat.domain.vo.TbProcessApplyVo;

import java.util.List;
import java.util.Map;

public interface ProcessService {

    int saveTbProcessApply(TbProcessApply tbProcessApply);

    int passOrReject(CheckVo checkVo);

    List<TbProcessApplyVo> getTbProcessApplyList(TbProcessApply tbProcessApply);

    int goSubmit(TbProcessApply tbProcessApply);

    Map getTbProcessApplyExtendInfo(String processNo);

    int goCheck(CheckVo checkVo);

    int goDelivery(CheckVo checkVo);

    List<TbProcessApply>  getDeliveryList(TbProcessApply tbProcessApply);

    int appConfirmSubmit(CheckVo checkVo);

    int appEffectConfirmSubmit(CheckVo checkVo);

    List<TbProcessApply>  getTbProcessApplyALLList(TbProcessApply tbProcessApply);

    int deleteTbProcessApply(TbProcessApply tbProcessApply);

}
