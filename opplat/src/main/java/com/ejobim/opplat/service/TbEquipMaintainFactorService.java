package com.ejobim.opplat.service;

import com.ejobim.opplat.domain.TbEquipInfo;
import com.ejobim.opplat.domain.TbEquipMaintainFactor;
import com.ejobim.opplat.domain.vo.TbEquipMaintainFactorVo;

import java.util.List;

public interface TbEquipMaintainFactorService {

    /**
     * 查询维保要素列表
     * @param tbEquipMaintainFactor  equipTypeList
     * @return
     */
    List<TbEquipMaintainFactor> getTbEquipMaintainFactorList(TbEquipMaintainFactor tbEquipMaintainFactor, List<String> equipTypeList);

    /**
     * 根据水厂查询设备列表
     * @param   tbEquipInfo
     * @return
     */
    List<TbEquipInfo> getTbEquipListByfactoryNo(TbEquipInfo tbEquipInfo);

    /**
     * 新增/修改设备维保要素
     * @param  tbEquipMaintainFactor
     * @return
     */
    int saveTbEquipMaintainFactor(TbEquipMaintainFactor tbEquipMaintainFactor);

    /**
     * 删除设备维保要素
     * @param  tbEquipMaintainFactor
     * @return
     */
    int updateEquipMaintainFactor(TbEquipMaintainFactor tbEquipMaintainFactor);

    /**
     * 获取正在执行切
     * @param factoryNo
     * @return
     */
    List<TbEquipMaintainFactor> getTbEquipMaintainFactorList(String factoryNo);

    TbEquipMaintainFactor getTbEquipMaintainFactorByKey(String mfNo);

    /**
     * 批量导入维保要素
     * @param list
     * @return
     */
    int saveImportEquipMaintainFactor(List<TbEquipMaintainFactorVo> list);
}
