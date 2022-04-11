package com.ejobim.opplat.mapper;

import com.ejobim.opplat.domain.TbMedicineDict;
import com.ejobim.opplat.domain.TbMedicineDictExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Component;

@Component
public interface TbMedicineDictMapper {
    int countByExample(TbMedicineDictExample example);

    int deleteByExample(TbMedicineDictExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(TbMedicineDict record);

    int insertSelective(TbMedicineDict record);

    List<TbMedicineDict> selectByExample(TbMedicineDictExample example);

    TbMedicineDict selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") TbMedicineDict record, @Param("example") TbMedicineDictExample example);

    int updateByExample(@Param("record") TbMedicineDict record, @Param("example") TbMedicineDictExample example);

    int updateByPrimaryKeySelective(TbMedicineDict record);

    int updateByPrimaryKey(TbMedicineDict record);

    List<TbMedicineDict> selectBatchIds(@Param("mids") List<String> mids);
}