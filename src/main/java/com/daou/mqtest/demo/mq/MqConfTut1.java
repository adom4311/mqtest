package com.daou.mqtest.demo.mq;

import com.daou.mqtest.demo.receiver.Tut1Receiver;
import com.daou.mqtest.demo.sender.Tut1Sender;
import org.springframework.amqp.core.Queue;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

@Profile({"tut1","hello-world"})
@Configuration
public class MqConfTut1 {

    @Bean
    public Queue hello(){
        return new Queue("hello");
    }

    @Profile("receiver")
    @Bean
    public Tut1Receiver receiver(){
        return new Tut1Receiver();
    }

    @Profile("sender")
    @Bean
    public Tut1Sender sender(){
        return new Tut1Sender();
    }
}
