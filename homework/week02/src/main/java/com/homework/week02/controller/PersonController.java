package com.homework.week02.controller;

import com.homework.week02.domain.Person;
import com.homework.week02.domain.PersonRepository;
import com.homework.week02.domain.PersonRequestDto;
import com.homework.week02.service.PersonService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequiredArgsConstructor
@RestController
public class PersonController {

    private final PersonRepository personRepository;

    @GetMapping("/api/persons")
    public List<Person> getPersons(){
        return personRepository.findAll();
    }

    private final PersonService personService;

    @PostMapping("/api/persons")
    public Person createPerson(@RequestBody PersonRequestDto personRequestDto){
        Person person = new Person(personRequestDto);
        return personRepository.save(person);
    }

    @PutMapping("/api/persons/{id}")
    public Long updatePerson(@PathVariable Long id, @RequestBody PersonRequestDto personRequestDto ){
        return personService.update(id, personRequestDto);
    }

    @DeleteMapping("/api/persons/{id}")
    public Long deletePerson(@PathVariable Long id){
        personRepository.deleteById(id);
        return id;
    }

}
