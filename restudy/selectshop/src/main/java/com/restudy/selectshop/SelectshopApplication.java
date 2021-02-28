package com.restudy.selectshop;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@EnableJpaAuditing
@SpringBootApplication
public class SelectshopApplication {

    public static void main(String[] args) {
        SpringApplication.run(SelectshopApplication.class, args);
    }

}
