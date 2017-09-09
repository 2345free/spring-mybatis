package com.example.simples.sm.mq.rabbit;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.amqp.core.Message;
import org.springframework.amqp.rabbit.annotation.Exchange;
import org.springframework.amqp.rabbit.annotation.Queue;
import org.springframework.amqp.rabbit.annotation.QueueBinding;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

@Component
public class ExampleListener {

    private static final Logger logger = LoggerFactory.getLogger(ExampleListener.class);

    @RabbitListener(bindings = @QueueBinding(
            value = @Queue(value = "ty_test", durable = "true", autoDelete = "false", exclusive = "true"),
            exchange = @Exchange(value = "tyExchange", ignoreDeclarationExceptions = "true"), key = "tyKey"), containerFactory = "rabbitListenerContainerFactory", admin = "amqpAdmin"
    )
    public void receive(Message message) throws Exception {
        String msg = new String(message.getBody(), "UTF-8");
        logger.info("收到消息:[{}]", msg);
        System.err.format("收到消息:[%s]\n", msg);
    }

}
