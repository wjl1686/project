package com.ejobim.opplat.mapper;

import com.ejobim.opplat.domain.TbSpareParts;
import com.ejobim.opplat.domain.TbSparePartsExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Component;

@Component
public interface TbSparePartsMapper {
    int countByExample(TbSparePartsExample example);

    int deleteByExample(TbSparePartsExample example);

    int deleteByPrimaryKey(String sparePartsNo);

    int insert(TbSpareParts record);

    int insertSelective(TbSpareParts record);

    List<TbSpareParts> selectByExample(TbSparePartsExample example);

    TbSpareParts selectByPrimaryKey(String sparePartsNo);

    int updateByExampleSelective(@Param("record") TbSpareParts record, @Param("example") TbSparePartsExample example);

    int updateByExample(@Param("record") TbSpareParts record, @Param("example") TbSparePartsExample example);

    int updateByPrimaryKeySelective(TbSpareParts record);

    int updateByPrimaryKey(TbSpareParts record);

    List selectSparePartsByCond(TbSpareParts tbSpareParts);
}