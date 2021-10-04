package com.example.lesson5demo.data;

import com.example.lesson5demo.entity.Employee;
import com.example.lesson5demo.repository.EmployeeRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class LoadDatabase {

    private static final Logger log = LoggerFactory.getLogger(LoadDatabase.class);

    @Bean
    CommandLineRunner initDatabase(EmployeeRepository repository) {
        return args -> {
            log.info("Preloading data into database");
            Employee employee = new Employee("Ben Aaron", "Developer");
            Employee employee1 = new Employee("Ani Talakhadze", "Developer");
            repository.save(employee);
            repository.save(employee1);
        };
    }

}
