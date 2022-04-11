package com.czwl.course.beans;

import com.czwl.base.BaseDTO;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

/**
 * 公共岗位
 *
 * @author: srg
 * @create: 2020-03-11
 */
@Data
@NoArgsConstructor
public class PubPostDTO extends BaseDTO {

    /**
     * 岗位编码
     */
    private String code;
    /**
     * 所属分类Id
     */
    private  Long  commonCategoryId;
    /**
     * 类型名称
     */
    private String commonCategoryName;
    /**
     * 岗位名称
     */
    private String name;
    /**
     * 岗位职责描述
     */
    private String description;
    /**
     * 所属对象主键，0=公有，非0=其他的业务id
     */
    private  Long  objectId;
    /**
     * 岗位画像
     */
    private String img;
    /**
     * 状态, 启用:1，停用:0
     */
    private Integer status;
    /**
     * 创建人
     */
    private Long creator;

    /**
     * 创建者名称
     */
    private String creatorName;
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
