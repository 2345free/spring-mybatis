package com.example.simples.sm;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import com.example.simples.sm.mongo.service.MongoDemoService;

public class Tests extends BaseTest {

	@Autowired
	public MongoDemoService mongoDemoService;

	@Test
	public void testMongoService() {
		mongoDemoService.doWork();
	}

}
