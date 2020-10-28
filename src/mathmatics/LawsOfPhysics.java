/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mathmatics;

import astronomicalObjects.AstronomicalObject;
import coordinates.Coordinate;
import coordinates.dimensions.Dimension;
import coordinates.dimensions.IMDimension;


// @author William Kirby
// laws of physics 
public class LawsOfPhysics 
{
    private final double G; // gravitiational constant
    public static final int numberOfDimensions = 2; //number of dimensions present
    
    // Constructor
    public LawsOfPhysics(double G)
    {
        this.G = G;
    }
    
    // name: actGravityBetween
    // description: act gravity between two astronomical objects, adds to acceleration not motion
    // variables:
    //      objectA: first object in interaction
    //      objectB: second object in interaction
    // return: none
    public void actGravityBetween(AstronomicalObject objectA, AstronomicalObject objectB)
    {
        Coordinate coordinateA = objectA.getCoordinate();
        Coordinate coordinateB = objectB.getCoordinate();
        double distance = Geometry.getDistance(coordinateA,coordinateB);
        double distanceSquared = distance*distance;
        double accelerationA = this.accelerationDueToGravity(distanceSquared,objectB.getMass());
        double ratioA = accelerationA/distance;
        double accelerationB = this.accelerationDueToGravity(distanceSquared, objectA.getMass());
        double ratioB = accelerationB/distance;
        for(int x = 0 ; x < numberOfDimensions ; x++)
        {
            IMDimension dimensionA = (IMDimension) coordinateA.getDimensions()[x]; 
            IMDimension dimensionB = (IMDimension) coordinateB.getDimensions()[x];
             double dimensionDistance =  dimensionB.getValue() - dimensionA.getValue();
             dimensionA.addToAcceleration(ratioA*dimensionDistance);
             dimensionB.addToAcceleration(-1*ratioB*dimensionDistance);
        }
    }
    
    // name: actGravityOnObjectFromAnotherObject
    // description: act gravity on one object from the other object but not both (only adds to acceleration doesn't change coordinate)
    // variables:
    //      actedOn: object affected by gravity
    //      acting: object that is acting gravity on the other object
    // return: none
    public void actGravityOnObjectFromAnotherObject(AstronomicalObject actedOn, AstronomicalObject acting)
    {
        //find distance between the two objects
        double distance = Geometry.getDistance(actedOn.getCoordinate(),acting.getCoordinate());
        // find acceleration
        double acceleration = this.accelerationDueToGravity(distance*distance,acting.getMass());
        // ratio between acceleration and distance
        double ratio = acceleration/distance;
        // for every dimension apply the acceleration using the distance on a dimension and apply the ratio
        for(int x = 0;x < numberOfDimensions; x++)
        {
            IMDimension actedOnDimension = (IMDimension) actedOn.getCoordinate().getDimensions()[x];
            Dimension actingDimension =  acting.getCoordinate().getDimensions()[x];
            double dimensionDistance = actingDimension.getValue() - actedOnDimension.getValue();
            actedOnDimension.addToAcceleration(ratio*dimensionDistance);
        }
    }
    
    // name: accelerationDueToGravity
    // description: find the acceleration due to gravity on an object
    // for a given mass and squared distance (squared for efficiency)
    // variables: 
    //      distanceSquared: objects distance squared from the object being acted on
    //      mass: mass of object acting on
    // return: double, acceleration from gravity
    private double accelerationDueToGravity(double distanceSquared, double mass)
    {
        if(0 < distanceSquared)
        {
            return this.G*mass/distanceSquared;
        }
        else 
        {
            return 0;
        }
    }
    
    // name: ForceDueToGravity
    // description: find the force due to gravity between two objects
    // for a given mass and squared distance (squared for efficiency)
    // variables: 
    //      distanceSquared: objects distance squared from the object being acted on
    //      massOne: mass of object acting on
    //      massTwo: mass of object being acted on
    // return: double, force from gravity
    private double forceDueToGravity(double distanceSquared, double massOne, double massTwo)
    {
        return massOne*this.accelerationDueToGravity(distanceSquared,massTwo);
    }
}