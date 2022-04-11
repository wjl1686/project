package com.ejobim.opplat.xof;

import com.ejobim.opplat.domain.TbUser;
import com.ejobim.opplat.service.EquipService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class EquipServiceTest {
    @Autowired
    EquipService equipService;

    @Test
    public void changeEquipStatus(){
        TbUser user = new TbUser();
        user.setCode("155590456092000014");
        //quipService.changeEquipStatus("5c6f6dac1c5fda0001211de0",0,user);
        System.out.println(equipService.getEquipRunTime("5c6f6dac1c5fda0001211de0"));
    }
}
