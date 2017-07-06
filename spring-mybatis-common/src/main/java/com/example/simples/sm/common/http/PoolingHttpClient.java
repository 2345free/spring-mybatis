package com.example.simples.sm.common.http;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.apache.http.HttpHost;
import org.apache.http.client.config.RequestConfig;
import org.apache.http.config.Registry;
import org.apache.http.config.RegistryBuilder;
import org.apache.http.config.SocketConfig;
import org.apache.http.conn.DnsResolver;
import org.apache.http.conn.HttpConnectionFactory;
import org.apache.http.conn.ManagedHttpClientConnection;
import org.apache.http.conn.routing.HttpRoute;
import org.apache.http.conn.socket.ConnectionSocketFactory;
import org.apache.http.conn.socket.PlainConnectionSocketFactory;
import org.apache.http.conn.ssl.SSLConnectionSocketFactory;
import org.apache.http.impl.DefaultConnectionReuseStrategy;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.DefaultConnectionKeepAliveStrategy;
import org.apache.http.impl.client.DefaultHttpRequestRetryHandler;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.impl.conn.DefaultHttpResponseParserFactory;
import org.apache.http.impl.conn.ManagedHttpClientConnectionFactory;
import org.apache.http.impl.conn.PoolingHttpClientConnectionManager;
import org.apache.http.impl.conn.SystemDefaultDnsResolver;
import org.apache.http.impl.io.DefaultHttpRequestWriterFactory;

/**
 * @author luoxx
 *
 */
public class PoolingHttpClient {

	private static PoolingHttpClientConnectionManager manager = null;
	private static CloseableHttpClient httpClient = null;

	public static synchronized CloseableHttpClient getHttpClient() {

		if (httpClient == null) {
			// 注册访问协议相关的sockert工厂
			Registry<ConnectionSocketFactory> socketFactoryRegistry = RegistryBuilder.<ConnectionSocketFactory>create()
					.register("http", PlainConnectionSocketFactory.INSTANCE)
					.register("https", SSLConnectionSocketFactory.getSystemSocketFactory()).build();
			// httpConnection 工厂
			HttpConnectionFactory<HttpRoute, ManagedHttpClientConnection> connFactory = new ManagedHttpClientConnectionFactory(
					DefaultHttpRequestWriterFactory.INSTANCE, DefaultHttpResponseParserFactory.INSTANCE);
			// DNS解析器
			DnsResolver dnsResolver = SystemDefaultDnsResolver.INSTANCE;
			// 创建池化连接管理器
			manager = new PoolingHttpClientConnectionManager(socketFactoryRegistry, connFactory, dnsResolver);
			// 默认为socket配置
			SocketConfig defaultSocketConfig = SocketConfig.custom().setTcpNoDelay(true).build();
			manager.setDefaultSocketConfig(defaultSocketConfig);
			manager.setMaxTotal(300); // 设置整个连接池的最大连接数
			manager.setDefaultMaxPerRoute(200); // 每个路由的最大连接数
			manager.setMaxPerRoute(new HttpRoute(new HttpHost("jd.com", 80)), 100); // 单个路由的最大连接数
			manager.setValidateAfterInactivity(5 * 1000); // 连接不活跃多久后验证,默认2s
			// 默认请求配置
			RequestConfig defaultRequestConfig = RequestConfig.custom().setConnectTimeout(2 * 1000) // 设置连接超时时间
					.setSocketTimeout(5 * 1000) // 设置等待数据超时时间
					.setConnectionRequestTimeout(2000) // 设置从连接池获取连接等待超时时间
					.build();

			// 创建 httpClient
			httpClient = HttpClients.custom().setConnectionManager(manager)
					.setConnectionManagerShared(false) // 连接池不是共享模式
					.evictIdleConnections(60, TimeUnit.SECONDS) // 定期回收空闲连接
					.evictExpiredConnections() // 定期回收过期连接
					.setConnectionTimeToLive(60, TimeUnit.SECONDS) // 设置存活时间,负责根据长连接信息决定
					.setDefaultRequestConfig(defaultRequestConfig) // 设置默认请求配置
					.setConnectionReuseStrategy(DefaultConnectionReuseStrategy.INSTANCE) // 设置连接重用策略,即是否能keepAlive
					.setKeepAliveStrategy(DefaultConnectionKeepAliveStrategy.INSTANCE) // 长连接配置
					.setRetryHandler(new DefaultHttpRequestRetryHandler(0, false)) // 设置失败重试次数,默认3次:当前禁用,根据需要开启
					.build();

			// JVM关闭时关闭连接池,释放资源
			Runtime.getRuntime().addShutdownHook(new Thread() {
				@Override
				public void run() {
					try {
						httpClient.close();
					} catch (IOException e) {
						e.printStackTrace();
					}
				}
			});
		}

		return httpClient;
	}

}
