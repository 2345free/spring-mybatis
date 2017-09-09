package com.example.simples.sm.config;

import org.springframework.amqp.core.AmqpAdmin;
import org.springframework.amqp.core.Queue;
import org.springframework.amqp.rabbit.config.SimpleRabbitListenerContainerFactory;
import org.springframework.amqp.rabbit.connection.CachingConnectionFactory;
import org.springframework.amqp.rabbit.connection.ConnectionFactory;
import org.springframework.amqp.rabbit.core.RabbitAdmin;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.amqp.support.converter.Jackson2JsonMessageConverter;
import org.springframework.amqp.support.converter.MessageConverter;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.retry.backoff.ExponentialBackOffPolicy;
import org.springframework.retry.support.RetryTemplate;

/**
 * 集成rabbit配置
 *
 * @author tianyi
 */
// @Configuration
// @EnableRabbit
// @PropertySource("classpath:application.properties")
public class RabbitConfig {

    private final static String queueName = "ty_test";
    @Value("${rabbit.addrssses}")
    private String addrssses;

    @Bean(name = "rabbitConnectionFactory")
    public ConnectionFactory rabbitConnectionFactory() {
        CachingConnectionFactory connectionFactory = new CachingConnectionFactory();
        connectionFactory.setAddresses(addrssses);
        connectionFactory.setUsername("gshopper");
        connectionFactory.setPassword("izene123");
        connectionFactory.setVirtualHost("/");
        System.err.format("rabbitCluster [%s] has been initialized...", addrssses);
        return connectionFactory;
    }

    @Bean
    public AmqpAdmin amqpAdmin() {
        return new RabbitAdmin(rabbitConnectionFactory());
    }

    @Bean // Serialize message content to json using TextMessage
    public MessageConverter jacksonMessageConverter() {
        Jackson2JsonMessageConverter converter = new Jackson2JsonMessageConverter();
        return converter;
    }

    @Bean
    public RabbitTemplate rabbitTemplate() {
        RabbitTemplate rabbitTemplate = new RabbitTemplate(rabbitConnectionFactory());

        RetryTemplate retryTemplate = new RetryTemplate();
        ExponentialBackOffPolicy backOffPolicy = new ExponentialBackOffPolicy();
        backOffPolicy.setInitialInterval(500);
        backOffPolicy.setMultiplier(10.0);
        backOffPolicy.setMaxInterval(10000);
        retryTemplate.setBackOffPolicy(backOffPolicy);
        rabbitTemplate.setRetryTemplate(retryTemplate);
        rabbitTemplate.setReceiveTimeout(10 * 1000);

        rabbitTemplate.setMessageConverter(jacksonMessageConverter());

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

    // @Bean
    // public SimpleMessageListenerContainer messageListenerContainer() {
    // SimpleMessageListenerContainer container = new
    // SimpleMessageListenerContainer();
    // container.setConnectionFactory(rabbitConnectionFactory());
    // container.setQueueNames(new String[] { "ty_test" });
    // container.setConcurrentConsumers(5);
    // container.setMessageListener(exampleListener());
    // return container;
    // }

    @Bean
    public SimpleRabbitListenerContainerFactory rabbitListenerContainerFactory() {
        SimpleRabbitListenerContainerFactory factory = new SimpleRabbitListenerContainerFactory();
        factory.setConnectionFactory(rabbitConnectionFactory());
        factory.setMessageConverter(jacksonMessageConverter());
        factory.setConcurrentConsumers(5);
        factory.setIdleEventInterval(60000L);
        return factory;
    }

    @Bean
    public Queue myQueue() {
        return new Queue(queueName, true, true, false);
    }
}
