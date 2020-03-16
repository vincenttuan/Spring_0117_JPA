package com.jpa.single;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class Person_CRUD {
    public static void main(String[] args) {
        AnnotationConfigApplicationContext appContext = new AnnotationConfigApplicationContext();
        appContext.scan("com.jpa");
        appContext.refresh();
        
        PersonService service = (PersonService) appContext.getBean("personService");
        // Save
        //Person person = new Person();
        //person.setName("Helen");
        //service.save(person);
        
        // Update
        //service.updateNameById("Helen2", 7);
        
        // findAll
        service.printAll();
    }
}
