package repo;

import app.AlbumManager;
import entity.Artist;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;

/**
 * Abstract class of repositories
 * @param <T>
 */

public abstract class GenericRepository<T> {

    /**
     * Creates an entity into the database
     * @param objectName
     */
    public void create(T objectName){
        AlbumManager.entityManager.persist(objectName);
    }
}
