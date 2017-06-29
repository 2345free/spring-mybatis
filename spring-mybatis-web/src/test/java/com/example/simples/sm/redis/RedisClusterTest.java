package com.example.simples.sm.redis;

import java.util.HashSet;
import java.util.Map;
import java.util.Set;
import java.util.TreeSet;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import redis.clients.jedis.HostAndPort;
import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisCluster;
import redis.clients.jedis.JedisPool;
import redis.clients.jedis.JedisPoolConfig;


/**
 * @author tianyi
 *
 */
public class RedisClusterTest {
	private static final Log log = LogFactory.getLog(RedisClusterTest.class);

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
		jedisClusterNodes.add(new HostAndPort("172.16.111.11", 6000));
		jedisClusterNodes.add(new HostAndPort("172.16.111.12", 6003));
		jedisClusterNodes.add(new HostAndPort("172.16.111.12", 6002));

		// 根据节点集创集群链接对象
		//JedisCluster jedisCluster = new JedisCluster(jedisClusterNodes);
		// 集群各节点集合，超时时间，最多重定向次数，链接池
		JedisCluster jedisCluster = new JedisCluster(jedisClusterNodes, 2000, 100, config);

		// 获取所有的节点
		Map<String, JedisPool> clusterNodes = jedisCluster.getClusterNodes();

		// 遍历节点 获取所有符合条件的KEY
		TreeSet<String> keys = new TreeSet<>();
		for (String k : clusterNodes.keySet()) {
			JedisPool jp = clusterNodes.get(k);
			Jedis connection = jp.getResource();
			try {
				Set<String> set = connection.keys("_common_xchr");
				if(set.size()>0)
					keys.addAll(set);
			} catch (Exception e) {
				e.printStackTrace();
			} finally {
				connection.close();// 用完一定要close这个链接！！！
			}
		}

		// 批量删除
		for(String key:keys){
			//            jedisCluster.del(key);
			System.out.println(key);
		}

		//		int num = 1000;
		//		String key = "tianyi";
		//		String value = "";
		//		for (int i=1; i <= num; i++){
		//			// 存数据
		//			jedisCluster.set(key+i, "value"+i);
		//			// 取数据
		//			value = jedisCluster.get(key+i);
		//			log.info(key+i + "=" + value);
		//			// 删除数据
		//			//jedisCluster.del(key+i);
		//			//value = jedisCluster.get(key+i);
		//			//log.info(key+i + "=" + value);
		//		}

	}

}