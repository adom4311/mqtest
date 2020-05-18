package com.daou.mqtest.demo.mq;

import com.daou.mqtest.demo.receiver.TutPubSubReceiver;
import com.daou.mqtest.demo.sender.TutPubSubSender;
import org.springframework.amqp.core.*;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

@Profile({"pub-sub"})
@Configuration
public class mqConfTutPubSub {

    @Bean
    public FanoutExchange fanout(){
        return new FanoutExchange("tut.fanout");
    }

    @Profile("receiver")
    private static class Receiverconfig{

        @Bean
        public Queue autoDeleteQueue1(){
            return new AnonymousQueue();
        }

        @Bean
        public Queue autoDeleteQueue2(){
            return new AnonymousQueue();
        }

        @Bean
        public Binding binding1(FanoutExchange fanout, Queue autoDeleteQueue1){
            return BindingBuilder.bind(autoDeleteQueue1).to(fanout);
        }

        @Bean
        public Binding binding2(FanoutExchange fanout, Queue autoDeleteQueue2){
            return BindingBuilder.bind(autoDeleteQueue2).to(fanout);
        }

        @Bean
        public TutPubSubReceiver receiver(){
            return new TutPubSubReceiver();
        }
    }

    @Profile("sender")
    @Bean
    public TutPubSubSender sender(){
        return new TutPubSubSender();
    }
}
