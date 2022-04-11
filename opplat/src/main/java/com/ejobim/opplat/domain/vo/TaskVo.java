package com.ejobim.opplat.domain.vo;

import com.ejobim.opplat.domain.TbEquipFaultInfo;
import com.ejobim.opplat.domain.TbTaskInfo;
import com.ejobim.opplat.domain.TbWorkTaskInfo;
import com.ejobim.opplat.util.DateUtils;
import org.apache.commons.lang3.StringUtils;

import java.util.HashMap;
import java.util.Map;

public class TaskVo {

    private String taskName;

    private String taskCode;

    private String finishTime;
    //type 1;填报 2:巡检 3;维修 4;维保 5:大修 6:防腐
    private Integer type;
    //type 1;填报 2:巡检 3;维修 4;维保 5:大修 6:防腐

    private String createUserName;
    // 0;完成 1:未完成 2:待完成 3超时完成
    private Integer status;

    private String statusName;

    private String taskNo;
    
    private String factoryNo;

    private String taskContent;

    //扩展信息
    private Map<String,Object> extendInfo;

    public String getTaskName() {
        return taskName;
    }

    public void setTaskName(String taskName) {
        this.taskName = taskName;
    }

    public String getFinishTime() {
        return finishTime;
    }

    public void setFinishTime(String finishTime) {
        this.finishTime = finishTime;
    }

    public Integer getType() {
        return type;
    }

    public void setType(Integer type) {
        this.type = type;
    }

    public String getCreateUserName() {
        return createUserName;
    }

    public void setCreateUserName(String createUserName) {
        this.createUserName = createUserName;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public String getStatusName() {
        if(status!=null){
            if(status==1){
                statusName="执行中";
            }else if(status==2){
                statusName="已完成";
            }else if(status==10 || status ==11){
                statusName="无法自修";
            }
            return statusName;
        }else{
            return "";
        }

    }

    public void setStatusName(String statusName) {
        this.statusName = statusName;
    }

    public String getTaskCode() {
        return taskCode;
    }

    public void setTaskCode(String taskCode) {
        this.taskCode = taskCode;
    }

    public String getTaskNo() {
        return taskNo;
    }

    public void setTaskNo(String taskNo) {
        this.taskNo = taskNo;
    }

    public String getFactoryNo() {
        return factoryNo;
    }

    public void setFactoryNo(String factoryNo) {
        this.factoryNo = factoryNo;
    }


    public  static TaskVo parseWorkTaskInfo(TbWorkTaskInfo workTaskInfo){
        TaskVo taskVo = new TaskVo();
        taskVo.setFactoryNo(workTaskInfo.getOrgNo());
        taskVo.setTaskCode(workTaskInfo.getTaskCode());
        taskVo.setType(workTaskInfo.getTaskType());
        if(StringUtils.isNotEmpty(workTaskInfo.getTaskName())){
            taskVo.setTaskName(workTaskInfo.getTaskName());
        }else{

        }

        taskVo.setStatus(workTaskInfo.getTaskStatus());
        taskVo.setCreateUserName(workTaskInfo.getCreateUserName());
        taskVo.setTaskNo(workTaskInfo.getTaskNo());
        taskVo.setFinishTime(DateUtils.formateDate(workTaskInfo.getRealFinishTime()));
        return taskVo;
    }

    public  static TaskVo parseRoutingErrorInfo(TbEquipFaultInfo equipFaultInfo){
        TaskVo taskVo = new TaskVo();
        taskVo.setFactoryNo(equipFaultInfo.getFactoryNo());
        taskVo.setType(-1);
        taskVo.setTaskName(equipFaultInfo.getEquipName());
        taskVo.setStatus(equipFaultInfo.getErrorStatus());
        taskVo.setCreateUserName(equipFaultInfo.getReportUserName());
        taskVo.setTaskNo(equipFaultInfo.getErrorNo());
        taskVo.setFinishTime(DateUtils.formateDate(equipFaultInfo.getUpdateTime()));
        if(equipFaultInfo.getDetailTaskNo()!=null){
            Map<String,Object> extendMap = new HashMap<>();
            extendMap.put("routingTaskDetailNo",equipFaultInfo.getDetailTaskNo());
        }
        return taskVo;
    }

    public Map<String, Object> getExtendInfo() {
        return extendInfo;
    }

    public void setExtendInfo(Map<String, Object> extendInfo) {
        this.extendInfo = extendInfo;
    }

    public String getTaskContent() {
        return taskContent;
    }

    public void setTaskContent(String taskContent) {
        this.taskContent = taskContent;
    }
}