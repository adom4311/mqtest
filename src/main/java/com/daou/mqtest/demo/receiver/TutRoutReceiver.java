package com.daou.mqtest.demo.receiver;

import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.util.StopWatch;

public class TutRoutReceiver {

    @RabbitListener(queues = "#{autoDeleteQueue1.name}")
    public void receive1(String in) throws InterruptedException{
        receive(in, 1);
    }

    @RabbitListener(queues = "#{autoDeleteQueue2.name}")
    public void receive2(String in) throws InterruptedException{
        receive(in, 2);
    }

    public void receive(String in, int receiver) throws InterruptedException{
        StopWatch watch = new StopWatch();
        watch.start();
        System.out.println("instance" + receiver + "[x] Reciever '" + in + "'");
        doWork(in);
        watch.stop();
        System.out.println("instance " + receiver + " [x] Done in " + watch.getTotalTimeSeconds() + "S");

    }

    private void doWork(String in) throws InterruptedException{
        for(char ch : in.toCharArray()){
            if(ch=='.'){
                Thread.sleep(1000);
            }
        }
    }
}
