package com.ejobim.opplat.mapper;

import com.ejobim.opplat.domain.TbMedicine;
import com.ejobim.opplat.domain.TbMedicineExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Component;

@Component
public interface TbMedicineMapper {
    int countByExample(TbMedicineExample example);

    int deleteByExample(TbMedicineExample example);

    int deleteByPrimaryKey(String medicineNo);

    int insert(TbMedicine record);

    int insertSelective(TbMedicine record);

    List<TbMedicine> selectByExample(TbMedicineExample example);

    TbMedicine selectByPrimaryKey(String medicineNo);

    int updateByExampleSelective(@Param("record") TbMedicine record, @Param("example") TbMedicineExample example);

    int updateByExample(@Param("record") TbMedicine record, @Param("example") TbMedicineExample example);

    int updateByPrimaryKeySelective(TbMedicine record);

    int updateByPrimaryKey(TbMedicine record);

    List<TbMedicine> findMedicineList(TbMedicine tbMedicine);


}