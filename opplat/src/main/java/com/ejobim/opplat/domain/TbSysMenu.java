package com.ejobim.opplat.domain;

import com.fasterxml.jackson.annotation.JsonFormat;

import java.util.Date;
import java.util.List;

public class TbSysMenu {

    public static final int TYPE_MENU = 0;

    public static final int TYPE_BUTTON = 1;

    private List<TbSysMenu> children;

    private String menuNo;

    private String parentId;

    private String menuName;

    private String url;

    private String perms;

    private String icon;

    private Integer type;

    private Integer sort;

    private Date createTime;

    private Date modifyTime;

    private String status ;

    private boolean checked;

    private List<String> roleList;

    public boolean isChecked() {
        return checked;
    }

    public void setChecked(boolean checked) {
        this.checked = checked;
    }

    public String getMenuNo() {
        return menuNo;
    }

    public void setMenuNo(String menuNo) {
        this.menuNo = menuNo == null ? null : menuNo.trim();
    }

    public String getParentId() {
        return parentId;
    }

    public void setParentId(String parentId) {
        this.parentId = parentId == null ? null : parentId.trim();
    }

    public String getMenuName() {
        return menuName;
    }

    public void setMenuName(String menuName) {
        this.menuName = menuName == null ? null : menuName.trim();
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url == null ? null : url.trim();
    }

    public String getPerms() {
        return perms;
    }

    public void setPerms(String perms) {
        this.perms = perms == null ? null : perms.trim();
    }

    public String getIcon() {
        return icon;
    }

    public void setIcon(String icon) {
        this.icon = icon == null ? null : icon.trim();
    }

    public Integer getType() {
        return type;
    }

    public void setType(Integer type) {
        this.type = type;
    }

    public Integer getSort() {
        return sort;
    }

    public void setSort(Integer sort) {
        this.sort = sort;
    }
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public Date getModifyTime() {
        return modifyTime;
    }

    public void setModifyTime(Date modifyTime) {
        this.modifyTime = modifyTime;
    }


    public List<TbSysMenu> getChildren() {
        return children;
    }

    public void setChildren(List<TbSysMenu> children) {
        this.children = children;
    }


    public String getStatus() {
        if(this.children!=null&&this.children.size()>1)
            status = "close";
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public static int getTypeMenu() {
        return TYPE_MENU;
    }

    public static int getTypeButton() {
        return TYPE_BUTTON;
    }

    public List<String> getRoleList() {
        return roleList;
    }

    public void setRoleList(List<String> roleList) {
        this.roleList = roleList;
    }
}