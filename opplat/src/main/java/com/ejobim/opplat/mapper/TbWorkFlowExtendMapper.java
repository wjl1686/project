package com.ejobim.opplat.mapper;

import com.ejobim.opplat.domain.TbWorkFlowExtend;
import com.ejobim.opplat.domain.TbWorkFlowExtendExample;
import com.ejobim.opplat.domain.TbWorkFlowExtendKey;
import java.util.List;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Component;

@Component
public interface TbWorkFlowExtendMapper {
    int countByExample(TbWorkFlowExtendExample example);

    int deleteByExample(TbWorkFlowExtendExample example);

    int deleteByPrimaryKey(TbWorkFlowExtendKey key);

    int insert(TbWorkFlowExtend record);

    int insertSelective(TbWorkFlowExtend record);

    List<TbWorkFlowExtend> selectByExample(TbWorkFlowExtendExample example);

    TbWorkFlowExtend selectByPrimaryKey(TbWorkFlowExtendKey key);

    int updateByExampleSelective(@Param("record") TbWorkFlowExtend record, @Param("example") TbWorkFlowExtendExample example);

    int updateByExample(@Param("record") TbWorkFlowExtend record, @Param("example") TbWorkFlowExtendExample example);

    int updateByPrimaryKeySelective(TbWorkFlowExtend record);

    int updateByPrimaryKey(TbWorkFlowExtend record);
}