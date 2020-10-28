/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package coordinates;
import coordinates.dimensions.Dimension;


 
 // @author William Kirby
 // coordinate made up of two dimensions
public class Coordinate 
{
    Dimension[] dimensions;
    
    // Constructor
    public Coordinate(Dimension[] dimensions)
    {
        
        this.dimensions = dimensions;
    }
    
    // get and set dimensions
    public Dimension[] getDimensions()
    {
        return this.dimensions;
    }
    public void setDimensions(Dimension[] dimensions)
    {
        this.dimensions = dimensions;
    }
}
