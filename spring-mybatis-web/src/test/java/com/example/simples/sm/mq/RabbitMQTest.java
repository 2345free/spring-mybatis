package com.example.simples.sm.mq;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.amqp.core.AmqpTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.alibaba.fastjson.JSONObject;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("/spring/application-config.xml")
public class RabbitMQTest {
	
	@Autowired
	private AmqpTemplate template;
	
	@Test
	public void test(){
		JSONObject json=new JSONObject();
		json.put("key", "哈哈");
		template.convertAndSend("Q-B5C2GS-02",json);
		JSONObject foo = (JSONObject) template.receiveAndConvert("Q-B5C2GS-02");
		System.out.println(foo);
	}

}
