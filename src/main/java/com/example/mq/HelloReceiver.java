package com.example.mq;

import com.example.util.RedisUtil;
import org.springframework.amqp.rabbit.annotation.RabbitHandler;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * @author wangwei
 * @date 2019/10/23 13:57
 */
/*@Component
@RabbitListener(queues = "user_table")
public class HelloReceiver {

    @Autowired(required=true)
    private RedisUtil redisUtil;

    @RabbitHandler
    public void process(String id){
        redisUtil.del(id);
    }
}*/
