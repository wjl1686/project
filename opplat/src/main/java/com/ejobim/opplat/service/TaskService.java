package com.ejobim.opplat.service;

import com.ejobim.opplat.domain.TbUser;
import com.ejobim.opplat.domain.vo.TaskInfoVo;

import java.util.List;

/**
 * @author  xibian
 * 任务工单处理
 */
public interface TaskService {

    /**
     * 根据设备编号获取设备上归属的任务
     * @param equipNo
     * @param user
     * @return
     */
    List<TaskInfoVo> getTaskInfoByEquipNo(TbUser user, String equipNo);

    /**
     * 获取巡检点下的设备列表和
     * @param LoctionNo
     * @param user
     * @return
     */
    List<TaskInfoVo> getTaskInfoListByLocationNo(TbUser user,String LoctionNo);

}


