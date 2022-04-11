package com.czwl.course.beans.coursedesign;

import com.czwl.base.BaseDTO;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * 课程任务与账套关联
 *
 * @author: srg
 * @create: 2020-04-23
 */
@Data
@NoArgsConstructor
public class RelCourseTaskAccountSetDTO extends BaseDTO {

    /**
     * 课程id
     */
    private Long courseId;
    /**
     * 课程任务id
     */
    private Long courseTaskId;
    /**
     * 账套id
     */
    private Long accountSetId;
    /**
     * 关联账套类型，1：推荐账套；2：可选账套；
     */
    private Integer type;
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
