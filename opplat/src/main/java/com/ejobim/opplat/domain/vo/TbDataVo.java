package com.ejobim.opplat.domain.vo;

import com.ejobim.opplat.domain.TbSchedulingPlan;
import com.ejobim.opplat.domain.TbWorkTaskInfo;

import java.util.List;

public class TbDataVo {
    //排班班组列表
    private List<TbSchedulingPlan> runList;
    //排班班组列表
    private List<TbSchedulingPlan> equipList;
    //工单信息
    private List<TbWorkTaskInfo> weixiuList;

    private List<TbWorkTaskInfo> weibaoList;

    private List<TbWorkTaskInfo> fangfuList;

    private List<TbWorkTaskInfo> daxiuList;

    private List<TbWorkTaskInfo> gongyiList;

    public List<TbSchedulingPlan> getRunList() {
        return runList;
    }

    public void setRunList(List<TbSchedulingPlan> runList) {
        this.runList = runList;
    }

    public List<TbSchedulingPlan> getEquipList() {
        return equipList;
    }

    public void setEquipList(List<TbSchedulingPlan> equipList) {
        this.equipList = equipList;
    }

    public List<TbWorkTaskInfo> getWeixiuList() {
        return weixiuList;
    }

    public void setWeixiuList(List<TbWorkTaskInfo> weixiuList) {
        this.weixiuList = weixiuList;
    }

    public List<TbWorkTaskInfo> getWeibaoList() {
        return weibaoList;
    }

    public void setWeibaoList(List<TbWorkTaskInfo> weibaoList) {
        this.weibaoList = weibaoList;
    }

    public List<TbWorkTaskInfo> getFangfuList() {
        return fangfuList;
    }

    public void setFangfuList(List<TbWorkTaskInfo> fangfuList) {
        this.fangfuList = fangfuList;
    }

    public List<TbWorkTaskInfo> getDaxiuList() {
        return daxiuList;
    }

    public void setDaxiuList(List<TbWorkTaskInfo> daxiuList) {
        this.daxiuList = daxiuList;
    }

    public List<TbWorkTaskInfo> getGongyiList() {
        return gongyiList;
    }

    public void setGongyiList(List<TbWorkTaskInfo> gongyiList) {
        this.gongyiList = gongyiList;
    }
}