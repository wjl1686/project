package com.ejobim.opplat.mapper;

import com.ejobim.opplat.domain.TbEquipInfo;
import com.ejobim.opplat.domain.TbEquipInfoExample;
import com.ejobim.opplat.domain.TbNfcInfo;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Map;

@Component
public interface TbEquipInfoMapper {
    int countByExample(TbEquipInfoExample example);

    int deleteByExample(TbEquipInfoExample example);

    int deleteByPrimaryKey(String equipNo);

    int insert(TbEquipInfo record);

    int insertSelective(TbEquipInfo record);

    List<TbEquipInfo> selectByExample(TbEquipInfoExample example);

    TbEquipInfo selectByPrimaryKey(String equipNo);

    int updateByExampleSelective(@Param("record") TbEquipInfo record, @Param("example") TbEquipInfoExample example);

    int updateByExample(@Param("record") TbEquipInfo record, @Param("example") TbEquipInfoExample example);

    int updateByPrimaryKeySelective(TbEquipInfo record);

    int updateByPrimaryKey(TbEquipInfo record);
    /**
     *
     * 查设备类型转设备类型名称
     */
    TbEquipInfo getTbEquipInfo( TbEquipInfo te);

    /**
     * 根据主键查询设备信息
     * @param tbEquipInfo
     * @return
     */
    List<TbEquipInfo> selectEquipBaseInfoByKey(TbEquipInfo tbEquipInfo);

    List<TbEquipInfo>  selectEquipBatchlist(@Param("list") String[] list);

    int delete(String factory_no);

    /**
     * 设备批量添加
     * @param list
     * @return
     */
    int  insertEquipBatchlist(List<TbEquipInfo> list);

    List<Map<String, String>> getNfcEquipInfoList(TbNfcInfo tbNfcInfo);
}