package com.example.simples.sm.web.redis;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.dao.DataAccessException;
import org.springframework.data.redis.connection.RedisConnection;
import org.springframework.data.redis.connection.StringRedisConnection;
import org.springframework.data.redis.core.ListOperations;
import org.springframework.data.redis.core.RedisCallback;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import javax.annotation.Resource;
import java.net.URL;

/**
 * spring-data-redis 官方示例
 *
 * @author tianyi
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration({"/spring/application-*.xml"})
public class Example {

    // inject the actual template
    @Autowired
    private RedisTemplate<String, String> redisTemplate;

    @Autowired
    private StringRedisTemplate stringRedisTemplate;

    @Resource(name = "redisTemplate")
    private ListOperations<String, String> listOps; // inject the template as ListOperations

    @Value("${redis.cluster.servers}")
    private String servers;

    @Test
    public void test1() {
        System.out.println(servers);
        System.out.println(redisTemplate);
        System.out.println(stringRedisTemplate);
    }

    public void addLink(String userId, URL url) {
        listOps.leftPush(userId, url.toExternalForm());
    }

    public void useCallback() {

        redisTemplate.execute(new RedisCallback<Object>() {
            public Object doInRedis(RedisConnection connection) throws DataAccessException {
                Long size = connection.dbSize();
                // Can cast to StringRedisConnection if using a
                // StringRedisTemplate
                ((StringRedisConnection) connection).set("key", "value");
                return size;
            }
        });
    }

}
