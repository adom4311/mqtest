package com.daou.mqtest.demo;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Profile;
import org.springframework.scheduling.annotation.EnableScheduling;

@SpringBootApplication
@EnableScheduling
public class DemoApplication {

    @Profile("!usage_message")
    @Bean
    public CommandLineRunner tutorial() {
        return new RabbitmqTutRunner();
    }


    public static void main(String[] args) throws Exception{
        SpringApplication.run(DemoApplication.class, args);
    }


}
