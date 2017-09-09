package com.example.simples.sm.dao;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class TestUserMapper {

    private ClassPathXmlApplicationContext ac;

    @Before
    public void setUp() throws Exception {
        ac = new ClassPathXmlApplicationContext("spring/application-*.xml");
    }

    @After
    public void tearDown() throws Exception {
        ac.close();
    }

    @Test
    public void test() {
    }

}
