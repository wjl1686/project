package com.czwl.course.beans.activiti;

import lombok.Data;
import lombok.NoArgsConstructor;
import com.czwl.base.BaseDTO;

/**
 * 流程定义与表单数据关系表
 * @author: lzs
 * @create: 2020-04-01
 */
@Data
@NoArgsConstructor
public class ActivitiProcessDataDTO extends BaseDTO {

    /**
     * 流程定义key
     */
    private  String  processDefinitionKey;
    /**
     * 流程定义id
     */
    private  String  processDefinitionId;
    /**
     * 任务id
     */
    private Long taskId;
    /**
     * 流程部署id
     */
    private String deploymentId;
    /**
     * 流程表单数据
     */
    private  String  formData;
    /**
     * 流程内容
     */
    private String xmlData;
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
