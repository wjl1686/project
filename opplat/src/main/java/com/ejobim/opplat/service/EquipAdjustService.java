package com.ejobim.opplat.service;

import com.alibaba.fastjson.JSONObject;
import com.ejobim.opplat.domain.TbEquipAdjust;
import com.ejobim.opplat.domain.TbEquipAdjustExtend;
import com.ejobim.opplat.domain.TbUser;
import com.ejobim.opplat.domain.TbWorkFlowConfig;

import java.util.List;

public interface EquipAdjustService  {



    List<TbEquipAdjustExtend> getEquipAdjustExtendList(String adNo);

    TbEquipAdjust getEquipAdjustInfo(String adNo);

}
