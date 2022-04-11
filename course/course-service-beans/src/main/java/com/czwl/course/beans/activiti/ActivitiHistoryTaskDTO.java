package com.czwl.course.beans.activiti;

import lombok.Data;
import lombok.NoArgsConstructor;
import com.czwl.base.BaseDTO;

/**
 * 实例任务历史
 * @author: lzs
 * @create: 2020-04-01
 */
@Data
@NoArgsConstructor
public class ActivitiHistoryTaskDTO extends BaseDTO {

    /**
     * 所属实例id
     */
    private  Long  processInstanceId;
    /**
     * 执行实例id
     */
    private  Long  processExceptionId;
    /**
     * 流程定义id
     */
    private  String  processDefinitionId;
    /**
     * 节点id
     */
    private  String  activitiId;
    /**
     * 名称
     */
    private  String  name;
    /**
     * 描述
     */
    private  String  description;
    /**
     * 开始时间
     */
    private  java.util.Date  startTime;
    /**
     * 结束时间
     */
    private  java.util.Date  entTime;
    /**
     * 时长
     */
    private  java.util.Date  duration;
    /**
     * 创建人
     */
    private  Long  creator;
    /**
     * 创建时间
     */
    private  java.util.Date  createTime;
    /**
     * 修改人
     */
    private  Long  modifier;
    /**
     * 修改时间
     */
    private  java.util.Date  modifyTime;
 
      
}
