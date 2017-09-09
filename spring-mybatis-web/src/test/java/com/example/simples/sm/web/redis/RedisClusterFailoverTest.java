package com.example.simples.sm.web.redis;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import redis.clients.jedis.HostAndPort;
import redis.clients.jedis.JedisCluster;
import redis.clients.jedis.JedisPoolConfig;

import java.util.HashSet;
import java.util.Set;

/**
 * 测试集群故障转移
 *
 * @author tianyi
 */
public class RedisClusterFailoverTest {
    private static final Log log = LogFactory.getLog(RedisClusterFailoverTest.class);

    public static void main(String[] args) {

        // 数据库链接池配置
        JedisPoolConfig config = new JedisPoolConfig();
        config.setMaxTotal(100);
        config.setMaxIdle(50);
        config.setMinIdle(20);
        config.setMaxWaitMillis(6 * 1000);
        config.setTestOnBorrow(true);

        // Redis集群的节点集合
        Set<HostAndPort> jedisClusterNodes = new HashSet<HostAndPort>();
        jedisClusterNodes.add(new HostAndPort("127.0.0.1", 6380));
        jedisClusterNodes.add(new HostAndPort("127.0.0.1", 6381));
        jedisClusterNodes.add(new HostAndPort("127.0.0.1", 6382));

        try {

            // 根据节点集创集群链接对象
            //JedisCluster jedisCluster = new JedisCluster(jedisClusterNodes);
            // 集群各节点集合，超时时间，最多重定向次数，链接池
            JedisCluster jedisCluster = new JedisCluster(jedisClusterNodes, 2000, 100, config);
            int num = 1000;
            String key = "tianyi";
            String value = "";
            int count = 1;

            while (true) {
                for (int i = 1; i <= num; i++) {
                    try {
                        // 存数据
                        jedisCluster.set(key + i, "tianyi" + i);

                        // 取数据
                        value = jedisCluster.get(key + i);
                        log.info(key + i + "=" + value);
                        if (value == null || "".equals(value)) {
                            log.error("===>break" + key + i + " value is null");
                            break;
                        }
                    } catch (Exception e) {
                        log.error("====>", e);
                        Thread.sleep(3000);
                        continue;
                    }
                    // 删除数据
                    //jedisCluster.del(key+i);
                    //value = jedisCluster.get(key+i);
                    //log.info(key+i + "=" + value);
                }
                log.info("===================================>count:" + count);
                if (value == null || "".equals(value)) {
                    break;
                }
                count++;
                Thread.sleep(1000);
            }
        } catch (Exception e) {
            log.error("====>", e);
        }

    }
}
