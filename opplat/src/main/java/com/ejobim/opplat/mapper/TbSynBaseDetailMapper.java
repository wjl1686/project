package com.ejobim.opplat.mapper;

import com.ejobim.opplat.domain.TbSynBaseDetail;
import com.ejobim.opplat.domain.TbSynBaseDetailExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Component;

@Component
public interface TbSynBaseDetailMapper {
    int countByExample(TbSynBaseDetailExample example);

    int deleteByExample(TbSynBaseDetailExample example);

    int insert(TbSynBaseDetail record);

    int insertSelective(TbSynBaseDetail record);

    List<TbSynBaseDetail> selectByExample(TbSynBaseDetailExample example);

    int updateByExampleSelective(@Param("record") TbSynBaseDetail record, @Param("example") TbSynBaseDetailExample example);

    int updateByExample(@Param("record") TbSynBaseDetail record, @Param("example") TbSynBaseDetailExample example);

    int insertBatch(List<TbSynBaseDetail> list);
}