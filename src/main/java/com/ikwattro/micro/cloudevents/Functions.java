package com.ikwattro.micro.cloudevents;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.ikwattro.micro.cloudevents.domain.Employee;
import com.ikwattro.micro.cloudevents.domain.Person;
import org.neo4j.driver.Driver;
import org.neo4j.driver.Session;
import org.neo4j.driver.SessionConfig;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.Map;
import java.util.function.Function;

@Configuration
public class Functions {

    private static final Logger LOG = LoggerFactory.getLogger(Functions.class);

    private final Driver driver;

    public Functions(Driver driver) {
        this.driver = driver;
    }

    @Bean
    public Function<Person, Employee> hire() {
        return person -> {
            try {
                logReceivedPerson(person);
                Employee employee = new Employee(person);
                saveEmployee(employee);

                return employee;
            } catch (Exception e) {
                throw new RuntimeException(e);
            }
        };
    }

    private void logReceivedPerson(Person person) throws Exception {
        LOG.info("Received person " + new ObjectMapper().writeValueAsString(person));
    }

    private void saveEmployee(Employee employee) {
        try (Session session = driver.session(SessionConfig.forDatabase("employees"))) {
            session.writeTransaction((tx) -> {
                tx.run("CREATE (n:Employee) SET n.name = $name", Map.of("name", employee.getName()));
                return null;
            });
        }
    }
}
