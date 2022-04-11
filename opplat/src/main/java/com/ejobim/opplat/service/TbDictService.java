package com.ejobim.opplat.service;

import com.ejobim.opplat.domain.TbDict;

import java.util.List;

/**
 *
 */
public interface TbDictService {
    /**
     * 查找字典
     * @param tDict
     * @return
     */
     List<TbDict> findTbDictList(TbDict tDict);

    List<TbDict> getDictByParent(List<Integer> parentList);

    /**
     * 新增字典
     * @param tDict
     * @return
     */
     int addDict(TbDict tDict);

    /**
     * 更新字典
     * @param tbDict
     * @return
     */
     int updateDict(TbDict tbDict);

    /**
     * 删除字典
     * @param ids
     * @return
     */
     int deleteDicts(String[] ids);
}
