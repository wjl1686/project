package com.czwl.course.beans.accountset;

import com.czwl.base.BaseDTO;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.DecimalMax;
import javax.validation.constraints.DecimalMin;
import javax.validation.constraints.NotNull;
import java.math.BigDecimal;
import java.util.Date;

/**
 * 上架信息
 *
 * @author: srg
 * @create: 2020-04-02
 */
@Data
@NoArgsConstructor
public class PutawayInfoDTO extends BaseDTO {

    /**
     * 业务id
     */
    private Long businessId;
    /**
     * 业务类型，例如：1：账套；
     */
    private Integer businessType;
    /**
     * 售卖方式，0：免费；1：付费；
     */
    private Integer sellWay;
    /**
     * 商品价格，保留2位小数
     */
    @NotNull
    @DecimalMin("0.00")
    @DecimalMax("9999999999.99")  //DECIMAL(12,2)
    private BigDecimal goodsPrice;
    /**
     * 划线价格，保留2位小数
     */
    @NotNull
    @DecimalMin("0.00")
    @DecimalMax("9999999999.99")
    private BigDecimal lineationPrice;
    /**
     * 有效期，单位：年
     */
    private Integer expiryDate;
    /**
     * 状态, 启用:1，停用:0
     */
    private Integer status;
    /**
     * 站点数
     */
    private Integer sitesSum;
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
