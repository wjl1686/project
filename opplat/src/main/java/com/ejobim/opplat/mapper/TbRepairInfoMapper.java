package com.ejobim.opplat.mapper;

import com.ejobim.opplat.domain.TbRepairInfo;
import com.ejobim.opplat.domain.TbRepairInfoExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Component;

@Component
public interface TbRepairInfoMapper {
    int countByExample(TbRepairInfoExample example);

    int deleteByExample(TbRepairInfoExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(TbRepairInfo record);

    int insertSelective(TbRepairInfo record);

    List<TbRepairInfo> selectByExample(TbRepairInfoExample example);

    TbRepairInfo selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") TbRepairInfo record, @Param("example") TbRepairInfoExample example);

    int updateByExample(@Param("record") TbRepairInfo record, @Param("example") TbRepairInfoExample example);

    int updateByPrimaryKeySelective(TbRepairInfo record);

    int updateByPrimaryKey(TbRepairInfo record);
}