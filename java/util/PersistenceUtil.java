package util;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

/**
 * Does operations with EntityManager class, implements singleton
 */

public class PersistenceUtil {
    private static PersistenceUtil persistenceUtil = new PersistenceUtil();
    private EntityManagerFactory entityManagerFactory;

    private PersistenceUtil(){
        entityManagerFactory = null;
    }

    /**
     * Generates an entity manager for out EntityManager reference given as parameter
     * @param entityManager
     */
    public void generateEntityManager(EntityManager entityManager){
        entityManagerFactory = Persistence.createEntityManagerFactory("MusicAlbumsPU");
        entityManager = entityManagerFactory.createEntityManager();
    }

    public void startTransaction(EntityManager entityManager){
        entityManager.getTransaction().begin();
    }

    public static PersistenceUtil getPersistenceUtilInstance(){
        return persistenceUtil;
    }
    public static void closeEntityManager(EntityManager entityManager){
        entityManager.close();
    }
}
