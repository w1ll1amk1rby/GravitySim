/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mathmatics;

import coordinates.Coordinate;
import static java.lang.Math.sqrt;
import static mathmatics.LawsOfPhysics.numberOfDimensions;

/**
 *
 * @author William Kirby
 */
public class Geometry 
{
    
    // name: getDistance
    // description: gets a distance betweeen two seperate coordinates  
    // variables:
    //      coordinateOne: first point
    //      coordinateTwo: second point
    // return: double, distance between two points
    public static double getDistance(Coordinate coordinateOne,Coordinate coordinateTwo)
    {
        double distance = 0;
        for(int x = 0 ; x < numberOfDimensions; x++ )
        {
            double valueOne = coordinateOne.getDimensions()[x].getValue();
            double valueTwo = coordinateTwo.getDimensions()[x].getValue();
            double dimensionDistance = valueOne - valueTwo;
            distance = sqrt((distance*distance) + (dimensionDistance*dimensionDistance));
        }
        return distance;
    }
}
