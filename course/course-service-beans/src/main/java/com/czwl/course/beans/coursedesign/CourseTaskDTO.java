package com.czwl.course.beans.coursedesign;

import com.czwl.base.BaseDTO;
import com.czwl.course.beans.AbilityDTO;
import com.czwl.course.beans.accountset.AccountSetDTO;
import com.czwl.exam.beans.ExamPaperDTO;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

/**
 * 课程任务
 *
 * @author: srg
 * @create: 2020-04-23
 */
@Data
@NoArgsConstructor
public class CourseTaskDTO extends BaseDTO {

    /**
     * 课程id
     */
    private Long courseId;
    /**
     * 任务清单id
     */
    private Long listId;
    /**
     * 编码
     */
    private String code;
    /**
     * 任务名称
     */
    private String name;
    /**
     * 前置任务id
     */
    private Long pid;
    /**
     * 前置任务名称
     */
    private String pname;
    /**
     * 相关任务类型的关联id，type为账套时关联数据在 rel_course_task_account_set
     */
    private Long relId;
    /**
     * 任务类型
     */
    private Integer type;
    /**
     * 备注
     */
    private String remark;
    /**
     * 状态, 启用:1，停用:0
     */
    private Integer status;
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
     * 推荐账套ID集合
     */
    private List<Long> recommendAccountSetIds;
    /**
     * 可选账套ID集合
     */
    private List<Long> optionalAccountSetIds;
    /**
     * 资源ID集合
     */
    private List<Long> resIds;
    /**
     * 能力项ID集合
     */
    private List<Long> abilityIds;
    /**
     * 推荐账套集合
     */
    private List<AccountSetDTO> recommendAccountSetList;
    /**
     * 可选账套集合
     */
    private List<AccountSetDTO> optionalAccountSetList;
    /**
     * 资源集合
     */
    private List<Object> resList;
    /**
     * 能力项集合
     */
    private List<AbilityDTO> abilityList;
    /**
     * 关联对象名称，关联对象id对应 relId
     */
    private String relName;
    /**
     * 关联对象地址（音频、视频、图片），关联对象id对应 relId
     */
    private String relUrl;
    /**
     * 关联试卷id
     */
    private Long examPaperId;
    /**
     * 关联试卷
     */
    private ExamPaperDTO examPaperDTO;
    /**
     * 推荐学习时长（分钟）
     */
    private Integer recommendLearnTime;

}
