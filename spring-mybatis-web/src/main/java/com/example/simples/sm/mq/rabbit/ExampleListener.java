package com.example.simples.sm.mq.rabbit;

import org.springframework.amqp.rabbit.annotation.Exchange;
import org.springframework.amqp.rabbit.annotation.Queue;
import org.springframework.amqp.rabbit.annotation.QueueBinding;
import org.springframework.amqp.rabbit.annotation.RabbitListener;

//@Component
public class ExampleListener {

//	private static final Logger logger = LoggerFactory.getLogger("log4PushOrdStat");

	@RabbitListener(bindings = @QueueBinding(
	        value = @Queue(value = "ty_test", durable = "true"),
	        exchange = @Exchange(value = "gshopperExchange", ignoreDeclarationExceptions = "true"),
	        key = "Q-B5C2GS-02-RK-01")
	  )
	public void processOrder(String message) {
		System.err.format("收到消息:[%s]",message);
	}

}
