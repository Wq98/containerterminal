package com.example;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan("com.example.mapper")
public class ContainerterminalEquipmentApplication {

    public static void main(String[] args) {
        SpringApplication.run(ContainerterminalEquipmentApplication.class, args);
    }

}
