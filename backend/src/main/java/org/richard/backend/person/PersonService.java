package org.richard.backend.person;

import lombok.RequiredArgsConstructor;
import org.richard.backend.entity.Advertising;
import org.richard.backend.entity.Person;
import org.richard.backend.advertising.AdvertisingRepository;
import org.richard.backend.clientStatus.ClientStatusRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@RequiredArgsConstructor
@Service
public class PersonService {
    private final PersonRepository personRepository;
    private final PersonMapper personMapper;
    private final AdvertisingRepository advertisingRepository;
    private final ClientStatusRepository clientStatusRepository;

    public List<PersonDTO> findAll() {
        return personRepository.findAll().stream()
                .map(personMapper::toDto)
                .collect(Collectors.toList());
    }

    public Optional<PersonDTO> findById(Long id) {
        return personRepository.findById(id)
                .map(personMapper::toDto);
    }

    public PersonDTO save(PersonDTO personDTO) {
        var advertising = advertisingRepository.findById(personDTO.getAdvertising())
                .orElseThrow(() -> new RuntimeException("Advertising not found"));
        var clientStatus = clientStatusRepository.findById(personDTO.getClientStatus())
                .orElseThrow(() -> new RuntimeException("Client status not found"));

        Person person = personMapper.toEntity(personDTO, advertising, clientStatus);
        Person savedPerson = personRepository.save(person);
        return personMapper.toDto(savedPerson);
    }

    public void deleteById(Long id) {
        personRepository.deleteById(id);
    }

    public PersonDTO updatePerson(Long id, PersonDTO personDTO) {
        return personRepository.findById(id).map(person -> {
            Advertising advertising = advertisingRepository.findById(personDTO.getAdvertising())
                    .orElseThrow(() -> new RuntimeException("Advertising not found"));

            person.setName(personDTO.getName());
            person.setPhone(personDTO.getPhone());
            person.setAdvertising(advertising);

            Person updatedPerson = personRepository.save(person);
            return personMapper.toDto(updatedPerson);
        }).orElseThrow(() -> new RuntimeException("Person not found with id " + id));
    }
}
