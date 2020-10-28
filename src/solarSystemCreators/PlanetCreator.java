/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package solarSystemCreators;

import astronomicalObjects.Planet;
import astronomicalObjects.Star;
import coordinates.Coordinate;
import coordinates.dimensions.Dimension;
import coordinates.dimensions.IMDimension;
import hitBoxes.SphericalHitBox;
import static mathmatics.LawsOfPhysics.numberOfDimensions;
import static solarSystemCreators.SolarSystemCreatorData.*;


// @author William Kirby
public class PlanetCreator 
{
    public static final double maxPlanetMass = 10;
    public static final double minPlanetMass = 1;
    
    public static Planet generatePlanetOrbitingStar(int seed, Star star,double G)
    {
        double mass = PlanetCreator.minPlanetMass + (seed % (PlanetCreator.maxPlanetMass - PlanetCreator.minPlanetMass));
        Coordinate coordinate = getCoordinate(seed,star,G);
        SphericalHitBox hitBox = new SphericalHitBox(0,coordinate);
        return new Planet(mass,coordinate,hitBox);
    }
    
    public static Coordinate getCoordinate(int seed, Star star,double G)
    {
        double distance = (seed % maxDistanceFromCenter);
        double[] position = new double[numberOfDimensions];
        double[] velocity = new double[numberOfDimensions];
        
        // get random coordinate
        double remainderDistance = distance;
        for(int x = 0;x < numberOfDimensions;x++)
        {
            if(x == (numberOfDimensions - 1))
            {
                position[x] = remainderDistance; 
            }
            else
            {                
                double spare = seed % remainderDistance;
                position[x] = Math.sqrt((remainderDistance*remainderDistance) - (spare*spare));
                remainderDistance = spare;
            }
        }
        
        // randomise negatives
        for(int x = 0;x < numberOfDimensions;x++)
        {
            int leftOver = (int) (position[x] % 2);
            if(leftOver == 0)
            {
                position[x] = -1*position[x];
            }
        }
        
        // set the velocities
        double totalVelocity = Math.sqrt(star.getMass()*G/distance);
        double ratio = distance/totalVelocity;
        for(int x = 0;x < numberOfDimensions; x++)
        {
            if(x == (numberOfDimensions - 1))
            {
                velocity[0] = -1*(position[x]/ratio);
            }
            else
            {
                velocity[x + 1] = (position[x]/ratio);
            }
        }
        
        // create coordinate
        Dimension[] dimensions = new Dimension[numberOfDimensions];
        for(int x = 0 ; x < numberOfDimensions ; x++)
        {
            dimensions[x] = new IMDimension(position[x],velocity[x]);
        }
        return new Coordinate(dimensions);
    }
    
}
