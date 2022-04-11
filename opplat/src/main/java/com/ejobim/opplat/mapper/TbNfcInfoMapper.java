package com.ejobim.opplat.mapper;

import com.ejobim.opplat.domain.TbNfcInfo;
import com.ejobim.opplat.domain.TbNfcInfoExample;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public interface TbNfcInfoMapper {
    int countByExample(TbNfcInfoExample example);

    int deleteByExample(TbNfcInfoExample example);

    int deleteByPrimaryKey(String nfcNo);

    int insert(TbNfcInfo record);

    int insertSelective(TbNfcInfo record);

    List<TbNfcInfo> selectByExample(TbNfcInfoExample example);

    TbNfcInfo selectByPrimaryKey(String nfcNo);

    int updateByExampleSelective(@Param("record") TbNfcInfo record, @Param("example") TbNfcInfoExample example);

    int updateByExample(@Param("record") TbNfcInfo record, @Param("example") TbNfcInfoExample example);

    int updateByPrimaryKeySelective(TbNfcInfo record);

    int updateByPrimaryKey(TbNfcInfo record);

    List<TbNfcInfo> getEquipCheckNFCList(TbNfcInfo tbNfcInfo);
}