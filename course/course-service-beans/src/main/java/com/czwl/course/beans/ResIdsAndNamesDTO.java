package com.czwl.course.beans;

import com.czwl.base.BaseDTO;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

/**
 * 课程资源
 * @author: dlj
 * @create: 2020-03-10
 */
@Data
@NoArgsConstructor
public class ResIdsAndNamesDTO extends BaseDTO {


    /**
     * 资源名称
     */
    private  String  name;
    /**
     * 物理资源id
     */
    private  Long  pubResId;

}
