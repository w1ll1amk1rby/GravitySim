/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package panes;

import astronomicalObjects.Asteroid;
import astronomicalObjects.AstronomicalObject;
import astronomicalObjects.Planet;
import astronomicalObjects.Star;
import java.util.ArrayList;
import javafx.scene.layout.Pane;
import nodes.AstronomicalObjectVisualiser;
import solarSystem.SolarSystem;

/**
 *
 * @author William Kirby
 */
public class SolarSystemPane extends Pane 
{
    public SolarSystemPane(SolarSystem ss)
    {
        super();
        ArrayList<Planet> planets = ss.getPlanets();
        ArrayList<Asteroid> asteroids = ss.getAsteroids();
        Star star = ss.getStar();
        for(int x = 0;x < planets.size();x++)
        {
            this.addAstronomicalObject(planets.get(x));
        }
        for(int x = 0;x < asteroids.size();x++)
        {
            this.addAstronomicalObject(asteroids.get(x));
        }
        this.addAstronomicalObject(star);
    }
    
    public void addAstronomicalObject(AstronomicalObject object)
    {
        AstronomicalObjectVisualiser objectVisualiser = new AstronomicalObjectVisualiser(object);
        this.getChildren().add(objectVisualiser);
    }
}
