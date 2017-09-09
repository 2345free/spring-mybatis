package com.example.simples.sm.web.dao;

import com.example.simples.sm.web.BaseTest;
import com.example.simples.sm.web.entity.pojo.User;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

public class Tests extends BaseTest {

    @Autowired
    private UserDao userDao;

    @Test
    public void test() {
        List<User> users = userDao.selectAll();
        System.out.println(users);
    }

}
