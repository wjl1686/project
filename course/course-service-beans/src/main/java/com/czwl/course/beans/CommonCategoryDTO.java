package com.czwl.course.beans;

import com.czwl.base.service.TreeNode;
import lombok.Data;
import lombok.NoArgsConstructor;
import com.czwl.base.BaseDTO;

import java.util.List;

/**
 * 公共分类
 * @author: pengyongjian
 * @create: 2020-03-10
 */
@Data
@NoArgsConstructor
public class CommonCategoryDTO extends BaseDTO implements TreeNode {

    /**
     * 父节点主键
     */
    private  Long  pid;
    /**
     * 父名称
     */
    private  String  pName;
    /**
     * 父名称集合
     */
    private  List<String>  pNameList;
    /**
     * 名称
     */
    private  String  name;
    /**
     * 名称集合
     */
    private  List<String>  nameList;
    /**
     * 分类码
     */
    private  String  code;
    /**
     * 状态, 启用:0，停用:1，删除:2
     */
    private Integer status;
    /**
     * 业务类型，0=公共分类，1=证书分类，2=职位分类，3=行业分类，4=专业分类，5=证书分类-简历
     */
    private  Integer  type;
    /**
     * 排序
     */
    private  Integer  sort;
    /**
     * 所属对象主键，0=公有，非0=其他的业务id
     */
    private  Long  objectId;
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
    /**
     * 修改时间
     */
    private  List<CommonCategoryDTO>  children;


    @Override
    public List getChildren() {
        return children;
    }

    @Override
    public void setChildren(List children) {
        this.children = children;
    }
}
