package com.jpa.single;

import javax.persistence.EntityManager;
import javax.persistence.Persistence;

public class Test_Update {
    public static void main(String[] args) {
        EntityManager em = Persistence.createEntityManagerFactory("p1").createEntityManager();
        try {
            Person person = em.find(Person.class, 2);
            person.setName("Happy");
            em.getTransaction().begin();
            em.merge(person);
            em.getTransaction().commit();
        } catch (Exception e) {
            em.getTransaction().rollback();
        }
        em.close();
        System.out.println("Update OK !");
    }
}
