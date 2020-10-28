/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hitBoxes;

import mathmatics.Geometry;
import coordinates.Coordinate;
import javafx.beans.property.DoubleProperty;
import javafx.beans.property.SimpleDoubleProperty;

// @author William Kirby
public class SphericalHitBox extends HitBox
{
    private final DoubleProperty radius; // radius of the spherical object
    private final Coordinate centre; // center of the sphericalObject
    
    //Constructor
    public SphericalHitBox(double radius, Coordinate centre)
    {
        super();
        this.radius = new SimpleDoubleProperty(radius);
        this.centre = centre;
    }
    
    // name: closestDistanceFromCoordinate
    // description: get the closest distance from the coordinate and hitbox
    // variables:
    //      coordinate: Coordinate, coordinate you are testing from
    // return: double, closest distance from hitbox to point
    @Override
    public double closestDistanceFromCoordinate(Coordinate coordinate) 
    {
        double closestDistance = Geometry.getDistance(coordinate,this.centre) - this.radius.get();
        if(closestDistance < 0)
        {
            return 0;
        }
        else
        {
         return closestDistance;
        }
    }
    
    // name: withinHitBox
    // description: test if a point lies within the hitbox
    // variables:
    //      coordinate: Coordinate, coordinate you are testing for
    // return: boolean, if it lies within the hitbox
    @Override
    public boolean withinHitBox(Coordinate coordinate) 
    {
        double distance =  this.closestDistanceFromCoordinate(coordinate);
        return distance == 0.0;
    }
    
    // name: getCentre
    // description: gets centre
    // varaibles: none
    //return: Coordinate, returns the coordinate
    public Coordinate getCentre()
    {
        return this.centre;
    }

    public double getRadius() 
    {
        return this.radius.get();
    }
    public void setRadius(double radius)
    {
        this.radius.set(radius);
    }
    public DoubleProperty getRadiusProperty()
    {
        return this.radius;
    }
    
}
