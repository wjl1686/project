package com.czwl.course.beans.processtask;

import com.czwl.base.BaseDTO;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * 流程任务
 *
 * @author: srg
 * @create: 2020-05-06
 */
@Data
@NoArgsConstructor
public class ProcessTaskDTO extends BaseDTO {

    /**
     * 前置任务id
     */
    private Long pid;
    /**
     * 分类id
     */
    private Long categoryId;
    /**
     * 任务名称
     */
    private String name;
    /**
     * 任务编码
     */
    private String code;
    /**
     * 任务描述
     */
    private String description;
    /**
     * 审核驳回理由
     */
    private String rejectReason;
    /**
     * 状态, 启用:0，停用:1，删除：2
     */
    private Integer status;
    /**
     * 状态，审核、上架等
     */
    private Integer state;
    /**
     * 可见范围 0：私有；1：内部公开；2：公开， 默认0私有
     */
    private Integer scope;
    /**
     * 创建人
     */
    private Long creator;
    /**
     * 创建时间
     */
    private java.util.Date createTime;
    /**
     * 修改人
     */
    private Long modifier;
    /**
     * 修改时间
     */
    private java.util.Date modifyTime;

    /**
     * 创建人名称
     */
    private String creatorName;
    /**
     * 分类名称
     */
    private String categoryName;

}
