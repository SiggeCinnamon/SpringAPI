package examens.spring.spring;

import org.slf4j.LoggerFactory;
import org.slf4j.Logger;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import examens.spring.spring.Entity.Person;
import examens.spring.spring.Repository.PersonRepository;

@Configuration
public class LoadDatabase {

    private static final Logger log = LoggerFactory.getLogger(LoadDatabase.class);

    @Bean
    CommandLineRunner initDatabase(PersonRepository repo) {
        return args -> {
            log.info("test", repo.findAll());
        };
    }

}
