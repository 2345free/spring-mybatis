package com.example.simples.sm.mq;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.springframework.amqp.core.AmqpTemplate;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.alibaba.fastjson.JSONObject;
import com.example.simples.sm.config.RabbitConfig;

//@RunWith(SpringJUnit4ClassRunner.class)
//@ContextConfiguration("/spring/application-config.xml")
public class RabbitMQTest {

	//	@Autowired
	//	private AmqpTemplate template;

	final static String queueName = "ty_test";

	@Test
	public void test(){

		AmqpTemplate template=ctx.getBean(AmqpTemplate.class);

		JSONObject json=new JSONObject();
		json.put("key", "哈哈");
		template.convertAndSend(queueName, json);
		// JSONObject foo = (JSONObject) template.receiveAndConvert(queueName);
		// System.out.println(foo);
	}

	//--------------------------------------------
	private AnnotationConfigApplicationContext ctx;

	@Before
	public void setUp() throws Exception {
		ctx = new AnnotationConfigApplicationContext(RabbitConfig.class);
	}

	@After
	public void tearDown() throws Exception {
		if(ctx!=null)
			ctx.close();
	}

}
