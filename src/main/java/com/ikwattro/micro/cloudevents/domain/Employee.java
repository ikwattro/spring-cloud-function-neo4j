package com.ikwattro.micro.cloudevents.domain;

public class Employee {

    private String name;

    public Employee(Person person) {
        this.name = person.getFirstName() + " " + person.getLastName();
    }

    public String getName() {
        return name;
    }
}
