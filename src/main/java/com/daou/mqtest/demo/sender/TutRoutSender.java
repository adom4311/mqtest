package com.daou.mqtest.demo.sender;

import org.springframework.amqp.core.DirectExchange;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;

import java.util.concurrent.atomic.AtomicInteger;

public class TutRoutSender {
    @Autowired
    private RabbitTemplate template;

    @Autowired
    private DirectExchange direct;

    AtomicInteger index = new AtomicInteger(0);
    AtomicInteger count = new AtomicInteger(0);

    private final String[] keys = {"orange,", "black", "green", "brown"};

    @Scheduled(fixedDelay = 1000, initialDelay = 500)
    public void send(){
        StringBuilder builder = new StringBuilder("Hello to ");
        if(this.index.incrementAndGet()==4){
            this.index.set(0);
        }
        String key = keys[this.index.get()];
        builder.append(key).append(' ');
        builder.append(this.count.get());
        String message = builder.toString();
        template.convertAndSend(direct.getName(), key, message);
        System.out.println("[x] sent '" + message + "'");
    }
}
