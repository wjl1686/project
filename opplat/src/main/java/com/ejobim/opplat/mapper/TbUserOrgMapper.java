package com.ejobim.opplat.mapper;

import com.ejobim.opplat.domain.TbUserOrg;
import com.ejobim.opplat.domain.TbUserOrgExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Component;

@Component
public interface TbUserOrgMapper {
    int countByExample(TbUserOrgExample example);

    int deleteByExample(TbUserOrgExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(TbUserOrg record);

    int insertSelective(TbUserOrg record);

    List<TbUserOrg> selectByExample(TbUserOrgExample example);

    TbUserOrg selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") TbUserOrg record, @Param("example") TbUserOrgExample example);

    int updateByExample(@Param("record") TbUserOrg record, @Param("example") TbUserOrgExample example);

    int updateByPrimaryKeySelective(TbUserOrg record);

    int updateByPrimaryKey(TbUserOrg record);

    void delete();
}