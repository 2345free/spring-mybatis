package com.example.simples.sm.config;

import com.example.samples.sm.service.impl.DemoServiceImpl;
import com.example.simples.sm.service.DemoService;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.remoting.httpinvoker.HttpInvokerServiceExporter;

@Configuration
public class HttpInvokerConfig {

    @Bean
    public HttpInvokerServiceExporter demoService() {
        HttpInvokerServiceExporter exporter = new HttpInvokerServiceExporter();
        exporter.setServiceInterface(DemoService.class);
        exporter.setService(new DemoServiceImpl());
        return exporter;
    }

}
