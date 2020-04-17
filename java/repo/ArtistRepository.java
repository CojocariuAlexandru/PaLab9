package repo;

import app.AlbumManager;
import entity.Album;
import entity.Artist;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;

/**
 * Does different operations on artist table
 */

public class ArtistRepository extends GenericRepository{
    private EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("MusicAlbumsPU");
    EntityManager entityManager = entityManagerFactory.createEntityManager();

    /**
     * Finds an artist by id
     * @param idToBeFound
     * @return
     */
    public Artist findById(int idToBeFound){
        return AlbumManager.entityManager.find(Artist.class, idToBeFound);
    }

    /**
     * Finds an artist by name with 'createNamedQuery' as requested
     * @param nameToBeFound
     * @return
     */
    public Artist findByName(String nameToBeFound){
        Query queryToExecute = AlbumManager.entityManager.createNamedQuery("Artist.findByName");
        queryToExecute.setParameter("name", nameToBeFound);
        return (Artist)queryToExecute.getSingleResult();
    }
}
