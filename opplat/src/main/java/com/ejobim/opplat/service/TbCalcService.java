package com.ejobim.opplat.service;

import com.ejobim.opplat.domain.TbCalc;

import java.util.List;
import java.util.Map;

/**
 * @author xibian
 * @date 2019-05-10
 */
public interface TbCalcService {
    /**
     * 获取计算器列表
     * @return
     */
    List<TbCalc> getTbCalcList();

    /**
     * 添加计算器
     * @param tbCalc
     * @return
     */
    int addTbCalc(TbCalc tbCalc);

    /**
     * 获取计算器
     * @param name
     * @return
     */
    TbCalc getTbCalc(String name);

    List<Map<String,Object>> getTableDetailInfo(String sql);
}
