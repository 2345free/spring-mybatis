package com.example.simples.sm.mq;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.springframework.amqp.core.AmqpTemplate;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.jms.core.JmsTemplate;

import com.alibaba.fastjson.JSONObject;
import com.example.simples.sm.config.ActivemqConfig;
import com.example.simples.sm.config.RabbitConfig;

//@RunWith(SpringJUnit4ClassRunner.class)
//@ContextConfiguration("/spring/application-config.xml")
public class RabbitMQTest {

	//	@Autowired
	//	private AmqpTemplate template;

	@Test
	public void test(){

		ctx = new AnnotationConfigApplicationContext(RabbitConfig.class);

		AmqpTemplate template=ctx.getBean(AmqpTemplate.class);

		JSONObject json=new JSONObject();
		json.put("key", "哈哈");
		template.convertAndSend("ty_test", json);
		// JSONObject foo = (JSONObject) template.receiveAndConvert(queueName);
		// System.out.println(foo);
	}

	@Test
	public void test2() {

		ctx = new AnnotationConfigApplicationContext(ActivemqConfig.class);

		JmsTemplate template = ctx.getBean(JmsTemplate.class);

		JSONObject json = new JSONObject();
		json.put("key", "哈哈111");
		template.convertAndSend("mailbox", json);
		// JSONObject foo = (JSONObject) template.receiveAndConvert(queueName);
		// System.out.println(foo);
	}

	//--------------------------------------------
	private AnnotationConfigApplicationContext ctx;

	@Before
	public void setUp() throws Exception {

	}

	@After
	public void tearDown() throws Exception {
		if(ctx!=null)
			ctx.close();
	}

}
