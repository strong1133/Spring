package com.homework.week02;

import com.homework.week02.domain.Person;
import com.homework.week02.domain.PersonRepository;
import com.homework.week02.domain.PersonRequestDto;
import com.homework.week02.service.PersonService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.List;

@SpringBootApplication
public class Week02Application {

    public static void main(String[] args) {
        SpringApplication.run(Week02Application.class, args);
    }

    @Bean
    public CommandLineRunner demo(PersonRepository personRepository, PersonService personService){
        return (args)->{

            Person person = new Person("홍슬기", "26", "귀염둥이");
            personRepository.save(person);

            List<Person> personList = personRepository.findAll();
            for(int i=0; i< personList.size(); i++){
                Person p = personList.get(i);
                System.out.println(p.getName());
                System.out.println(p.getAge());
                System.out.println(p.getNik());
            }

            PersonRequestDto personRequestDto = new PersonRequestDto("홍슬기", "26", "먹보");
            personService.update(1L, personRequestDto);

            personList = personRepository.findAll();
            for(int i=0; i< personList.size(); i++){
                Person p = personList.get(i);
                System.out.println(p.getName());
                System.out.println(p.getAge());
                System.out.println(p.getNik());
            }
        };
    }
}
