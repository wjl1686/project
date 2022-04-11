package com.ejobim.opplat.domain.vo;

import com.ejobim.opplat.domain.TbRoutingTask;

import java.util.List;

public class TbRoutingTaskVo {
    //完成的
    private List<TbRoutingTask> finishList;
    //正在进行的
    private List<TbRoutingTask> currentList;
    //接下来的
    private List<TbRoutingTask>  nextList;


    public List<TbRoutingTask> getFinishList() {
        return finishList;
    }

    public void setFinishList(List<TbRoutingTask> finishList) {
        this.finishList = finishList;
    }

    public List<TbRoutingTask> getCurrentList() {
        return currentList;
    }

    public void setCurrentList(List<TbRoutingTask> currentList) {
        this.currentList = currentList;
    }

    public List<TbRoutingTask> getNextList() {
        return nextList;
    }

    public void setNextList(List<TbRoutingTask> nextList) {
        this.nextList = nextList;
    }
    
}