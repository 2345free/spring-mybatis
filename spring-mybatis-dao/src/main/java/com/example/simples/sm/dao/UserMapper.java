package com.example.simples.sm.dao;

import com.example.simples.sm.annotation.MybatisMapper;
import com.example.simples.sm.entity.User;

@MybatisMapper
public interface UserMapper {
	int deleteByPrimaryKey(Integer id);

	int insert(User record);

	int insertSelective(User record);

	User selectByPrimaryKey(Integer id);

	int updateByPrimaryKeySelective(User record);

	int updateByPrimaryKey(User record);
}