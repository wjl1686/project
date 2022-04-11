package com.ejobim.opplat.mapper;

import com.ejobim.opplat.domain.TbWorkTaskInfoExtend;
import com.ejobim.opplat.domain.TbWorkTaskInfoExtendExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Component;

@Component
public interface TbWorkTaskInfoExtendMapper {
    int countByExample(TbWorkTaskInfoExtendExample example);

    int deleteByExample(TbWorkTaskInfoExtendExample example);

    int deleteByPrimaryKey(String extendNo);

    int insert(TbWorkTaskInfoExtend record);

    int insertSelective(TbWorkTaskInfoExtend record);

    List<TbWorkTaskInfoExtend> selectByExample(TbWorkTaskInfoExtendExample example);

    TbWorkTaskInfoExtend selectByPrimaryKey(String extendNo);

    int updateByExampleSelective(@Param("record") TbWorkTaskInfoExtend record, @Param("example") TbWorkTaskInfoExtendExample example);

    int updateByExample(@Param("record") TbWorkTaskInfoExtend record, @Param("example") TbWorkTaskInfoExtendExample example);

    int updateByPrimaryKeySelective(TbWorkTaskInfoExtend record);

    int updateByPrimaryKey(TbWorkTaskInfoExtend record);
}