package examens.spring.spring.Controller;

import java.util.List;
import java.util.function.Function;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import examens.spring.spring.PersonNotFoundException;
import examens.spring.spring.Entity.Person;
import examens.spring.spring.Repository.PersonRepository;



@RestController
public class PersonController {

    private final PersonRepository repo;

    PersonController(PersonRepository repo) {
        this.repo = repo;
    }

    @GetMapping("/persons")
    List<Person> all() {
        return repo.findAll();
    }

    @PostMapping("/persons")
    Person newPerson(@RequestBody Person newPerson) {
        return repo.save(newPerson);
    }

    @GetMapping("/persons/{id}")
    Person one(@PathVariable Long id) {
        return repo.findById(id).orElseThrow(() -> new PersonNotFoundException(id));
    }

    @PutMapping("/persons/{id]")
    Person replacePerson(@RequestBody Person newPerson, @PathVariable Long id) {

        return repo.findById(id).map(person -> {
            person.setName(newPerson.getName());
            person.setAge(newPerson.getAge());
            person.setCountry(newPerson.getCountry());
            person.setFavourit_colour(newPerson.getFavourit_colour());
            return repo.save(person);
        }).orElseGet(() -> {
            newPerson.setId(id);
            return repo.save(newPerson);
        });
    }

    @DeleteMapping("/person/{id]")
    void deletePerson(@PathVariable Long id) {
        repo.deleteById(id);
    }
}
