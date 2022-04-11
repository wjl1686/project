package com.ejobim.opplat.service;

import com.ejobim.opplat.domain.TbAppInfo;

import java.util.List;

public interface AppService {
    List<TbAppInfo> getAppInfoList();

    TbAppInfo getLastedAppInfo(String app_version,Integer appChannel);

    void testLock();
}
