package io.kreiger.web.home.controller;

import io.kreiger.web.home.document.Person;
import io.kreiger.web.home.repository.PersonRepository;
import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.Assert;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/api/people")
public class PersonRestController {

    private final PersonRepository personRepository;

    @Autowired
    public PersonRestController(PersonRepository personRepository) {
        Assert.notNull(personRepository, "PersonRepository can not be NULL!");

        this.personRepository = personRepository;
    }

    @GetMapping("")
    public List<Person> getAllPeople() {
        List<Person> people;

        people = personRepository.findAll();

        return people;
    }

    @GetMapping("/{id}")
    public Person getPersonById(@PathVariable("id") ObjectId id) {
        return personRepository.findByid(id);
    }

    @PostMapping("")
    public Person insertPerson(@Valid @RequestBody Person person) {
        personRepository.save(person);

        return person;
    }

    @PutMapping("/{id}")
    public Person modifyPersonById(@PathVariable("id") ObjectId id, @Valid @RequestBody Person person) {
        person.setId(id);
        personRepository.save(person);

        return person;
    }

    @DeleteMapping("/{id}")
    public void deletePersonById(@PathVariable("id") ObjectId id) {
        personRepository.delete(personRepository.findByid(id));
    }
}
