package com.ikwattro.micro.cloudevents;

import com.ikwattro.micro.cloudevents.domain.Employee;
import com.ikwattro.micro.cloudevents.domain.Person;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.function.Function;

@SpringBootApplication
public class CloudeventsApplication {

	public static void main(String[] args) {
		SpringApplication.run(CloudeventsApplication.class, args);
	}

}
