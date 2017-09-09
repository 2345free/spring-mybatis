package com.example.samples.sm.service.impl;

import com.example.simples.sm.web.service.DemoService;
import org.springframework.stereotype.Service;

@Service("demoService")
public class DemoServiceImpl implements DemoService {

    @Override
    public String sayHello(String name) {
        return "你好，" + name;
    }

}
