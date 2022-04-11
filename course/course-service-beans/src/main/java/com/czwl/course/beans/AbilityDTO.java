package com.czwl.course.beans;

import com.czwl.base.BaseDTO;
import com.czwl.base.service.TreeNode;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;
import java.util.List;

/**
 * 能力模型
 *
 * @author: srg
 * @create: 2020-03-11
 */
@Data
@NoArgsConstructor
public class AbilityDTO extends BaseDTO implements TreeNode<AbilityDTO> {

    /**
     * 能力编码
     */
    private String code;
    /**
     * 能力名称
     */
    private String name;
    /**
     * 父节点id
     */
    private Long pid;
    /**
     * 父节点名称
     */
    private String pName;
    /**
     * 状态, 启用:1，停用:0
     */
    private Integer status;
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
    /**
     * 树形子集合
     */
    private List<AbilityDTO> children;


    @Override
    public List<AbilityDTO> getChildren() {
        return children;
    }

    @Override
    public void setChildren(List children) {
        this.children = children;
    }

    /**
     * 范围：公有0 私有1
     */
    private Integer type;
}
