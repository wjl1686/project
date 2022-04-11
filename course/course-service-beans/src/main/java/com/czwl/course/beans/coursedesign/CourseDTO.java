package com.czwl.course.beans.coursedesign;

import com.czwl.base.BaseDTO;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * 课程
 *
 * @author: srg
 * @create: 2020-04-17
 */
@Data
@NoArgsConstructor
public class CourseDTO extends BaseDTO {

    /**
     * 课程名称
     */
    private String name;
    /**
     * 编码
     */
    private String code;
    /**
     * 课程类型，1：业务实操课程；2：仿真实训课程；3：理论认知课程；
     */
    private Integer type;
    /**
     * 课程封面
     */
    private String img;
    /**
     * 培养目标
     */
    private String target;
    /**
     * 课程简介
     */
    private String description;
    /**
     * 课前测评,0:不需要;1:需要;
     */
    private Integer preEvaluation;
    /**
     * 课后测评,0:不需要;1:需要;
     */
    private Integer aftEvaluation;
    /**
     * 课前评测试卷id
     */
    private Long preExamPaperId;
    /**
     * 课后评测试卷id
     */
    private Long aftExamPaperId;
    /**
     * 状态，审核、上架等
     */
    private Integer state;
    /**
     * 审核驳回理由
     */
    private String rejectReason;
    /**
     * 状态, 启用:1，停用:0
     */
    private Integer status;
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

}
