package com.ejobim.opplat.mapper;

import com.ejobim.opplat.domain.TbEquipTaskFile;
import com.ejobim.opplat.domain.TbEquipTaskFileExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Component;

@Component
public interface TbEquipTaskFileMapper {
    int countByExample(TbEquipTaskFileExample example);

    int deleteByExample(TbEquipTaskFileExample example);

    int deleteByPrimaryKey(String ofNo);

    int insert(TbEquipTaskFile record);

    int insertSelective(TbEquipTaskFile record);

    List<TbEquipTaskFile> selectByExample(TbEquipTaskFileExample example);

    TbEquipTaskFile selectByPrimaryKey(String ofNo);

    int updateByExampleSelective(@Param("record") TbEquipTaskFile record, @Param("example") TbEquipTaskFileExample example);

    int updateByExample(@Param("record") TbEquipTaskFile record, @Param("example") TbEquipTaskFileExample example);

    int updateByPrimaryKeySelective(TbEquipTaskFile record);

    int updateByPrimaryKey(TbEquipTaskFile record);
}