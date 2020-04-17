package repo;

import clojure.lang.Compiler;
import entity.Chart;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;
import java.util.ArrayList;
import java.util.List;

/**
 * Implements operations on charts
 */

public class ChartRepository extends GenericRepository{
    private EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("MusicAlbumsPU");
    EntityManager entityManager = entityManagerFactory.createEntityManager();

    /**
     * Returns a list of chart rows representing the albums ordered by release_year
     * @return
     */
    public List<Chart> sortAlbumsOnChart(){
        List<Chart> sortedAlbums = new ArrayList<>();
        String sortingQuery = "SELECT c.id, c.album_id FROM Chart c JOIN Album a ON c.album_id = a.id ORDER BY a.release_year";
        Query query = entityManager.createQuery(sortingQuery);
        sortedAlbums = query.getResultList();
        return sortedAlbums;
    }


    /**
     * Returns a list of charts representing albums that match a genre given as parameter
     * @param musicGenre
     * @return
     */
    public List<Chart> getByGenres(String musicGenre){
        List<Chart> foundAlbums = new ArrayList<>();
        String sortingQuery = "SELECT c.id, c.album_id FROM Char c JOIN Album a ON c.album_id = a.id WHERE a.musicGenre = musicGenre";
        Query query = entityManager.createQuery(sortingQuery);
        foundAlbums = query.getResultList();
        return foundAlbums;
    }
}
