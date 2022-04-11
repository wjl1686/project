package com.ejobim.opplat.common.page;

import java.util.List;

public class Page {
    private int page;     //当前第几页
    private List<Object> rows;     //每页显示记录数

    public Page(int page, List<Object> rows){
        this.page = page;
        this.rows = rows;
    }


    public List<Object> getRows() {
        return rows;
    }

    public void setRows(List<Object> rows) {
        this.rows = rows;
    }

    public int getPage() {
        return page;
    }

    public void setPage(int page) {
        this.page = page;
    }
}
