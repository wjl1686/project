package com.czwl.course.beans.accountset;

import com.czwl.base.BaseDTO;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

/**
 * 账套任务
 *
 * @author: srg
 * @create: 2020-04-02
 */
@Data
@NoArgsConstructor
public class AccountSetTaskDTO extends BaseDTO {

    /**
     * 账套id
     */
    private Long accountSetId;
    /**
     * 账期：年
     */
    private Integer periodYear;
    /**
     * 账期：月
     */
    private Integer periodMonth;
    /**
     * 前置任务id
     */
    private Long pid;
    /**
     * 任务名称
     */
    private String name;
    /**
     * 任务编码
     */
    private String code;
    /**
     * 状态, 启用:1，停用:0
     */
    private Integer status;
    /**
     * 任务描述
     */
    private String description;
    /**
     * 排序
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
    /**
     * 创建人名称
     */
    private String creatorName;
    /**
     * 前置任务名称
     */
    private String pname;

}
