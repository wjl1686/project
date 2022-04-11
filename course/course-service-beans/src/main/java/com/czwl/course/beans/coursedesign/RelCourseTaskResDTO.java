package com.czwl.course.beans.coursedesign;

import com.czwl.base.BaseDTO;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * 课程任务与资源关联
 *
 * @author: srg
 * @create: 2020-04-23
 */
@Data
@NoArgsConstructor
public class RelCourseTaskResDTO extends BaseDTO {

    /**
     * 课程id
     */
    private Long courseId;
    /**
     * 课程任务id
     */
    private Long courseTaskId;
    /**
     * 资源id
     */
    private Long resId;
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
