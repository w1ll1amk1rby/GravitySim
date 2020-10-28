/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package nodes;

import astronomicalObjects.AstronomicalObject;
import coordinates.dimensions.Dimension;
import javafx.scene.shape.Circle;

/**
 *
 * @author William Kirby
 */
public class AstronomicalObjectVisualiser extends Circle
{
    private final AstronomicalObject object; // planet you are representing

    
    public AstronomicalObjectVisualiser(AstronomicalObject object)
    {
        super();
        this.object = object;
        this.bindValues();
    }
    
    // get object
    public AstronomicalObject getObject()
    {
        return this.object;
    }
    
    private void bindValues()
    {
        Dimension[] dimensions = this.object.getCoordinate().getDimensions();
        this.centerXProperty().bind(dimensions[0].getPropertyValue().add(500));
        this.centerYProperty().bind(dimensions[1].getPropertyValue().add(500));
        this.radiusProperty().bind(this.object.getRadiusProperty());
    }
}
