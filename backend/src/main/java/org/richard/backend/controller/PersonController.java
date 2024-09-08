package org.richard.backend.controller;

import org.richard.backend.entity.Person;
import org.richard.backend.service.PersonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController

@RequestMapping("/api/persons")
public class PersonController {

    private final PersonService personService;

    @Autowired
    public PersonController(PersonService personService) {
        this.personService = personService;
    }

    // Get all persons
    @GetMapping
    public List<Person> getAllPersons() {
        return personService.findAll();
    }

    // Get person by ID
    @GetMapping("/{id}")
    public ResponseEntity<Person> getPersonById(@PathVariable Long id) {
        return personService.findById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    // Create a new person
    @PostMapping
    public Person createPerson(@RequestBody Person person) {
        return personService.save(person);
    }

    // Update an existing person
    @PutMapping("/{id}")
    public ResponseEntity<Person> updatePerson(
            @PathVariable Long id,
            @RequestBody Person personDetails) {
        return ResponseEntity.ok(personService.updatePerson(id, personDetails));
    }

    // Delete a person by ID
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletePerson(@PathVariable Long id) {
        personService.deleteById(id);
        return ResponseEntity.noContent().build();
    }
}

