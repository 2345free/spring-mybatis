package com.example.simples.sm.redis;

import com.example.simples.sm.config.RedisConfig;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import redis.clients.jedis.JedisCluster;

public class AnnotationConfigTest {

    private AnnotationConfigApplicationContext ctx;

    @Before
    public void setUp() throws Exception {
        ctx = new AnnotationConfigApplicationContext(RedisConfig.class);
    }

    @After
    public void tearDown() throws Exception {
        if (ctx != null)
            ctx.close();
    }

    @Test
    public void test() {
        JedisCluster jedisCluster = ctx.getBean("jedisCluster", JedisCluster.class);
        int count = 10000;
        // set
        long start = System.currentTimeMillis();
        // for (int i = 1; i <=count ; i++) {
        // jedisCluster.set("tianyi:" + i, "v-" + i);
        // }
        // System.err.println("set " + count +"th value in " +
        // (System.currentTimeMillis() - start) + " ms");
        // get
        start = System.currentTimeMillis();
        for (int i = 1; i <= count; i++) {
            jedisCluster.get("tianyi:" + i);
        }
        System.err.println("get " + count + "th value in " + (System.currentTimeMillis() - start) + " ms");
    }

}
