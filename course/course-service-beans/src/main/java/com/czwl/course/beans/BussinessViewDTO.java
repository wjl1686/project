package com.czwl.course.beans;

import lombok.Data;
import lombok.NoArgsConstructor;
import com.czwl.base.BaseDTO;

/**
 * 业务视图
 * @author: xssxss
 * @create: 2020-06-22
 */
@Data
@NoArgsConstructor
public class BussinessViewDTO extends BaseDTO {

    /**
     * 实体名称
     */
    private  String  name;
    /**
     * 编码
     */
    private  String  code;
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
     * 链接地址
     */
    private  String  url;
    /**
     * 视图类型，0：交互界面，1：常用控件
     */
    private  Integer  viewType;
    /**
     * 视图备注
     */
    private  String  note;
    /**
     * 是否删除，0：false，1：true
     */
    private  Integer  isDelete;
 
      
}
