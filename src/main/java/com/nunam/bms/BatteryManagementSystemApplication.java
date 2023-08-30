package com.nunam.bms;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan("com.nunam.bms.*")
public class BatteryManagementSystemApplication {

    public static void main(String[] args) {

        System.out.println("Application Started..!!");
        SpringApplication.run(BatteryManagementSystemApplication.class, args);
    }

}
