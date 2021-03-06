/*
 * The EventManger stores a point that represents the location for the event. The point 
 * is given as a String in the Well-Known Text (WKT) format. See the JTS WTKReader 
 * JavaDoc for more information about the WTK format. (The assemble() method is 
 * necessary because the Maven exec plugin parses string with spaces as a list
 * of command-line arguments.)
 */
package polimi.thesis.event;

import com.vividsolutions.jts.geom.Geometry;
import com.vividsolutions.jts.geom.Point;
import com.vividsolutions.jts.io.ParseException;
import com.vividsolutions.jts.io.WKTReader;
import polimi.thesis.util.JPAUtil;

import javax.persistence.EntityManager;
import javax.persistence.Query;
import java.util.Date;
import java.util.List;

/**
 *
 * @author Teimourikia
 */
public class EventManager {
    
    public static void main(String[] args)
    {
        EventManager mgr =  new EventManager();
        
        if(args[0].equals("store"))
        {
            mgr.createAndStoreEvent("My Event", new Date(), assemble(args));
        }
        JPAUtil.close();
    }
    
    private void createAndStoreEvent(String title, Date theDate, String wktPoint)
    {
        Geometry geom = wktToGeometry(wktPoint);
        
        if(!geom.getGeometryType().equals("Point"))
        {
            throw new RuntimeException("Geometry must be a Point. Got a " + geom.getGeometryType());
        }
        
        EntityManager em = JPAUtil.createEntityManager();
        
        em.getTransaction().begin();
        
        Event theEvent = new Event();
        theEvent.setTitle(title);
        theEvent.setDate(theDate);
        theEvent.setLocation((Point) geom);
        
        em.persist(theEvent);
        em.getTransaction().commit();
        em.close();
    }
    
    private Geometry wktToGeometry(String wktPoint)
    {
        WKTReader fromText = new WKTReader();
        Geometry geom = null;
        
        try
        {
            geom = fromText.read(wktPoint);
        }
        catch(ParseException e)
        {
            throw new RuntimeException("Not a WKT string: " + wktPoint);
        }
        
        return geom;
    }
    
    /**
     * Utility method to assemble all arguments and save the first into a String
     */
    private static String assemble(String[] args)
    {
        StringBuilder builder = new StringBuilder();
        for(int i=1; i<args.length; i++)
        {
            builder.append(args[i]).append(" ");
        }
        return builder.toString();
    }
}
