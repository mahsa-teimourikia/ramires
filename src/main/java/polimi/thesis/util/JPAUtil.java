/*
 * The JPAUtil class creates the EntityManagerFactory for the application, 
 * and provides a method to create EntityManager instances.
 */
package polimi.thesis.util;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

/**
 *
 * @author Teimourikia
 */
public class JPAUtil {
    
    private static final EntityManagerFactory emFactory;
    
    static{
        try{
            emFactory  = Persistence.createEntityManagerFactory("org.hibernate.events.jpa");
        }
        catch(Throwable ex)
        {
            System.err.println("Cannot create EntityManagerFactory.");
            throw new ExceptionInInitializerError(ex);
        }
    }
    
    public static EntityManager createEntityManager()
    {
        return emFactory.createEntityManager();
    }
    
    public static void close()
    {
        emFactory.close();
    }
}
