package com.czwl.course.beans.coursedesign;

import com.czwl.base.BaseDTO;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * 课程任务与能力模型关联
 *
 * @author: srg
 * @create: 2020-04-29
 */
@Data
@NoArgsConstructor
public class RelCourseTaskAbilityDTO extends BaseDTO {

    /**
     * 课程id
     */
    private Long courseId;
    /**
     * 课程任务id
     */
    private Long courseTaskId;
    /**
     * 能力模型id
     */
    private Long abilityId;
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


}
