package com.ejobim.opplat.mapper;

import com.ejobim.opplat.domain.TbRole;
import com.ejobim.opplat.domain.TbUserOrgRole;
import com.ejobim.opplat.domain.TbUserOrgRoleExample;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public interface TbUserOrgRoleMapper {
    int countByExample(TbUserOrgRoleExample example);

    int deleteByExample(TbUserOrgRoleExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(TbUserOrgRole record);

    int insertSelective(TbUserOrgRole record);

    List<TbUserOrgRole> selectByExample(TbUserOrgRoleExample example);

    TbUserOrgRole selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") TbUserOrgRole record, @Param("example") TbUserOrgRoleExample example);

    int updateByExample(@Param("record") TbUserOrgRole record, @Param("example") TbUserOrgRoleExample example);

    int updateByPrimaryKeySelective(TbUserOrgRole record);

    int updateByPrimaryKey(TbUserOrgRole record);

    void delete();

    List<TbRole> selectRoleNameByUserCode(@Param("code") String code);

    /**
     * 用户角色机构批量添加
     * @param list
     * @return
     */
    int  insertUserOrgRoleBatchlist(List<TbUserOrgRole> list);
}