package com.example.simples.sm.redis;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import redis.clients.jedis.Jedis;

/**
 * @author tianyi
 */
public class RedisTest {
    private static final Log log = LogFactory.getLog(RedisTest.class);

    public static void main(String[] args) {

        Jedis jedis = new Jedis("192.168.10.114", 6379); // 不支持集群 MOVED
        String key = "tianyi";
        String value = jedis.get(key); // 取数据
        log.info(key + "=" + value);

    }
}
