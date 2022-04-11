package com.czwl.course.beans.activiti;

import lombok.Data;
import lombok.NoArgsConstructor;
import com.czwl.base.BaseDTO;

/**
 * 实例运行时任务表
 * @author: lzs
 * @create: 2020-04-01
 */
@Data
@NoArgsConstructor
public class ActivitiRunTaskDTO extends BaseDTO {

    /**
     * 执行实例id
     */
    private  Long  processExecptionId;
    /**
     * 所属实例id
     */
    private  Long  processInstanceId;
    /**
     * 流程定义id
     */
    private  String  processDefinitionId;
    /**
     * 任务名称
     */
    private  String  name;
    /**
     * 描述
     */
    private  String  description;
    /**
     * 节点ID
     */
    private  String  activitiId;
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
