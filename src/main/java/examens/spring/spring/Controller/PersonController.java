package examens.spring.spring.Controller;

import java.util.Collection;
import java.util.List;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import examens.spring.spring.Exception.PersonNotFoundException;
import examens.spring.spring.Entity.Person;
import examens.spring.spring.Repository.PersonRepository;

@RestController
public class PersonController {

    private final PersonRepository repo;

    PersonController(PersonRepository repo) {
        this.repo = repo;
    }

    @GetMapping("/persons/get/all")
    List<Person> all() {
        return repo.findAll();
    }

    @GetMapping("/persons/get/id/{id}")
    Person one(@PathVariable Long id) {
        return repo.findById(id).orElseThrow(() -> new PersonNotFoundException(id));
    }

    @GetMapping("/persons/get/name/{name}")
    Collection<Person> getName(@PathVariable String name) {
        return repo.findByName(name);
    }

    @GetMapping("/persons/get/age/{age}")
    Collection<Person> getAge(@PathVariable int age) {
        return repo.findByAge(age);
    }

    @GetMapping("/persons/get/country/{country}")
    Collection<Person> getCountry(@PathVariable String country) {
        return repo.findByCountry(country);
    }

    @GetMapping("/persons/get/favouriteColour/{favourite_Colour}")
    Collection<Person> getFavouriteColour(@PathVariable String favouriteColour) {
        return repo.findByFavouritColour(favouriteColour);
    }

    @PostMapping("/persons/post/many")
    Collection<Person> postMany(@RequestBody Collection<Person> newPerson) {
        return repo.saveAll(newPerson);
    }

    @PutMapping("/persons/update/id/{id]")
    Person updatePersonById(@RequestBody Person newPerson, @PathVariable Long id) {

        return repo.findById(id).map(person -> {
            person.setName(newPerson.getName());
            person.setAge(newPerson.getAge());
            person.setCountry(newPerson.getCountry());
            person.setFavouritColour(newPerson.getFavouritColour());
            return repo.save(person);
        }).orElseGet(() -> {
            newPerson.setId(id);
            return repo.save(newPerson);
        });
    }

    @PostMapping("/persons")
    public Person postPerson(@RequestBody Person newPerson) {
        return repo.saveAndFlush(newPerson);
    }

    @DeleteMapping("/person/delete/{id]")
    void deletePerson(@PathVariable Long id) {
        repo.deleteById(id);
    }

    @GetMapping("/persons/age/{age}")
    Collection<Person> getPersonByAge(@PathVariable int age) {
        return repo.findByAge(age);
    }

}
