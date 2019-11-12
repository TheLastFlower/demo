package com.example.mq;

import com.rabbitmq.client.Channel;
import org.springframework.amqp.core.Message;
import org.springframework.amqp.rabbit.annotation.Exchange;
import org.springframework.amqp.rabbit.annotation.Queue;
import org.springframework.amqp.rabbit.annotation.QueueBinding;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

import java.io.IOException;

/**
 * @author wangwei
 * @date 2019/11/6 14:03
 */



@Component
public class MyConsumer2 {

    @RabbitListener(
            bindings = @QueueBinding(
                    exchange = @Exchange(value = "${rabbit.banner.exchange}", type = "direct", durable = "true", ignoreDeclarationExceptions = "true"),
                    value = @Queue(value = "${rabbit.banner.queue}", durable = "true"),
                    key = "${rabbit.banner.routingkey}"
            )
    )
    public void onMessage(Message message, Channel channel) throws IOException {

        try {
            Thread.sleep(2000);
            //int a = 1/0;
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        long deliveryTag = message.getMessageProperties().getDeliveryTag();
        //手工ack
        channel.basicAck(deliveryTag,true);
        System.out.println("banner队列: " + new String(message.getBody()));
    }



}
