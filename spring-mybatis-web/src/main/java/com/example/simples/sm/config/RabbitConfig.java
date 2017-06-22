package com.example.simples.sm.config;

import org.springframework.amqp.core.AmqpAdmin;
import org.springframework.amqp.core.Queue;
import org.springframework.amqp.rabbit.config.SimpleRabbitListenerContainerFactory;
import org.springframework.amqp.rabbit.connection.CachingConnectionFactory;
import org.springframework.amqp.rabbit.connection.ConnectionFactory;
import org.springframework.amqp.rabbit.core.RabbitAdmin;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.amqp.support.converter.Jackson2JsonMessageConverter;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.retry.backoff.ExponentialBackOffPolicy;
import org.springframework.retry.support.RetryTemplate;

/**
 * 集成rabbit配置
 * @author tianyi
 *
 */
//@Configuration
//@EnableRabbit
//@PropertySource("classpath:application.properties")
public class RabbitConfig {
	
	@Value("${rabbit.addrssses}")
	private String addrssses;
	
//	final static String queueName = "Q-B5C2GS-02";
	final static String queueName = "ty_test";

	@Bean(name="rabbitConnectionFactory")
	public ConnectionFactory rabbitConnectionFactory() {
		CachingConnectionFactory connectionFactory = new CachingConnectionFactory();
		connectionFactory.setAddresses(addrssses);
//		connectionFactory.setUsername("gshopper");
//		connectionFactory.setPassword("izene123");
		connectionFactory.setUsername("admin");
		connectionFactory.setPassword("admin");
		connectionFactory.setVirtualHost("/");
		System.err.println(String.format("rabbitCluster [%s] has been initialized...",addrssses));
		return connectionFactory;
	}

	@Bean
	public AmqpAdmin amqpAdmin() {
		return new RabbitAdmin(rabbitConnectionFactory());
	}

	@Bean
	public RabbitTemplate rabbitTemplate() {
		RabbitTemplate rabbitTemplate = new RabbitTemplate(rabbitConnectionFactory());
//		rabbitTemplate.setExchange("gshopperExchange");
//		rabbitTemplate.setRoutingKey("Q-B5C2GS-02-RK-01");
		rabbitTemplate.setQueue(queueName);
		
		RetryTemplate retryTemplate = new RetryTemplate();
	    ExponentialBackOffPolicy backOffPolicy = new ExponentialBackOffPolicy();
	    backOffPolicy.setInitialInterval(500);
	    backOffPolicy.setMultiplier(10.0);
	    backOffPolicy.setMaxInterval(10000);
	    retryTemplate.setBackOffPolicy(backOffPolicy);
	    rabbitTemplate.setRetryTemplate(retryTemplate);
	    
	    rabbitTemplate.setMessageConverter(new Jackson2JsonMessageConverter());
		
		return rabbitTemplate;
	}
	
//	@Bean
//    public MessageListener exampleListener() {
//        return new MessageListener() {
//        	@Override
//            public void onMessage(Message message) {
//                System.out.println("received: " + message);
//            }
//        };
//    }
//	
//	 @Bean
//    public SimpleMessageListenerContainer messageListenerContainer() {
//        SimpleMessageListenerContainer container = new SimpleMessageListenerContainer();
//        container.setConnectionFactory(rabbitConnectionFactory());
//        container.setQueueNames("ty_test");
//        container.setMessageListener(exampleListener());
//        return container;
//    }
	
	@Bean
	public SimpleRabbitListenerContainerFactory rabbitListenerContainerFactory() {
	    SimpleRabbitListenerContainerFactory factory = new SimpleRabbitListenerContainerFactory();
	    factory.setConnectionFactory(rabbitConnectionFactory());
	    factory.setIdleEventInterval(60000L);
	    return factory;
	}

	@Bean
	public Queue ghQueue() {
		return new Queue(queueName);
	}
}
