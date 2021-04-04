package examens.spring.spring.Repository;

import examens.spring.spring.Entity.Person;

import java.util.Collection;

import org.springframework.data.jpa.repository.JpaRepository;

public interface PersonRepository extends JpaRepository<Person, Long> {

    Collection<Person> findByName(String name);

    Collection<Person> findByAge(int age);

    Collection<Person> findByCountry(String country);

    Collection<Person> findByFavouritColour(String favouritColour);

}
