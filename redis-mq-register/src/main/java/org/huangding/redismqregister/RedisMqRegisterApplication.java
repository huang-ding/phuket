package org.huangding.redismqregister;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@SpringBootApplication(scanBasePackages = "org.huangding.redismqregister")
@MapperScan("org.huangding.redismqregister.dao")
@EnableSwagger2
public class RedisMqRegisterApplication {

    public static void main(String[] args) {
        SpringApplication.run(RedisMqRegisterApplication.class, args);
    }
}
