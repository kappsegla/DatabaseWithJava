package org.example;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;
import org.example.entity.Song;

import java.util.List;

public class SongService {
    public static final EntityManagerFactory factory = Persistence.createEntityManagerFactory("default");

    public List<Song> queryForSongs() {
        EntityManager entityManager = factory.createEntityManager();
        List<Song> songs = entityManager.createQuery("select song from Song song", Song.class).getResultList();
        entityManager.close();
        return songs;
    }

    public Song getSongById(Long songID) {
        EntityManager entityManager = factory.createEntityManager();
        var song = entityManager.find(Song.class, songID);
        entityManager.close();
        return song;
    }

    public void saveSong(Song song) {
        EntityManager entityManager = factory.createEntityManager();
        entityManager.getTransaction().begin();
        entityManager.persist(song);
        entityManager.getTransaction().commit();
        entityManager.close();
    }

    public void updateSong(Song song) {
        EntityManager entityManager = factory.createEntityManager();
        entityManager.getTransaction().begin();
        entityManager.merge(song);
        entityManager.getTransaction().commit();
        entityManager.close();
    }

    public void removeSong(Song song) {
        EntityManager entityManager = factory.createEntityManager();
        entityManager.getTransaction().begin();
        entityManager.remove(song);
        entityManager.getTransaction().commit();
        entityManager.close();
    }
}
