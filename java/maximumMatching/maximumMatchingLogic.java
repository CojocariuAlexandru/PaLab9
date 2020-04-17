package maximumMatching;

import entity.Chart;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;
import java.util.ArrayList;
import java.util.List;

/**
 * Bonus - return a subset of albums such that it has maximum cardinality and there are not two albums having the same genre or artist name
 *
 * My solution:
 * Consider the set of different existent genres as a set of nodes where each node represents a genre
 * In the same fashion, consider that each different existent artist name is modeled with a node
 * Each album represents an edge from a genre to an artist name
 * By drawing all such edges we form a bipartite graph from genres to artist names
 * Having this representation it is easy to see that the problem translates to finding the maximum matching in a bipartite graph
 * While this is a hard problem, thankfully it was solved and we can employ Hopkroft Karp algoritm
 */

public class maximumMatchingLogic {
    private EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("MusicAlbumsPU");
    EntityManager entityManager = entityManagerFactory.createEntityManager();
    private Chart chart;
    private List<String> artistNames;
    private List<String> genreNames;
    private int[][] neighbours;
    private int numberOfEdgesSelected;

    public maximumMatchingLogic(){
        chart = new Chart();
        artistNames = new ArrayList<>();
        genreNames = new ArrayList<>();
        neighbours = new int[100][100];
    }

    public void retrieveInformation(){
        String sortingQuery = "SELECT name FROM album";
        Query query = entityManager.createQuery(sortingQuery);
        this.artistNames = query.getResultList();

        sortingQuery = "SELECT musicGenre FROM album";
        query = entityManager.createQuery(sortingQuery);
        this.genreNames = query.getResultList();
    }

    public void resolveMatchingProblem(){
        while(findAugmentingPath() == true){
            numberOfEdgesSelected = numberOfEdgesSelected + 1;
        }
    }

    private boolean findAugmentingPath(){
        int i, j, t;
        for(i=0; i<artistNames.size(); i++){
            for(j=0; j<genreNames.size(); j++){
                if(genreNames.get(j).compareTo(genreNames.get(i))){
                    if(neighbours[i][j] == 0 && neighbours[j][i] == 0){
                        neighbours[i][j] = 1;
                        neighbours[j][i] = 1;
                        return true;
                    }
                    else if(neighbours[i][j] == 0 && neighbours[j][i] == 1){
                        neighbours[i][j] = 1;
                        for(t=0; t<genreNames.size(); t++){
                            if(neighbours[j][t] == 1){
                                neighbours[j][t] = 0;
                                return false;
                            }
                        }
                    }
                }
            }
        }
    }
}
