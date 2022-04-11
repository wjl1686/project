package com.ejobim.opplat.service;

import com.ejobim.opplat.domain.TbMedicine;
import com.ejobim.opplat.domain.TbMedicineDict;
import com.ejobim.opplat.domain.TbSynObject;

import java.util.List;

/**
 * @author wujianlong
 * @Description: TODO
 * @date 2019/2/20 16:24
 */
public interface TbMedicineService {
    void addMedicine(List<String> mids,List<String> uris,String factoryNO,String username);

    List<TbMedicine> findMedicineList(TbMedicine tbMedicine);

    void deleteWarn(String[] medicineNos);

    List<TbMedicineDict> findMedicineDictList(TbMedicineDict tbMedicine);

    List<TbSynObject> findSynObjectList(String factoryNo);
}
