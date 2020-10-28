/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hitBoxes;

import coordinates.Coordinate;


//@author William Kirby
public abstract class HitBox 
{
    // Constructor
    public HitBox()
    {
        //NOTHING
    }
    
    // get closest distance from the hitbox
    public abstract double closestDistanceFromCoordinate(Coordinate coordinate);
    // see if point is within the hitbox
    public abstract boolean withinHitBox(Coordinate coordinate);
}
