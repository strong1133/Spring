package com.homework.week02.service;

import com.homework.week02.domain.Person;
import com.homework.week02.domain.PersonRepository;
import com.homework.week02.domain.PersonRequestDto;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@Service
@RequiredArgsConstructor
public class PersonService {

    private final PersonRepository personRepository;

    @Transactional
    public Long update(Long id, PersonRequestDto personRequestDto){
        Person person1 = personRepository.findById(id).orElseThrow(
                () -> new IllegalArgumentException("해당 아이디가 없습니다.")
        );
        person1.update(personRequestDto);
        return person1.getId();
    }
}
