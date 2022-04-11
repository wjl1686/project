package com.czwl.course.beans;

import com.czwl.base.BaseDTO;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

/**
 * 课程资源
 *
 * @author: dlj
 * @create: 2020-03-10
 */
@Data
@NoArgsConstructor
public class TeachResDTO extends BaseDTO {

    /**
     * 资源code
     */
    private String code;
    /**
     * 可见范围 0：私有；1：内部公开；2：公开， 默认0私有
     */
    private Integer scope;
    /**
     * 资源名称
     */
    private String name;
    /**
     * 物理资源id
     */
    private Long pubResId;
    /**
     * 资源类型，WORD=文档，PIC=图片，VIDEO=视频，AUDIO=音频；
     */
    private String resType;
    /**
     * 物理资源格式
     */
    private String resSwf;
    /**
     * 物理资源下载地址
     */
    private String resUrl;
    /**
     * 资源封面图片
     */
    private String coverImg;
    /**
     * 资源简介
     */
    private String content;
    /**
     * 状态:0停用;1启用
     */
    private Integer status;
    /**
     * 所属分类Id
     */
    private Long commonCategoryId;
    /**
     * 所属分类名称
     */
    private String categoryName;
    /**
     * 公共资源ids和名称集合
     */
    private List<ResIdsAndNamesDTO> resIdsAndNames;
    /**
     * 创建人id
     */
    private Long creator;
    /**
     * 创建时间
     */
    private Date createTime;
    /**
     * 修改人
     */
    private Long modifier;
    /**
     * 修改时间
     */
    private Date modifyTime;
    /**
     * 上架状态(scope公开才有用),commonStateEnum
     */
    private Integer state;
    /**
     * 审核不通过原因
     */
    private String refusalCause;
    /**
     * 被关联次数
     */
    private Integer cited;
    /**
     * 文件格式
     */
    private String fileLayout;

    /************定价相关 start************/
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
    /************定价相关 end************/

    /**
     * 创建人name
     */
    private String creatorName;

    /**
     * 转换状态
     */
    private Integer resStatus;

}
