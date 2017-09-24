package com.example.simples.sm.web;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.support.PropertiesLoaderUtils;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurationSupport;

import java.io.IOException;
import java.util.Properties;

@Configuration
@ComponentScan
public class SpringMvConfig extends WebMvcConfigurationSupport {

    @Value("${canal.destination}")
    private String destination;

    @Bean(name = "config")
    public Properties config() throws IOException {
        ClassPathResource resource = new ClassPathResource("application.properties");
        Properties properties = PropertiesLoaderUtils.loadProperties(resource);
        return properties;
    }

    @Override
    public void addViewControllers(ViewControllerRegistry registry) {
        registry.addRedirectViewController("/", "/swagger-ui.html");
    }

    /**
     * 启动canelClient
     * @author tianyi
     * @return
     * 目前canal并没有实现一个canal server(官方说的后续会实现)可以有多个canl client,需要把canl client单独提取出来为一个单独服务
     */
    //	@Bean(initMethod="init")
    //	public GeneralCanalClient generalCanalClient(){
    //		return new GeneralCanalClient(destination);
    //	}

}
