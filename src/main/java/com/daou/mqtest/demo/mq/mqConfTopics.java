package com.daou.mqtest.demo.mq;

import com.daou.mqtest.demo.receiver.TutTopicReciever;
import com.daou.mqtest.demo.sender.TutTopicSender;
import org.springframework.amqp.core.*;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

@Profile("topics")
@Configuration
public class mqConfTopics {

    @Bean
    public TopicExchange topic(){
        return new TopicExchange("tut.topic");
    }

    @Profile("receiver")
    private static class RecewiverConfig{

        @Bean
        public TutTopicReciever reciever(){
            return new TutTopicReciever();
        }

        @Bean
        public Queue autoDeleteQueue1(){
            return new AnonymousQueue();
        }

        @Bean
        public Queue autoDelteQueue2(){
            return new AnonymousQueue();
        }

        @Bean
        public Binding bindingOrange(TopicExchange topic, Queue autoDeleteQueue1){
            return BindingBuilder.bind(autoDeleteQueue1).to(topic).with("*.oragne.*");
        }

        @Bean
        public Binding bindingRabbit(TopicExchange topic, Queue autoDeleteQueue1){
            return BindingBuilder.bind(autoDeleteQueue1).to(topic).with("*.*.rabbit");
        }

        @Bean
        public Binding bindingLazy(TopicExchange topic, Queue autoDeleteQueue2){
            return BindingBuilder.bind(autoDeleteQueue2).to(topic).with("lazy.#");
        }
    }

    @Profile("sender")
    @Bean
    public TutTopicSender sender(){
        return new TutTopicSender();
    }
}
