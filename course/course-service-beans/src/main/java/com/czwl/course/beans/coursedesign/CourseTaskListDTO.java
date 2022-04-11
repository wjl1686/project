package com.czwl.course.beans.coursedesign;

import com.czwl.base.BaseDTO;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * 课程任务清单
 *
 * @author: srg
 * @create: 2020-04-23
 */
@Data
@NoArgsConstructor
public class CourseTaskListDTO extends BaseDTO {

    /**
     * 课程id
     */
    private Long courseId;
    /**
     * 清单名称
     */
    private String name;
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
