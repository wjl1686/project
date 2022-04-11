package com.czwl.course.beans.activiti;

import lombok.Data;
import lombok.NoArgsConstructor;
import com.czwl.base.BaseDTO;

/**
 * 历史运行实例
 * @author: lzs
 * @create: 2020-04-01
 */
@Data
@NoArgsConstructor
public class ActivitiHistoryProcessExceptionDTO extends BaseDTO {

    /**
     * 运行实例ID
     */
    private  Long  processInstanceId;
    /**
     * 业务ID
     */
    private  Long  bussinessId;
    /**
     * 业务类型
     */
    private  String  bussinessType;
    /**
     * 流程定义ID
     */
    private  String  processDefinitionId;
    /**
     * 开始时间
     */
    private  java.util.Date  startTime;
    /**
     * 结束时间
     */
    private  java.util.Date  endTime;
    /**
     * 运行总时常
     */
    private  Long  duration;
    /**
     * 发起用户id
     */
    private  Long  startUserId;
    /**
     * 开始节点id
     */
    private  String  startActivitiId;
    /**
     * 结束节点id
     */
    private  String  endActivitiId;
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
