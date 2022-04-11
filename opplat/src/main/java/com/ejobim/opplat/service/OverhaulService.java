package com.ejobim.opplat.service;

import com.ejobim.opplat.domain.*;

import java.util.Date;
import java.util.List;

public interface OverhaulService {


    List<TbEquipTaskFile> getFileList(TbEquipTaskFile overhaulTaskFile);

    int addTaskFile(TbEquipTaskFile overhaulTaskFile);

    int deleteTaskFile(TbEquipTaskFile overhaulTaskFile);



}
