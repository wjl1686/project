package com.ejobim.opplat.mapper;

import com.ejobim.opplat.domain.Capability;
import com.ejobim.opplat.domain.CapabilityExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface CapabilityMapper {
    int countByExample(CapabilityExample example);

    int deleteByExample(CapabilityExample example);

    int deleteByPrimaryKey(Long id);

    int insert(Capability record);

    int insertSelective(Capability record);

    List<Capability> selectByExample(CapabilityExample example);

    Capability selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("record") Capability record, @Param("example") CapabilityExample example);

    int updateByExample(@Param("record") Capability record, @Param("example") CapabilityExample example);

    int updateByPrimaryKeySelective(Capability record);

    int updateByPrimaryKey(Capability record);
}