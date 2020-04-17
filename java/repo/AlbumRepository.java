package repo;

import app.AlbumManager;
import entity.Album;
import entity.Artist;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;
import java.util.ArrayList;
import java.util.List;

/**
 * Does different operations on Album table
 */

public class AlbumRepository extends GenericRepository{
    private EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("MusicAlbumsPU");
    EntityManager entityManager = entityManagerFactory.createEntityManager();


    /**
     * Finds an album by id
     */
    public Album findById(int idToBeFound){
        return AlbumManager.entityManager.find(Album.class, idToBeFound);
    }

    /**
     * Finds an album by name with 'createNamedQuery' as requested
     * @param nameToBeFound
     * @return
     */
    public Album findByName(String nameToBeFound){
        Query queryToExecute = AlbumManager.entityManager.createNamedQuery("Album.findByName");
        queryToExecute.setParameter("name", nameToBeFound);
        return (Album)queryToExecute.getSingleResult();
    }

    /**
     * Finds and returns a list of albums having a certain artist
     * @param artist
     * @return
     */
    public List<Album> findByArtist(Artist artist){
        List<Album> albumsFound = new ArrayList<>();
        Query queryToExecute = AlbumManager.entityManager.createNamedQuery("Album.findByName");
        queryToExecute.setParameter("artist", artist);
        albumsFound = queryToExecute.getResultList();
        return albumsFound;
    }
}
