package com.ejobim.opplat.mapper;

import com.ejobim.opplat.domain.TbOrg;
import com.ejobim.opplat.domain.TbOrgExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface TbOrgMapper {
    int countByExample(TbOrgExample example);

    int deleteByExample(TbOrgExample example);

    int deleteByPrimaryKey(String code);

    int insert(TbOrg record);

    int insertSelective(TbOrg record);

    List<TbOrg> selectByExample(TbOrgExample example);

    TbOrg selectByPrimaryKey(String code);

    int updateByExampleSelective(@Param("record") TbOrg record, @Param("example") TbOrgExample example);

    int updateByExample(@Param("record") TbOrg record, @Param("example") TbOrgExample example);

    int updateByPrimaryKeySelective(TbOrg record);

    int updateByPrimaryKey(TbOrg record);
}