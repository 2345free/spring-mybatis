package com.example.simples.sm.web.dao;

import tk.mybatis.mapper.common.Mapper;
import tk.mybatis.mapper.common.MySqlMapper;


/**
 * 继承Mapper插件的单表CRUD
 *
 * @param <T>
 * @author luoxx
 */
public interface MyMapper<T> extends Mapper<T>, MySqlMapper<T> {

}
