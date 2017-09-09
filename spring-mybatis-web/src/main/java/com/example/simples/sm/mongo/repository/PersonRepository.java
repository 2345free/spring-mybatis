package com.example.simples.sm.mongo.repository;

import com.example.simples.sm.mongo.document.Person;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface PersonRepository extends CrudRepository<Person, Long> {

    List<Person> findByName(String name);

    List<Person> findByNameLike(String name);
}
