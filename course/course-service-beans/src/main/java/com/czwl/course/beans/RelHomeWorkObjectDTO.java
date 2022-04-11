package com.czwl.course.beans;

import lombok.Data;
import lombok.NoArgsConstructor;
import com.czwl.base.BaseDTO;

/**
 * 作业关联附件
 * @author: pengyongjian
 * @create: 2020-04-15
 */
@Data
@NoArgsConstructor
public class RelHomeWorkObjectDTO extends BaseDTO {

    /**
     * 作业id
     */
    private  Long  homeWorkId;
    /**
     * 作业类型:0主观；1客观；
     */
    private  Integer  type;
    /**
     * 试题id
     */
    private  Long  questionId;
    /**
     * 图片url
     */
    private  String  picUrl;
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
