package com.ejobim.opplat.service;

import com.ejobim.opplat.domain.TbFacilityInfo;
import com.ejobim.opplat.domain.TbFacilityParam;
import com.ejobim.opplat.domain.TbGongyiInfo;
import com.ejobim.opplat.domain.TbUser;

import java.util.List;

/**
 * 设施服务
 */
public interface FacilityService {

    /**
     * 获取列表
     * @param facilityInfo
     * @return
     */
    List<TbFacilityInfo> getFacilityList(TbFacilityInfo facilityInfo);

    /**
     * 新增设施
     * @param facilityInfo
     * @return
     */
    int saveTbFacilityInfo(TbFacilityInfo facilityInfo, TbUser user);

    /**
     * 删除
     * @param facilityInfo
     * @return
     */
    int deleteTbFacilityInfo(TbFacilityInfo facilityInfo);

    /**
     * 获取设施参数列表
     * @param facilityParam
     * @return
     */
    List<TbFacilityParam> getFacilityParamList(TbFacilityParam facilityParam);

    /**
     * 保存设施参数
     * @param tbFacilityParam
     * @return
     */
    int saveTbFacilityParam(TbFacilityParam tbFacilityParam);

    /**
     * 删除
     * @param tbFacilityParam
     * @return
     */
    int deleteTbFacilityParam(TbFacilityParam tbFacilityParam);


    /**
     * 工艺段列表
     * @param gongyiInfo
     * @return
     */
    List<TbGongyiInfo> getGongyiList(TbGongyiInfo gongyiInfo);

    /**
     * 保存工艺段
     * @param gongyiInfo
     * @return
     */
    int saveGongyiInfo(TbGongyiInfo gongyiInfo, TbUser user);

    /**
     * 修改工艺段
     * @param gongyiInfo
     * @return
     */
    int deleteGongyiInfo(TbGongyiInfo gongyiInfo);
}

