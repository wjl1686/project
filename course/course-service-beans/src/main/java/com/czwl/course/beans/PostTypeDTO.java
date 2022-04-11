package com.czwl.course.beans;

import com.czwl.base.BaseDTO;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

/**
 * 岗位类型
 *
 * @author: srg
 * @create: 2020-03-11
 */
@Data
@NoArgsConstructor
public class PostTypeDTO extends BaseDTO {

    /**
     * 岗位类型名称
     */
    private String name;
    /**
     * 状态, 启用:1，停用:0
     */
    private Integer status;
    /**
     * 排序号
     */
    private Integer sort;
    /**
     * 创建人
     */
    private Long creator;
    /**
     * 创建时间
     */
    private Date createTime;
    /**
     * 修改人
     */
    private Long modifier;
    /**
     * 修改时间
     */
    private Date modifyTime;


}
