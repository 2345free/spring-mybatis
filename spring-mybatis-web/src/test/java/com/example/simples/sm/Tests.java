package com.example.simples.sm;

import com.example.simples.sm.mongo.service.MongoDemoService;
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
