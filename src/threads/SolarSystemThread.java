/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package threads;

import astronomicalObjects.Planet;
import astronomicalObjects.Star;
import coordinates.dimensions.Dimension;
import java.util.ArrayList;
import java.util.concurrent.TimeUnit;
import mathmatics.Geometry;
import solarSystem.SolarSystem;


//@author William Kirby
// thread that runs a solarsystems logic
public class SolarSystemThread extends Thread 
{
    private final SolarSystem solarSystem;
    private boolean continueThread;
    
    // Constructor
    public SolarSystemThread(SolarSystem solarSystem)
    {
        this.solarSystem = solarSystem;
        this.continueThread = true;
    }
    
    // get solarSystem
    public SolarSystem getSolarSystem()
    {
        return this.solarSystem;
    }
    
    // name: run
    // description: thread code start point
    // variables: none
    // return: none
    @Override
    public void run()
    {
        this.solarSystemLoop();
    }
    
    // name: solarSystemLoop
    // description: loop that continues the motion of the solar system 
    // varaibles: none
    // return: none
    private void solarSystemLoop() 
    {
        while(this.continueThread == true)
        {
            ArrayList<Planet> planets = this.solarSystem.getPlanets();
            Star star = this.solarSystem.getStar();
            if(true)
            {
                Dimension[] dimensions = star.getCoordinate().getDimensions();
                double coordX = dimensions[0].getValue();
                double coordY = dimensions[1].getValue();
                System.out.println("star" + " x " + coordX + " y " + coordY);
            }
            for(int x = 0;x < planets.size();x++)
            {
                Dimension[] dimensions = planets.get(x).getCoordinate().getDimensions();
                double coordX = dimensions[0].getValue();
                double coordY = dimensions[1].getValue();
                System.out.println("planet" + x + " x " + coordX + " y " + coordY + " distance " + Geometry.getDistance(planets.get(x).getCoordinate(), star.getCoordinate()));
            }
            this.solarSystem.actGravity();
            this.solarSystem.actMotion();
            this.solarSystem.handleCollisions();
            try
            {
                TimeUnit.MILLISECONDS.sleep(32);
            }
            catch(InterruptedException e)
            {
            
            }
        }
    }
    
    // name: closeThread
    // description: use to notify the thread to stop what its doing.
    // variables: none
    // return: none
    public void closeThread()
    {
        this.continueThread = false;
    }
}
