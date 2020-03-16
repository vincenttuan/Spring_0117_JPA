package com.jpa.single;

import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.Persistence;

public class Test_Query {
    public static void main(String[] args) {
        EntityManager em = Persistence.createEntityManagerFactory("p1").createEntityManager();
        
        //List<Person> list = em.createQuery("Select p From Person p", Person.class).getResultList();
        List<Person> list = em.createNamedQuery("Person.findAll", Person.class).getResultList();
        System.out.printf("+-%-10s-+-%<-10s-+\n", "----------");
        System.out.printf("| %-10s | %-10s |\n", "ID", "NAME");
        for (Person person : list) {
            System.out.printf("+-%-10s-+-%<-10s-+\n", "----------");
            System.out.printf("| %-10s | %-10s |\n", person.getId(), person.getName());
        }
        System.out.printf("+-%-10s-+-%<-10s-+\n", "----------");
        
        System.out.println(list);
        
        Person person = em.createNamedQuery("Person.findByName", Person.class)
                .setParameter("name", "John").getSingleResult();
        System.out.println(person.getId() + ", " + person.getName());
        
        em.close();
    }
}
