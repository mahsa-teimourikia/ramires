/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package polimi.thesis.event;

import com.vividsolutions.jts.geom.Point;
import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.Type;

import javax.persistence.*;
import java.util.Date;

/**
 *
 * @author Teimourikia
 */
@Entity
public class Event {
    
    @Id
    @GeneratedValue(generator="increment")
    @GenericGenerator(name="increment", strategy="increment")
    private int id;
    
    private String title;
    
    private Date date;
    
    /**
     * Note the @Type annotation. This informs Hibernate that the location attribute 
     * is of type Geometry. The @Type annotation is Hibernate specific, and the only 
     * non-JPA annotation that is required. (In future versions of Hibernate 
     * (version 5 and later) it will no longer be necessary to explicitly declare the 
     * Type of Geometry-valued attributes.)
     */
    @Type(type="org.hibernate.spatial.GeometryType")
    private Point location;
    
    public Event(){
        
    }
    
    public int getId(){
        return id;
    }
    
    private void setId(int id){
        this.id = id;
    }
    
    public Date getDate(){
        return date;
    }
    
    public void setDate(Date date){
        this.date = date;
    }
    
    public String getTitle() {
            return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Point getLocation() {
        return this.location;
    }

    public void setLocation(Point location) {
        this.location = location;
    }
}
