package com.ejobim.opplat.mapper;

import com.ejobim.opplat.domain.TbProcessApply;
import com.ejobim.opplat.domain.TbProcessApplyExample;
import java.util.List;

import com.ejobim.opplat.domain.vo.TbProcessApplyVo;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Component;

@Component
public interface TbProcessApplyMapper {
    int countByExample(TbProcessApplyExample example);

    int deleteByExample(TbProcessApplyExample example);

    int deleteByPrimaryKey(String processNo);

    int insert(TbProcessApply record);

    int insertSelective(TbProcessApply record);

    List<TbProcessApply> selectByExample(TbProcessApplyExample example);

    TbProcessApply selectByPrimaryKey(String processNo);

    int updateByExampleSelective(@Param("record") TbProcessApply record, @Param("example") TbProcessApplyExample example);

    int updateByExample(@Param("record") TbProcessApply record, @Param("example") TbProcessApplyExample example);

    int updateByPrimaryKeySelective(TbProcessApply record);

    int updateByPrimaryKey(TbProcessApply record);

    List<TbProcessApplyVo> selectTbProcessApplyList(TbProcessApply tbProcessApply);

    TbProcessApplyVo selectByProcessNo(TbProcessApply tbProcessApply);

    List<TbProcessApply> selectTbProcessApplyLists(TbProcessApply tbProcessApply);

    List<TbProcessApply> selectTbProcessApplyAllList(TbProcessApply tbProcessApply);
}