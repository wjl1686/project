package com.ejobim.opplat.mapper;

import com.ejobim.opplat.domain.TbRole;
import com.ejobim.opplat.domain.TbRoleExample;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public interface TbRoleMapper {
    int countByExample(TbRoleExample example);

    int deleteByExample(TbRoleExample example);

    int deleteByPrimaryKey(String code);

    int insert(TbRole record);

    int insertSelective(TbRole record);

    List<TbRole> selectByExample(TbRoleExample example);

    TbRole selectByPrimaryKey(String code);

    int updateByExampleSelective(@Param("record") TbRole record, @Param("example") TbRoleExample example);

    int updateByExample(@Param("record") TbRole record, @Param("example") TbRoleExample example);

    int updateByPrimaryKeySelective(TbRole record);

    int updateByPrimaryKey(TbRole record);

    List<TbRole> selectRoleList(TbRole tbRole);

    void delete();

    /**
     * 角色批量添加
     * @param list
     * @return
     */
    int  insertRoleBatchlist(List<TbRole> list);
}