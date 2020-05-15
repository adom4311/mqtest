package com.daou.mqtest.demo;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class DemoApplication {

    @Bean
    public CommandLineRunner tutorial(){return new RabbitmqTutRunner();}

    public static void main(String[] args) {
        SpringApplication.run(DemoApplication.class, args);
    }


}
