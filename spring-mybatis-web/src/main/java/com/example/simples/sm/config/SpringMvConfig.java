package com.example.simples.sm.config;

import java.io.IOException;
import java.util.Properties;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.support.PropertiesLoaderUtils;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

@Configuration
public class SpringMvConfig extends WebMvcConfigurerAdapter{
	
	@Bean(name="config")
	public Properties config() throws IOException{
		ClassPathResource resource=new ClassPathResource("application.properties");
		Properties properties = PropertiesLoaderUtils.loadProperties(resource);
		return properties;
	}
}
