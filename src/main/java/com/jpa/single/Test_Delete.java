package com.jpa.single;

import javax.persistence.EntityManager;
import javax.persistence.Persistence;

public class Test_Delete {
    public static void main(String[] args) {
        EntityManager em = Persistence.createEntityManagerFactory("p1").createEntityManager();
        try {
            Person person = em.find(Person.class, 2);
            em.getTransaction().begin();
            em.remove(person);
            em.getTransaction().commit();
        } catch (Exception e) {
            em.getTransaction().rollback();
        }
        em.close();
        System.out.println("Delete OK !");
    }
}
