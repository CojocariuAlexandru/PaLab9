package app;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import entity.Album;
import entity.Artist;
import util.PersistenceUtil;
import java.sql.*;

/**
 * Creates a basic example for creating tables and instances of rows
 */
public class AlbumManager {
    public static EntityManager entityManager = null;

    public static void main(String[] args){
        PersistenceUtil.getPersistenceUtilInstance().generateEntityManager(entityManager);
        PersistenceUtil.getPersistenceUtilInstance().startTransaction(entityManager);

        Artist artist = new Artist(1, "alex", "romania");
        Album album = new Album(1, 1999, "myAlbum", artist);


        entityManager.getTransaction().commit();
        PersistenceUtil.getPersistenceUtilInstance().closeEntityManager(entityManager);
    }
}
