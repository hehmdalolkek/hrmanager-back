package com.hehmdalolkek.spring.hrmanager;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.security.servlet.SecurityAutoConfiguration;

@SpringBootApplication(exclude = SecurityAutoConfiguration.class)
public class HrManagerApplication {

    public static void main(String[] args) {
        SpringApplication.run(HrManagerApplication.class, args);
    }

}
