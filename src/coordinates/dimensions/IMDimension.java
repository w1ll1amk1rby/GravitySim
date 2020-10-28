/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package coordinates.dimensions;


//@author William Kirby
public class IMDimension extends Dimension
{
    private double velocity; // velocity of dimension every tick
    private double acceleration; // change in velocity for given tick
    
    // Constructor
    public IMDimension(double value, double velocity)
    {
        super(value);
        this.velocity = velocity;
        this.acceleration = 0;
    }
    
    // get and set velocity
    public double getVelocity()
    {
        return this.velocity;
    }
    public void setVelocity(double velocity)
    {
        this.velocity = velocity;
    }
    
    // get and set acceleration
    public double getAcceleration()
    {
        return this.acceleration;
    }
    public void setAcceleration(double acceleration)
    {
        this.acceleration = acceleration;
    }
    
    // name: addToAcceleration
    // description: adds amount to acceleration for current tick
    // variables:
    //      amount: amount added to the acceleration
    // return: none
    public void addToAcceleration(double amount)
    {
        this.acceleration = this.acceleration + amount;
    }
    
    // name: enactAcceleration
    // description: acts acceleration currently stored and resets it
    // variables: none 
    // return: none
    public void enactMotion()
    {
        this.velocity = this.velocity + this.acceleration;
        this.acceleration = 0;
        this.value.set(this.value.get() + this.velocity);
    }
}
