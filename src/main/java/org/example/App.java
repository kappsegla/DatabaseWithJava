package org.example;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;
import org.example.entity.Song;

public class App {
    public static void main(String[] args) {

        EntityManagerFactory factory = Persistence.createEntityManagerFactory("default");

        EntityManager entityManager = factory.createEntityManager();

        Song song = new Song();
        song.setName("Mamma Mia");
        song.setArtist("Abba");

        entityManager.getTransaction().begin();

        entityManager.persist(song);

        entityManager.getTransaction().commit();

        entityManager.close();


        factory.close();
    }
}
