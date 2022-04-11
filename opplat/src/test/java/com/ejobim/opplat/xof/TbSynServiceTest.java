package com.ejobim.opplat.xof;

import com.ejobim.opplat.rest.HollySys;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

/**
 * 模型同步测试类
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class TbSynServiceTest {

    @Autowired
    HollySys hollySys;

    @Test
    public  void  getFactroyTreeTest(){
        hollySys.getFactoryTree("/Hollysys_Bewg_modelNew2/5cb7d2087ec0fa0007383cdc","5cb7d2087ec0fa0007383cdc",2);
    }

}
