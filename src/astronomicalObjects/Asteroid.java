/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package astronomicalObjects;

import coordinates.Coordinate;
import hitBoxes.SphericalHitBox;


//@author William Kirby

public class Asteroid extends AstronomicalObject
{
    public Asteroid(double mass, Coordinate coordinate, SphericalHitBox hitBox) 
    {
        super(mass, coordinate, hitBox);
    }
}
