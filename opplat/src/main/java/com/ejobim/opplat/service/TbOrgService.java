package com.ejobim.opplat.service;


import com.ejobim.opplat.domain.TbOrg;

import java.util.List;

public interface TbOrgService {

    List<TbOrg> selectOrgInfoByObject(TbOrg tbOrg);

    TbOrg getFactoryOrg(String factoryNo);
}
