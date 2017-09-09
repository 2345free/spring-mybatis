package com.example.simples.sm.mongo.service;

import com.example.simples.sm.mongo.document.Person;
import com.example.simples.sm.mongo.repository.PersonRepository;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

//@Service
public class MongoDemoService {

    private final PersonRepository repository;

    @Autowired
    public MongoDemoService(PersonRepository repository) {
        this.repository = repository;
    }

    public void doWork() {

        repository.deleteAll();

        Person person = new Person();
        person.setName("tianyi");
        person.setAge(25);
        person = repository.save(person);

        List<Person> persons = repository.findByName("tianyi");

        System.out.println("查询结果数目:" + persons.size());

        persons.forEach(p -> {
            System.out.println(p);
        });


    }
}
