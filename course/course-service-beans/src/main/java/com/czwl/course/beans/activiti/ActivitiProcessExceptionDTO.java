package com.czwl.course.beans.activiti;

import lombok.Data;
import lombok.NoArgsConstructor;
import com.czwl.base.BaseDTO;

/**
 * 运行实例执行实例
 * @author: lzs
 * @create: 2020-04-01
 */
@Data
@NoArgsConstructor
public class ActivitiProcessExceptionDTO extends BaseDTO {

    /**
     * 运行实例ID
     */
    private  Long  processInstanceId;
    /**
     * 父节点运行实例ID
     */
    private  Long  processExceptionId;
    /**
     * 流程定义id
     */
    private  String  processDefinitionId;
    /**
     * 业务ID
     */
    private  Long  bussinessId;
    /**
     * 用户id
     */
    private Long userId;
    /**
     * 业务类型
     */
    private  String  bussinessType;
    /**
     * 节点ID
     */
    private  String  activitiId;
    /**
     * 是否存活,1:是，0：否
     */
    private  Integer  isActive;
    /**
     * 是否并行，1:是，0:否
     */
    private  Integer  isConcurrent;
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
