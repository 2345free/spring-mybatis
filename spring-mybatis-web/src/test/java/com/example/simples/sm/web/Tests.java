package com.example.simples.sm.web;

import com.example.simples.sm.web.mongo.service.MongoDemoService;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

public class Tests extends BaseTest {

    @Autowired
    public MongoDemoService mongoDemoService;

    @Test
    public void testMongoService() {
        mongoDemoService.doWork();
    }

}
