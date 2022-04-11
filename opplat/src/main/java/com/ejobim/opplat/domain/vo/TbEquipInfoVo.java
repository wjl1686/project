package com.ejobim.opplat.domain.vo;

import com.ejobim.opplat.common.annotation.ExcelColumn;
import lombok.Data;

@Data
public class TbEquipInfoVo {

    @ExcelColumn(value = "一级名称",col = 1)
    private String firstName;

    @ExcelColumn(value = "二级名称",col = 2)
    private String secondName;
}
