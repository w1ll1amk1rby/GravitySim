/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package solarSystemCreators;

import astronomicalObjects.Star;
import coordinates.Coordinate;
import coordinates.dimensions.Dimension;
import hitBoxes.SphericalHitBox;
import static mathmatics.LawsOfPhysics.numberOfDimensions;

// @author William Kirby
public class StarCreator 
{
    public static final double maxStarMass = 1200;
    public static final double minStarMass = 1000;
    
    
    public static Star generateStar(int seed)
    {
        double mass = StarCreator.minStarMass + (seed % (StarCreator.maxStarMass - StarCreator.minStarMass));
        Coordinate coordinate = getStarCoordinate();
        SphericalHitBox hitBox = new SphericalHitBox(0,coordinate);
        return new Star(mass,coordinate,hitBox);
    }
    
    private static Coordinate getStarCoordinate()
    {
        Dimension[] dimensions = new Dimension[numberOfDimensions];
        for(int x = 0;x < numberOfDimensions; x++)
        {
            dimensions[x] = new Dimension(0);
        }
        Coordinate coordinate = new Coordinate(dimensions);
        return coordinate;
    }
}
