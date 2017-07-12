package com.example.simples.sm.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.data.mongodb.config.AbstractMongoConfiguration;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;

import com.mongodb.Mongo;
import com.mongodb.MongoClient;

@Configuration
@EnableMongoRepositories({ "com.example.simples.sm.mongo.repository" })
public class MongoConfig extends AbstractMongoConfiguration {

	@Override
	public Mongo mongo() throws Exception {
		return new MongoClient("172.16.13.26:27017");
	}

	@Override
	protected String getDatabaseName() {
		return "springdata";
	}


}