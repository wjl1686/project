package com.ejobim.opplat.mapper;

import com.ejobim.opplat.domain.TbRoutingLocatioinEquip;
import com.ejobim.opplat.domain.TbRoutingLocatioinEquipExample;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public interface TbRoutingLocatioinEquipMapper {
    int countByExample(TbRoutingLocatioinEquipExample example);

    int deleteByExample(TbRoutingLocatioinEquipExample example);

    int deleteByPrimaryKey(String locationEquipNo);

    int insert(TbRoutingLocatioinEquip record);

    int insertSelective(TbRoutingLocatioinEquip record);

    List<TbRoutingLocatioinEquip> selectByExample(TbRoutingLocatioinEquipExample example);

    TbRoutingLocatioinEquip selectByPrimaryKey(String locationEquipNo);

    TbRoutingLocatioinEquip selectByEquipNo(String routingNo,String equipNo);

    int updateByExampleSelective(@Param("record") TbRoutingLocatioinEquip record, @Param("example") TbRoutingLocatioinEquipExample example);

    int updateByExample(@Param("record") TbRoutingLocatioinEquip record, @Param("example") TbRoutingLocatioinEquipExample example);

    int updateByPrimaryKeySelective(TbRoutingLocatioinEquip record);

    int updateByPrimaryKey(TbRoutingLocatioinEquip record);

    int getLocationEquipMaxSort(String routingNo);

    List<TbRoutingLocatioinEquip>  selectLocatioinEquipByEquipNo(@Param("equipNo") String equipNo);
}