package com.example.simples.sm.dao;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.example.simples.sm.entity.User;

public class TestUserMapper {
	
	private ClassPathXmlApplicationContext ac;

	@Before
	public void setUp() throws Exception {
		ac=new ClassPathXmlApplicationContext("spring/application-*.xml");
	}

	@After
	public void tearDown() throws Exception {
		ac.close();
	}

	@Test
	public void test() {
		UserMapper userMapper=ac.getBean("userMapper", UserMapper.class);
		User user = userMapper.selectByPrimaryKey(1);
		System.out.println(user);
	}

}
