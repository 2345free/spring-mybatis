package com.example.samples.sm.service.impl;

import org.springframework.stereotype.Service;

import com.example.simples.sm.service.DemoService;

@Service("demoService")
public class DemoServiceImpl implements DemoService {

	@Override
	public String sayHello(String name) {
		return "你好，" + name;
	}

}
