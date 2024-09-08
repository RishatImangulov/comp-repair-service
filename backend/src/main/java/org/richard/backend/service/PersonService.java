package org.richard.backend.service;

import org.richard.backend.entity.Person;
import org.richard.backend.repository.PersonRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PersonService {
    private final PersonRepository personRepository;

    @Autowired
    public PersonService(PersonRepository personRepository) {
        this.personRepository = personRepository;
    }

    public List<Person> findAll() {
        return personRepository.findAll();
    }

    public Optional<Person> findById(Long id) {
        return personRepository.findById(id);
    }

    public Person save(Person person) {
        return personRepository.save(person);
    }

    public void deleteById(Long id) {
        personRepository.deleteById(id);
    }

    public Person updatePerson(Long id, Person personDetails) {
        return personRepository.findById(id).map(person -> {
            person.setName(personDetails.getName());
            person.setPhone(personDetails.getPhone());
            person.setAdvertising(personDetails.getAdvertising());
            return personRepository.save(person);
        }).orElseThrow(() -> new RuntimeException("Person not found with id " + id));
    }
}
