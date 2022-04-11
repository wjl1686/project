package com.czwl.course.beans.infrastructure;

import lombok.Data;
import lombok.NoArgsConstructor;
import com.czwl.base.BaseDTO;

import java.util.List;

/**
 * 考核模型
 * @author: pengyongjian
 * @create: 2020-07-09
 */
@Data
@NoArgsConstructor
public class ExamineModelDTO extends BaseDTO {

    /**
     * 编码
     */
    private  String  code;
    /**
     * 名称
     */
    private  String  name;
    /**
     * 关联对象id
     */
    private  Long  relId;
    /**
     * 类型:1课程考核模型
     */
    private  Integer  type;
    /**
     * 总分
     */
    private  Integer  totalScore;
    /**
     * 状态, 启用:0，停用:1，删除:2
     */
    private  Integer  status;
    /**
     * 状态：0编辑中；1完成
     */
    private  Integer  state;
    /**
     * 考核项列表
     */
    private List<ExamineModelDetailDTO> examineModelDetailDTOS;
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
