package org.richard.backend.person;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.richard.backend.entity.Advertising;
import org.richard.backend.entity.ClientStatus;
import org.richard.backend.entity.Person;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
@Slf4j
public class PersonMapper {

    public PersonDTO toDto(Person person) {
        return PersonDTO.builder()
                .advertising(person.getAdvertising().getId())
                .id(person.getId())
                .name(person.getName())
                .phone(person.getPhone())
                .clientStatus(person.getClientStatus().getId())
                .build();
    }

    public Person toEntity(PersonDTO personDto, Advertising advertising, ClientStatus clientStatus) {

        return Person.builder()
                .id(personDto.getId())
                .name(personDto.getName())
                .advertising(advertising)
                .phone(personDto.getPhone())
                .clientStatus(clientStatus)
                //.orders() when i need take orders too?
                .build();
    }
}
