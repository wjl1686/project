package com.ejobim.opplat.wjl;

import com.ejobim.opplat.service.AppService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.concurrent.CountDownLatch;

@Component
public class Ticket implements Runnable {
    private static final int USER_NUMMS = 200;

    @Autowired
    private AppService appService;
    //定时并发
    private static CountDownLatch cdl = new CountDownLatch(USER_NUMMS);
    @Override
    public void run() {
        try {
            cdl.await();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        appService.testLock();
    }
}
