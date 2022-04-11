package com.ejobim.opplat.mapper;

import com.ejobim.opplat.domain.TbCalc;
import com.ejobim.opplat.domain.TbCalcExample;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Component;

/**
 * @author  xibian
 * @date 2019-05-10
 */
@Component
public interface TbCalcMapper {
    /**
     * 计数查询
     *
     * @param example
     * @return
     */
    int countByExample(TbCalcExample example);

    /**
     * 删除对象
     * @param example
     * @return
     */
    int deleteByExample(TbCalcExample example);

    /**
     * 根据主键删除
     * @param id
     * @return
     */
    int deleteByPrimaryKey(Integer id);

    int insert(TbCalc record);

    int insertSelective(TbCalc record);

    List<TbCalc> selectByExample(TbCalcExample example);

    TbCalc selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") TbCalc record, @Param("example") TbCalcExample example);

    int updateByExample(@Param("record") TbCalc record, @Param("example") TbCalcExample example);

    int updateByPrimaryKeySelective(TbCalc record);

    int updateByPrimaryKey(TbCalc record);

    List<Map<String,Object>> selectDataInfo(String dataName);

    List<Map<String,Object>> selectTableInfo(@Param("tableName")String tableName);

    List<Map<String,Object>> getTableDetailInfo(@Param("sql")String sql);


}