package com.ejobim.opplat.service;

import com.ejobim.opplat.domain.TbEquipInfo;

import java.util.List;

public interface TbEquipInfoService {

    /**
     * 新增或更新設備
     * @param tbEquipInfo
     * @return
     */
    int  saveTbEquipInfo(TbEquipInfo tbEquipInfo);

    List<TbEquipInfo> getTbEquipInfoList(TbEquipInfo tbEquipInfo);

}
