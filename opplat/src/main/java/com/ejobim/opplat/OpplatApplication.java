package com.ejobim.opplat;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@SpringBootApplication
@EnableTransactionManagement  // 启注解事务管理，等同于xml配置方式的 <tx:annotation-driven />
@MapperScan(basePackages = "com.ejobim.opplat.mapper")
@EnableAsync
@EnableScheduling
public class OpplatApplication {

    public static void main(String[] args) {
        SpringApplication.run(OpplatApplication.class, args);
    }
}
