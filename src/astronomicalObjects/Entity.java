/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package astronomicalObjects;

import coordinates.Coordinate;

// @author William Kirby
public class Entity 
{
    protected Coordinate coordinate; // position of entity in world
    
    // Constructor
    public Entity(Coordinate coordinate)
    {
        this.coordinate = coordinate;
    }
    
    // get and set coordinate
    public Coordinate getCoordinate()
    {
        return this.coordinate;
    }
    public void setCoordinate(Coordinate coordinate)
    {
        this.coordinate = coordinate;
    }
}
