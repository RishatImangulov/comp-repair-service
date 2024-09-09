package org.richard.backend.controller;

import lombok.AllArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.richard.backend.entity.Person;
import org.richard.backend.service.PersonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController

@RequiredArgsConstructor
@RequestMapping("/api/persons")
public class PersonController {

    private final PersonService personService;

//    @Autowired
//    public PersonController(PersonService personService) {
//        this.personService = personService;
//    }

    @GetMapping
    public ResponseEntity<List<Person>> getAllPersons() {
        return ResponseEntity.status(200).body(personService.findAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Person> getPersonById(@PathVariable Long id) {
        return personService.findById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping
    public ResponseEntity<Person> createPerson(@RequestBody Person person) {
        return ResponseEntity.status(201).body(personService.save(person));
    }

    @PutMapping("/{id}")
    public ResponseEntity<Person> updatePerson(
            @PathVariable Long id,
            @RequestBody Person personDetails) {
        return ResponseEntity.ok(personService.updatePerson(id, personDetails));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletePerson(@PathVariable Long id) {
        personService.deleteById(id);
        return ResponseEntity.noContent().build();
    }
}

