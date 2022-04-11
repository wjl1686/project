package com.ejobim.opplat.mapper;

import com.ejobim.opplat.domain.TbSchedulingChange;
import com.ejobim.opplat.domain.TbSchedulingTransfer;
import com.ejobim.opplat.domain.TbSchedulingTransferExample;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface TbSchedulingTransferMapper {
    int countByExample(TbSchedulingTransferExample example);

    int deleteByExample(TbSchedulingTransferExample example);

    int deleteByPrimaryKey(String transferNo);

    int insert(TbSchedulingTransfer record);

    int insertSelective(TbSchedulingTransfer record);

    List<TbSchedulingTransfer> selectByExample(TbSchedulingTransferExample example);

    TbSchedulingTransfer selectByPrimaryKey(String transferNo);

    int updateByExampleSelective(@Param("record") TbSchedulingTransfer record, @Param("example") TbSchedulingTransferExample example);

    int updateByExample(@Param("record") TbSchedulingTransfer record, @Param("example") TbSchedulingTransferExample example);

    int updateByPrimaryKeySelective(TbSchedulingTransfer record);

    int updateByPrimaryKey(TbSchedulingTransfer record);

    List<TbSchedulingTransfer>  getTbSchedulingTransferList(TbSchedulingTransfer transfer);

    TbSchedulingTransfer selectByConditin(TbSchedulingChange change);
}