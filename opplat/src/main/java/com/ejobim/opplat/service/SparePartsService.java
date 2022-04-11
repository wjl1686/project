package com.ejobim.opplat.service;

import com.ejobim.opplat.domain.TbSpareParts;

import java.util.List;

public interface SparePartsService {

    /**
     * 获取备件列表
     * @param spareParts
     * @param  idList
     * @return
     */
    List<TbSpareParts> getTbSparePartsList(TbSpareParts spareParts,List<String> idList);

    /**
     * 新增备件
     * @param spareParts
     * @return
     */
    int saveTbSpareParts(TbSpareParts spareParts);

    /**
     * 删除备件
     * @param tbSpareParts
     * @return
     */
    int deleteTbSpareParts(TbSpareParts tbSpareParts);

    /**
     *
     * @param tbSpareParts
     * @param useCount
     * @return
     */
    int useSpareParts(TbSpareParts tbSpareParts,int useCount);

    /**
     * chaxun
     * @param spareParts
     * @return
     */
    List selectSparePartsByCond(TbSpareParts spareParts);


}
