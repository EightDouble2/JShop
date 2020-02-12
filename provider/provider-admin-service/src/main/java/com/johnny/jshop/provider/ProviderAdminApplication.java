package com.johnny.jshop.provider;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import tk.mybatis.spring.annotation.MapperScan;

@SpringBootApplication
@MapperScan(basePackages = "com.johnny.jshop.provider.mapper")
public class ProviderAdminApplication {

    public static void main(String[] args) {
        SpringApplication.run(ProviderAdminApplication.class, args);
    }
}