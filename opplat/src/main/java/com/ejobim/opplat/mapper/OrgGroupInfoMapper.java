package com.ejobim.opplat.mapper;

import com.ejobim.opplat.domain.OrgGroupInfo;
import com.ejobim.opplat.domain.OrgGroupInfoExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Component;

@Component
public interface OrgGroupInfoMapper {
    int countByExample(OrgGroupInfoExample example);

    int deleteByExample(OrgGroupInfoExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(OrgGroupInfo record);

    int insertSelective(OrgGroupInfo record);

    List<OrgGroupInfo> selectByExample(OrgGroupInfoExample example);

    OrgGroupInfo selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") OrgGroupInfo record, @Param("example") OrgGroupInfoExample example);

    int updateByExample(@Param("record") OrgGroupInfo record, @Param("example") OrgGroupInfoExample example);

    int updateByPrimaryKeySelective(OrgGroupInfo record);

    int updateByPrimaryKey(OrgGroupInfo record);
}