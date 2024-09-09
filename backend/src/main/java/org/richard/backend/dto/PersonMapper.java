package org.richard.backend.dto;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.richard.backend.entity.Person;
import org.richard.backend.repository.PersonRepository;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
@Slf4j
public class PersonMapper {
    private final PersonRepository personRepository;

    public PersonDto toDto(Person person) {
        PersonDto personDto = new PersonDto();
        return personDto;
    }

    public Person toEntity(PersonDto personDto) {
        Person person = new Person();
        return person;
    }
}
