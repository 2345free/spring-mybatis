package com.example.simples.sm.web;

import com.alibaba.fastjson.JSONObject;
import com.example.simples.sm.web.config.ActivemqConfig;
import com.example.simples.sm.web.config.MongoConfig;
import com.example.simples.sm.web.config.RabbitConfig;
import com.example.simples.sm.web.mongo.document.Person;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.springframework.amqp.core.AmqpTemplate;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.jms.core.JmsTemplate;

import java.util.List;

//@RunWith(SpringJUnit4ClassRunner.class)
//@ContextConfiguration("/spring/application-config.xml")
public class AnnotationConfigTest {

    //	@Autowired
    //	private AmqpTemplate template;

    //--------------------------------------------
    private AnnotationConfigApplicationContext ctx;

    @Test
    public void test() {

        ctx = new AnnotationConfigApplicationContext(RabbitConfig.class);

        AmqpTemplate template = ctx.getBean(AmqpTemplate.class);

        JSONObject json = new JSONObject();
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

    @Test
    public void test3() {

        ctx = new AnnotationConfigApplicationContext(MongoConfig.class);

        MongoTemplate template = ctx.getBean(MongoTemplate.class);

        Person person = new Person();
        person.setName("tianyi");
        person.setAge(25);
        template.save(person);

        List<Person> list = template.findAll(Person.class);
        list.forEach(p -> System.out.println(p));
    }

    @Before
    public void setUp() throws Exception {

    }

    @After
    public void tearDown() throws Exception {
        if (ctx != null)
            ctx.close();
    }

}
