package com.czwl.course.beans.accountset;

import com.czwl.base.BaseDTO;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

/**
 * 行业表
 *
 * @author: srg
 * @create: 2020-04-02
 */
@Data
@NoArgsConstructor
public class IndustryDTO extends BaseDTO {

    /**
     * 行业名称
     */
    private String name;
    /**
     * 上级行业
     */
    private Long pid;
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
