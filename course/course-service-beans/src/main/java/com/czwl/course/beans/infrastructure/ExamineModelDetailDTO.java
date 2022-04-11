package com.czwl.course.beans.infrastructure;

import com.czwl.base.service.TreeNode;
import lombok.Data;
import lombok.NoArgsConstructor;
import com.czwl.base.BaseDTO;

import java.util.List;

/**
 * 考核项
 * @author: pengyongjian
 * @create: 2020-07-09
 */
@Data
@NoArgsConstructor
public class ExamineModelDetailDTO extends BaseDTO implements TreeNode<ExamineModelDetailDTO> {

    /**
     * 考核模型id
     */
    private  Long  examineModelId;
    /**
     * 编码
     */
    private  String  code;
    /**
     * 名称
     */
    private  String  name;
    /**
     * 父节点id
     */
    private  Long  pid;
    /**
     * 权重：0-100
     */
    private  Integer  weight;
    /**
     * 类型:1团队，2个人
     */
    private  Integer  type;
    /**
     * 状态, 启用:0，停用:1，删除:2
     */
    private  Integer  status;
    /**
     * 子节点集合
     */
    private  List<ExamineModelDetailDTO>  children;
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


    @Override
    public List<ExamineModelDetailDTO> getChildren() {
        return children;
    }

    @Override
    public void setChildren(List<ExamineModelDetailDTO> children) {
        this.children = children;
    }
}
