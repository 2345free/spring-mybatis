package com.example.simples.sm.web.service;

import com.alibaba.dubbo.config.annotation.Service;

@Service(version = "1.0.0")
public interface DemoService {

    public String sayHello(String name);

}
