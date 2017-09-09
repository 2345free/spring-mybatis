package com.example.simples.sm.web.controller;

import org.springframework.http.RequestEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import protobuf.example.AddressBookProtos.Person;

@Controller
public class ProtobufController {

    @PostMapping("/proto/w")
    public ResponseEntity<Person> protoWrite1(RequestEntity<Person> requestEntity) {
        Person person = requestEntity.getBody();
        System.out.println("server===\n" + person);
        return ResponseEntity.ok(person);
    }
}
