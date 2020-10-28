/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package astronomicalObjects;

import hitBoxes.HitBox;
import coordinates.Coordinate;
import coordinates.dimensions.IMDimension;
import hitBoxes.SphericalHitBox;
import javafx.beans.property.DoubleProperty;
import static mathmatics.LawsOfPhysics.numberOfDimensions;

//@author William Kirby
public class AstronomicalObject extends Entity
{
    protected double mass; // mass of astronomical object
    protected SphericalHitBox hitBox; // hot box of object
    
    // Constructor
    public AstronomicalObject(double mass,Coordinate coordinate, SphericalHitBox hitBox)
    {
        super(coordinate);
        this.mass = mass;
        this.hitBox = hitBox;
        this.setRadius(10);
    }
    
    // get and set hitBox
    public HitBox getHitBox()
    {
        return this.hitBox;
    }
    public void setHitBox(SphericalHitBox hitBox)
    {
        this.hitBox = hitBox;
    }
    
    // get and set mass
    public double getMass()
    {
        return this.mass;
    }
    public void setMass(double mass)
    {
        this.mass = mass;
    }
    public void addToMass(double mass)
    {
        this.mass = this.mass + mass;
    }
    
    
    public double getRadius()
    {
        return this.hitBox.getRadius();
    }
    public void setRadius(double radius)
    {
        this.hitBox.setRadius(radius);
    }
    public DoubleProperty getRadiusProperty()
    {
        return this.hitBox.getRadiusProperty();
    }
    
    // name: addMomentumAndMass
    // decription: adds the objects momentum and mass
    // variables: 
    //      object: AstronomicalObject, object you are adding
    // return: none
    public void addMomentumAndMass(AstronomicalObject object)
    {
        double thisMomentum;
        double objectMomentum;
        double objectMass = object.getMass();
        double totalMass = objectMass + this.mass;
        for(int x = 0; x < numberOfDimensions; x++)
        {
            // calculate momentums
            IMDimension thisDimension = (IMDimension) this.coordinate.getDimensions()[x]; 
            thisMomentum = this.mass * thisDimension.getVelocity();
            IMDimension objectDimension = (IMDimension) object.coordinate.getDimensions()[x];
            objectMomentum = object.mass * objectDimension.getVelocity();
            double newMomentum = thisMomentum + objectMomentum;
            double newVelocity = newMomentum/totalMass;
            thisDimension.addToAcceleration(newVelocity - thisDimension.getVelocity());
        }
        this.mass = this.mass + objectMass;
    }
    
    // name: enactMotion
    // description: enact motion for the given coordinate
    // variables: none
    // return: none
    public void enactMotion()
    {
        for(int x = 0 ; x < numberOfDimensions; x++)
        {
            IMDimension dimension = (IMDimension) this.coordinate.getDimensions()[x];
            dimension.enactMotion();
        }
    }
}
