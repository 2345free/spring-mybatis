package com.example.simples.sm.config;

import java.io.IOException;
import java.util.Properties;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.support.PropertiesLoaderUtils;

@Configuration
public class SpringMvConfig {
	
	@Bean(name="config")
	public Properties config() throws IOException{
		ClassPathResource resource=new ClassPathResource("application.properties");
		Properties properties = PropertiesLoaderUtils.loadProperties(resource);
		return properties;
	}
}
