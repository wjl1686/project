package com.czwl.course.beans;

import lombok.Data;
import lombok.NoArgsConstructor;
import com.czwl.base.BaseDTO;

/**
 * 作业关联附件
 * @author: pengyongjian
 * @create: 2020-04-16
 */
@Data
@NoArgsConstructor
public class RelWorkBookQuestionDTO extends BaseDTO {

    /**
     * 作业id
     */
    private  Long  workBookId;
    /**
     * 试题id
     */
    private  Long  questionId;
    /**
     * 选项排序
     */
    private  Integer  sort;
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
