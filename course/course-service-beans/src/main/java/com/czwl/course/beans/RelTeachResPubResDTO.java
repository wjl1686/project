package com.czwl.course.beans;

import lombok.Data;
import lombok.NoArgsConstructor;
import com.czwl.base.BaseDTO;

/**
 * 课程资源（教学资源）与物理上传资源关系表
 * @author: dlj
 * @create: 2020-03-12
 */
@Data
@NoArgsConstructor
public class RelTeachResPubResDTO extends BaseDTO {

    /**
     * 物理资源id
     */
    private  Long  pubResId;
    /**
     * 课程(教学)资源id
     */
    private  Long  teachResId;
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
