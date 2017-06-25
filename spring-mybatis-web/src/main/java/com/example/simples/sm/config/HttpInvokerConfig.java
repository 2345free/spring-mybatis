package com.example.simples.sm.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.remoting.httpinvoker.HttpInvokerServiceExporter;

@Configuration
public class HttpInvokerConfig {

	@Bean
	public HttpInvokerServiceExporter demoService() {
		HttpInvokerServiceExporter exporter = new HttpInvokerServiceExporter();
		// exporter.setService(service);
		// exporter.setServiceInterface(serviceInterface);
		return exporter;
	}

}
