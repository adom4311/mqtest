package com.daou.mqtest.demo.sender;

import org.springframework.amqp.core.Queue;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;

public class Tut1Sender {

    @Autowired
    private RabbitTemplate rabbitTemplate;

    @Autowired
    private Queue queue;

    @Scheduled(fixedDelay = 1000, initialDelay = 50)
    public void send(){
        String message = "Hello world";
        System.out.println("name:"+queue.getName() + "| actualname:"+queue.getActualName());
        this.rabbitTemplate.convertAndSend(queue.getName(), message);
        System.out.println("[x] send '"+ message + "'");
    }
}
