package org.huangding.redismqregister;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@SpringBootApplication(scanBasePackages = "org.huangding.redismqregister")
//mybatis
@MapperScan("org.huangding.redismqregister.dao")
@EnableSwagger2
//缓存
@EnableCaching
public class RedisMqRegisterApplication {

    public static void main(String[] args) {
        SpringApplication.run(RedisMqRegisterApplication.class, args);
    }
}
