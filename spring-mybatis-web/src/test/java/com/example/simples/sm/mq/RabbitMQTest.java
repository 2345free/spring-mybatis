package com.example.simples.sm.mq;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.amqp.core.AmqpTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("/spring/application-config.xml")
public class RabbitMQTest {
	
	@Autowired
	private AmqpTemplate template;
	
	@Test
	public void test(){
		template.convertAndSend("myqueue", "foo");
		String foo = (String) template.receiveAndConvert("myqueue");
		System.out.println(foo);
	}

}
