package com.ejobim.opplat.service;

import com.ejobim.opplat.domain.TDict;

import java.util.List;

/**
 *
 */
public interface TDictService {
    /**
     * 查找字典
     * @param tDict
     * @return
     */
     List<TDict> findTDictList(TDict tDict);

    /**
     * 新增字典
     * @param tDict
     * @return
     */
     int addDict(TDict tDict);

    /**
     * 更新字典
     * @param tDict
     * @return
     */
     int updateDict(TDict tDict);

    /**
     * 删除字典
     * @param ids
     * @return
     */
     int deleteDicts(String[] ids);
}
