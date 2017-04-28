package com.example.simples.sm.config;

import java.util.HashSet;
import java.util.Set;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.redis.connection.RedisConnectionFactory;
import org.springframework.data.redis.connection.jedis.JedisConnectionFactory;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.StringRedisTemplate;

import redis.clients.jedis.HostAndPort;
import redis.clients.jedis.JedisCluster;
import redis.clients.jedis.JedisPoolConfig;

/**
 * spring 集成 redis配置,代码配置方式
 * @author tianyi
 *
 */
@Configuration
public class RedisConfig {
	
	/**
	 * Redis Cluster
	 * @return
	 * @author tianyi
	 */
	@Bean
	public JedisCluster jedisCluster(){
		Set<HostAndPort> nodes=new HashSet<>();
		nodes.add(new HostAndPort("127.0.0.1",6380));
		nodes.add(new HostAndPort("127.0.0.1",6381));
		nodes.add(new HostAndPort("127.0.0.1",6382));
		JedisCluster jedisCluster=new JedisCluster(nodes);
		return jedisCluster;
	}

	@Bean
	public RedisConnectionFactory jedisConnectionFactory() {
		JedisConnectionFactory jedisConnectionFactory = new JedisConnectionFactory();
		jedisConnectionFactory.setPoolConfig(jedisPoolConfig());
		jedisConnectionFactory.setHostName("127.0.0.1");
		jedisConnectionFactory.setPort(6380);
		return jedisConnectionFactory;
		// Redis Sentinel HA Cluster
//		RedisSentinelConfiguration sentinelConfig = new RedisSentinelConfiguration() 
//				.master("mymaster")
//				.sentinel("127.0.0.1", 6380) 
//				.sentinel("127.0.0.1", 6381)
//				.sentinel("127.0.0.1", 6382);
//		return new JedisConnectionFactory(sentinelConfig);
	}
	
	@Bean
	public JedisPoolConfig jedisPoolConfig(){
		JedisPoolConfig jedisPoolConfig=new JedisPoolConfig();
		jedisPoolConfig.setMaxTotal(100);
		jedisPoolConfig.setMaxIdle(20);
		jedisPoolConfig.setMinIdle(10);
		jedisPoolConfig.setBlockWhenExhausted(true);
		jedisPoolConfig.setMaxWaitMillis(3000);
		jedisPoolConfig.setTestOnBorrow(false);
		jedisPoolConfig.setTestOnReturn(false);
		jedisPoolConfig.setTestWhileIdle(true);
		jedisPoolConfig.setMinEvictableIdleTimeMillis(60000);
		jedisPoolConfig.setNumTestsPerEvictionRun(-1);
		return jedisPoolConfig;
	}

	@Bean
	public RedisTemplate<Object, Object> redisTemplate() {
		RedisTemplate<Object, Object> redisTemplate = new RedisTemplate<>();
		redisTemplate.setConnectionFactory(jedisConnectionFactory());
		return redisTemplate;
	}

	@Bean
	public StringRedisTemplate stringRedisTemplate() {
		StringRedisTemplate stringRedisTemplate = new StringRedisTemplate();
		stringRedisTemplate.setConnectionFactory(jedisConnectionFactory());
		return stringRedisTemplate;
	}

}
