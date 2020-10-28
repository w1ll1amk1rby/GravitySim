/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package coordinates.dimensions;

// @author William Kirby

import javafx.beans.property.DoubleProperty;
import javafx.beans.property.SimpleDoubleProperty;

// used in Coordinate for each dimension the coordinate holds
public class Dimension 
{
    protected DoubleProperty value; //value in dimension
    
    //Constructor
    public Dimension(double value)
    {
        this.value = new SimpleDoubleProperty(value);
    }
    
    // get and set value
    public void setValue(double value)
    {
        this.value.set(value);
    }
    public double getValue()
    {
        return value.get();
    }
    public DoubleProperty getPropertyValue()
    {
        return value;
    }
}
