package com.czwl.course.beans.activiti;

import lombok.Data;
import lombok.NoArgsConstructor;
import com.czwl.base.BaseDTO;

/**
 * 用户流程关联表
 * @author: lzs
 * @create: 2020-04-01
 */
@Data
@NoArgsConstructor
public class ActivitiUserDTO extends BaseDTO {

    /**
     * 用户id
     */
    private  Long  userId;
    /**
     * 流程定义key
     */
    private  String  processDefinitionKey;
    /**
     * 流程定义id
     */
    private  String  processDefinitionId;
    /**
     * 流程实例id
     */
    private  Long  processInstanceId;
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
