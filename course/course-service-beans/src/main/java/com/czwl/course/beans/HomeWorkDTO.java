package com.czwl.course.beans;

import com.czwl.base.BaseDTO;
import com.czwl.exam.beans.QuestionDTO;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.util.List;

/**
 * 作业
 *
 * @author: pengyongjian
 * @create: 2020-04-15
 */
@Data
@NoArgsConstructor
public class HomeWorkDTO extends BaseDTO {

    /**
     * 名称
     */
    private String name;
    /**
     * 封面图片
     */
    private  String  coverImg;
    /**
     * 作业描述
     */
    private String description;

    /**
     * 审核驳回理由
     */
    private String rejectReason;

    /**
     * 分类码
     */
    private String code;
    /**
     * 状态:0停用;1启用
     */
    private Integer status;
    /**
     * 作业类型:0主观；1客观；
     */
    private Integer type;

    /**
     * （客观）题目生成方式：0随机；1顺序
     */
    private Integer generateType;
    /**
     * （客观）题目数
     */
    private Integer generateNum;
    /**
     * 可见范围：0私有；1内部可见；2公开
     */
    private Integer scope;

    /**
     * 上下架状态
     */
    private Integer state;

    /**
     * 所属对象主键
     */
    private Long objectId;
    /**
     * 创建人
     */
    private Long creator;
    /**
     * 创建时间
     */
    private java.util.Date createTime;
    /**
     * 修改人
     */
    private Long modifier;
    /**
     * 修改时间
     */
    private java.util.Date modifyTime;
    /**
     * 图片
     */
    private String[] picUrls;
    /**
     * 作业子项列表
     */
    private Long[] questionIds;
    /**
     * 作业子项列表
     */
    private List<RelHomeWorkObjectDTO> homeWorkObjects;
    /**
     * 作业试题列表
     */
    private List<QuestionDTO> questions;
    /**
     * 单选题分数
     */
    private java.math.BigDecimal singleScore;
    /**
     * 单选题列表
     */
    private List<QuestionDTO> singleQuestions;
    /**
     * 多选题分数
     */
    private java.math.BigDecimal multiScore;
    /**
     * 多选题列表
     */
    private List<QuestionDTO> multiQuestions;
    /**
     * 判断题分数
     */
    private java.math.BigDecimal judgeScore;
    /**
     * 判断题列表
     */
    private List<QuestionDTO> judgeQuestions;


    /**
     * 主观问答题分数
     */
    private java.math.BigDecimal subjectiveScore;
    /**
     * 主观问答题列表
     */
    private List<QuestionDTO> subjectiveQuestions;

    /**
     * 售卖方式，0：免费；1：付费；
     */
    private Integer sellWay;
    /**
     * 商品价格，保留2位小数
     */
    private BigDecimal goodsPrice;
    /**
     * 划线价格，保留2位小数
     */
    private BigDecimal lineationPrice;

}
