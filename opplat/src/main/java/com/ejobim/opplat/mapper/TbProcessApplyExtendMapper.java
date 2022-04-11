package com.ejobim.opplat.mapper;

import com.ejobim.opplat.domain.TbProcessApplyExtend;
import com.ejobim.opplat.domain.TbProcessApplyExtendExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Component;

@Component
public interface TbProcessApplyExtendMapper {
    int countByExample(TbProcessApplyExtendExample example);

    int deleteByExample(TbProcessApplyExtendExample example);

    int deleteByPrimaryKey(String processApplyNo);

    int insert(TbProcessApplyExtend record);

    int insertSelective(TbProcessApplyExtend record);

    List<TbProcessApplyExtend> selectByExample(TbProcessApplyExtendExample example);

    TbProcessApplyExtend selectByPrimaryKey(String processApplyNo);

    int updateByExampleSelective(@Param("record") TbProcessApplyExtend record, @Param("example") TbProcessApplyExtendExample example);

    int updateByExample(@Param("record") TbProcessApplyExtend record, @Param("example") TbProcessApplyExtendExample example);

    int updateByPrimaryKeySelective(TbProcessApplyExtend record);

    int updateByPrimaryKey(TbProcessApplyExtend record);

    int updateByProcessNo(TbProcessApplyExtend record);

    List<TbProcessApplyExtend> selectByProcessNo(String processNo);

    int  updateByCondition(TbProcessApplyExtend reUpdate);

    int  updateByRejectProcessNo(TbProcessApplyExtend re);
}