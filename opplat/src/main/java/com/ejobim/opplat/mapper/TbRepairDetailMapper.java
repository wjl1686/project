package com.ejobim.opplat.mapper;

import com.ejobim.opplat.domain.TbRepairDetail;
import com.ejobim.opplat.domain.TbRepairDetailExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Component;


@Component
public interface TbRepairDetailMapper {
    int countByExample(TbRepairDetailExample example);

    int deleteByExample(TbRepairDetailExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(TbRepairDetail record);

    int insertSelective(TbRepairDetail record);

    List<TbRepairDetail> selectByExample(TbRepairDetailExample example);

    TbRepairDetail selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") TbRepairDetail record, @Param("example") TbRepairDetailExample example);

    int updateByExample(@Param("record") TbRepairDetail record, @Param("example") TbRepairDetailExample example);

    int updateByPrimaryKeySelective(TbRepairDetail record);

    int updateByPrimaryKey(TbRepairDetail record);
}