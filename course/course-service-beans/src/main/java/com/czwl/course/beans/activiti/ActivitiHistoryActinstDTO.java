package com.czwl.course.beans.activiti;

import lombok.Data;
import lombok.NoArgsConstructor;
import com.czwl.base.BaseDTO;

/**
 * 所有节点历史纪录
 * @author: lzs
 * @create: 2020-04-01
 */
@Data
@NoArgsConstructor
public class ActivitiHistoryActinstDTO extends BaseDTO {

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
     * 类型
     */
    private  String  activitiType;
    /**
     * 开始时间
     */
    private  java.util.Date  startTime;
    /**
     * 结束时间
     */
    private  java.util.Date  endTime;
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
