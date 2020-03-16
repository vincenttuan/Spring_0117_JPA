package com.jpa.single;

import javax.persistence.EntityManager;
import javax.persistence.Persistence;

public class Test_Add {
    public static void main(String[] args) {
        Person person = new Person();
        person.setName("Jane");
        
        EntityManager em = Persistence.createEntityManagerFactory("p1").createEntityManager();
        try {
            em.getTransaction().begin();
            em.persist(person);
            em.getTransaction().commit();
        } catch (Exception e) {
            em.getTransaction().rollback();
        }
        em.close();
        System.out.println("Add OK !");
    }
}
