package com.example.simples.sm.web.controller;

import com.example.simples.sm.entity.proto.AddressBookProtos.Person;
import org.springframework.http.RequestEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import springfox.documentation.annotations.ApiIgnore;

@Controller
public class ProtobufController {

    @PostMapping("/proto/w")
    @ApiIgnore
    public ResponseEntity<Person> protoWrite(RequestEntity<Person> requestEntity) {
        Person person = requestEntity.getBody();
        System.out.println("server===\n" + person);
        return ResponseEntity.ok(person);
    }
}
