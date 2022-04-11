package com.ejobim.opplat.service;

import com.ejobim.opplat.domain.OrgGroupInfo;
import com.ejobim.opplat.domain.TbGroupInfo;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author  xibian
 */

public interface GroupService {
    /**
     * 查询组团列表
     * @param groupInfo
     * @return
     */
    List<OrgGroupInfo> getGroupList(OrgGroupInfo groupInfo);

    int  updateGroup(OrgGroupInfo groupInfo);

    /**
     * 更新组团详情
     * @param id 组团ID
     * @param factoryNo 水厂编号
     * @param updateType 更新方式 1：新增 2：删除；3：设置中心水厂
     * @return
     */
    int  updateGroupDetail(Integer id,String factoryNo,int updateType);

}
