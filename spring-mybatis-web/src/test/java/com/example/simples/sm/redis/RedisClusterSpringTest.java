package com.example.simples.sm.redis;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import redis.clients.jedis.JedisCluster;

/**
 * 测试spring 集成 redis配置,xml配置方式
 *
 * @author tianyi
 */
public class RedisClusterSpringTest {
    private static final Log log = LogFactory.getLog(RedisClusterSpringTest.class);

    public static void main(String[] args) {
        try {
            ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("classpath:spring/context-*.xml");
            context.start();

            JedisCluster jedisCluster = (JedisCluster) context.getBean("jedisCluster1");
            int num = 10;
            String key = "tianyi";
            String value = "";
            for (int i = 1; i <= num; i++) {
                // 存数据
                //jedisCluster.set(key+i, "tianyi"+i);
                //jedisCluster.setex(key+i, 60, "tianyi"+i); // 设置有效时间

                // 取数据
                value = jedisCluster.get(key + i);
                log.info(key + i + "=" + value);

                // 删除数据
                //jedisCluster.del(key+i);
                //value = jedisCluster.get(key+i);
                //log.info(key+i + "=" + value);
            }

            context.stop();
        } catch (Exception e) {
            log.error(e);
        } finally {
            System.exit(0);
        }
    }
}
