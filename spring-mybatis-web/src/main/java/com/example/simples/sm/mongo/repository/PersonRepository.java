package com.example.simples.sm.mongo.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.example.simples.sm.mongo.document.Person;

public interface PersonRepository extends CrudRepository<Person, Long> {

	List<Person> findByName(String name);

	List<Person> findByNameLike(String name);
}
