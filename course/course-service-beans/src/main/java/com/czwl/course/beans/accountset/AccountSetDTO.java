package com.czwl.course.beans.accountset;

import com.czwl.base.BaseDTO;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

/**
 * 账套表
 *
 * @author: srg
 * @create: 2020-04-02
 */
@Data
@NoArgsConstructor
public class AccountSetDTO extends BaseDTO {

    /**
     * 账套编码
     */
    private String code;
    /**
     * 企业名称
     */
    private String enterpriseName;
    /**
     * 税号
     */
    private String taxNo;
    /**
     * 启用期间：年
     */
    private Integer periodYear;
    /**
     * 启用期间：月
     */
    private Integer periodMonth;
    /**
     * 会计制度key
     */
    private String accSysKey;
    /**
     * 纳税人类型，1:增值税一般纳税人；2:增值税小规模纳税人；
     */
    private Integer taxpayerType;
    /**
     * 地区：省
     */
    private String areaProvince;
    /**
     * 地区：市
     */
    private String areaCity;
    /**
     * 地区：县/区
     */
    private String areaCounty;
    /**
     * 地区：详细地址
     */
    private String areaDetail;
    /**
     * 所属行业id
     */
    private Long industryId;
    /**
     * 难易程度，1：高级；2：中级；3：初级
     */
    private Integer complexity;
    /**
     * 岗位类型，1：单人全岗；2：多人多岗；
     */
    private Integer postType;
    /**
     * 推荐课时
     */
    private Integer recommendHour;
    /**
     * 账套简介
     */
    private String introduction;
    /**
     * 审核驳回理由
     */
    private String rejectReason;
    /**
     * 审核上架状态
     */
    private Integer state;
    /**
     * 状态, 启用:1，停用:0
     */
    private Integer status;
    /**
     * 可见范围 0：私有；1：内部公开；2：公开， 默认0私有
     */
    private Integer scope;
    /**
     * 排序号
     */
    private Integer sort;
    /**
     * 创建人
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

}
