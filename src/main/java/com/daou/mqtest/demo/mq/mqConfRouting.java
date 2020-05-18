package com.daou.mqtest.demo.mq;

import com.daou.mqtest.demo.receiver.TutRoutReceiver;
import com.daou.mqtest.demo.sender.TutRoutSender;
import org.springframework.amqp.core.*;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

@Profile({"routing"})
@Configuration
public class mqConfRouting {

    @Bean
    public DirectExchange direct(){
        return new DirectExchange("tut.direct");
    }

    @Profile("receiver")
    private static class ReceiverConfig{

        @Bean
        public Queue autoDeleteQueue1(){
            return new AnonymousQueue();
        }

        @Bean
        public Queue autoDeleteQueue2(){
            return new AnonymousQueue();
        }

        @Bean
        public Binding bindingOrange(DirectExchange direct, Queue autoDeleteQueue1){
            return BindingBuilder.bind(autoDeleteQueue1).to(direct).with("orange");
        }

        @Bean
        public Binding bindingBlack(DirectExchange direct, Queue autoDeleteQueue1){
            return BindingBuilder.bind(autoDeleteQueue1).to(direct).with("black");
        }

        @Bean
        public Binding bindingGreen(DirectExchange direct, Queue autoDeleteQueue2){
            return BindingBuilder.bind(autoDeleteQueue2).to(direct).with("green");
        }

        @Bean
        public Binding bindingBrown(DirectExchange direct, Queue autoDeleteQueue2){
            return BindingBuilder.bind(autoDeleteQueue2).to(direct).with("brown");
        }

        @Bean
        public TutRoutReceiver receiver(){
            return new TutRoutReceiver();
        }
    }

    @Profile("sender")
    @Bean
    public TutRoutSender sender(){
        return new TutRoutSender();
    }
}
