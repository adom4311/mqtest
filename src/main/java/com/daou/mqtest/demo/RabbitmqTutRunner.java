package com.daou.mqtest.demo;

import com.daou.mqtest.demo.mq.MqConfTut1;
import com.daou.mqtest.demo.receiver.Tut1Receiver;
import com.daou.mqtest.demo.sender.Tut1Sender;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Profile;

public class RabbitmqTutRunner implements CommandLineRunner {

    @Value("${tutorial.client.duration:1000}")
    private int duration;



    @Autowired
    private ConfigurableApplicationContext ctx;



    @Override
    public void run(String... args) throws Exception {

        System.out.println("Ready .. running for " + duration + "ms");
        Thread.sleep(duration);
        ctx.close();
    }
}
