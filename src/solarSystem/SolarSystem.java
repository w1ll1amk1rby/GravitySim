/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package solarSystem;

import mathmatics.LawsOfPhysics;
import astronomicalObjects.*;
import hitDetector.HitDetector;
import java.util.ArrayList;


//@author William Kirby
// solarsystem structure storing different astronomical objects
public class SolarSystem
{
    
    private Star star;
    private ArrayList<Planet> planets;
    private ArrayList<Asteroid> asteroids;
    private LawsOfPhysics lawsOfPhysics;
    
    // Constructor
    public SolarSystem(Star star,ArrayList<Planet> planets,ArrayList<Asteroid> asteroids) 
    {
        this.star = star;
        this.planets = planets;
        this.asteroids = asteroids;
        this.lawsOfPhysics = new LawsOfPhysics(1);
    }
    
    // get and set star
    public Star getStar()
    {
        return this.star;
    }
    public void setStar(Star star)
    {
        this.star = star;
    }
    
    // get and set planets
    public ArrayList<Planet> getPlanets()
    {
        return this.planets;
    }
    public void setPlanets(ArrayList<Planet> planets)
    {
        this.planets = planets;
    }
    
    // get and set asteroids
    public ArrayList<Asteroid> getAsteroids()
    {
        return this.asteroids;
    }
    public void setAsteroids(ArrayList<Asteroid> asteroids)
    {
        this.asteroids = asteroids;
    }
    
    // name: actGravity
    // description: act gravity within the solar system
    // variables: none
    // return: none
    public void actGravity()
    {
        // Act on planets (sun and planets)
        for(int x = 0;x < this.planets.size() - 1; x++)
        {
            for(int i =  x + 1; i < this.planets.size() ; i++)
            {
                this.lawsOfPhysics.actGravityBetween(this.planets.get(i), this.planets.get(x));
            }
        }
        for(int x = 0; x < this.planets.size(); x++)
        {
            this.lawsOfPhysics.actGravityOnObjectFromAnotherObject(this.planets.get(x), this.star);
        }
        
        // Act on asteroids (sun and planets)
        for(int x = 0;x < this.planets.size();x++)
        {
            for(int i = 0;i < this.asteroids.size();i++)
            {
                this.lawsOfPhysics.actGravityOnObjectFromAnotherObject(this.asteroids.get(i), this.planets.get(x));
            }
        }
        for(int x = 0;x < this.asteroids.size();x++)
        {
            this.lawsOfPhysics.actGravityOnObjectFromAnotherObject(this.asteroids.get(x),this.star);
        }
    }

    // name: actMotion
    // description: enact motion on objects in the solar system
    // variables: none
    // return: none
    public void actMotion()
    {
        // planets
        for(int x = 0 ; x < this.planets.size() ; x++)
        {
            this.planets.get(x).enactMotion();
        }
        // asteroids
        for(int x = 0 ; x < this.asteroids.size() ; x++)
        {
            this.asteroids.get(x).enactMotion();
        }
    }
    
    // name: handleCollisions
    // description: detects and enacts collisions
    // variables: none
    // return: none
    public void handleCollisions()
    {
        // check if any planets hit the sun
        for(int x = 0;x < this.planets.size();x++)
        {
           Planet planet = this.planets.get(x);
           if(HitDetector.overLapping(this.star.getHitBox(), planet.getHitBox()))
           {
               this.star.addToMass(planet.getMass());
               this.planets.remove(x);
               x--;
               
           }
        }
        // check if any asteroids hit any planet
        for(int x = 0;x < this.asteroids.size();x++)
        {
            Asteroid asteroid = this.asteroids.get(x);
            if(HitDetector.overLapping(this.star.getHitBox(), asteroid.getHitBox()))
            {
                this.star.addToMass(asteroid.getMass());
                this.planets.remove(x);
                x--;
            }
        }
        
        // check if planets collide
        for(int x = 0;x < this.planets.size() - 1;x++)
        {
            for(int i = x + 1;i < this.planets.size();i++)
            {
                Planet planetOne = this.planets.get(x);
                Planet planetTwo = this.planets.get(i);
                if(HitDetector.overLapping(planetOne.getHitBox(), planetTwo.getHitBox()))
                {
                    if(planetOne.getMass() > planetTwo.getMass())
                    {
                        planetOne.addMomentumAndMass(planetTwo);
                        this.planets.remove(planetTwo);
                        i--;
                        
                    }
                    else
                    {
                        planetTwo.addMomentumAndMass(planetOne);
                        this.planets.remove(planetOne);
                        x--;
                        break;
                    }
                }
            }
        }
        
        // check if any asteroids have collided with planets
        for(int x = 0;x < this.planets.size();x++)
        {
            for(int i = 0;i < this.asteroids.size(); i++)
            {
                Planet planet = this.planets.get(x);
                Asteroid asteroid = this.asteroids.get(i);
                if(HitDetector.overLapping(planet.getHitBox(), asteroid.getHitBox()))
                {
                    planet.addMomentumAndMass(asteroid);
                    this.asteroids.remove(i);
                    i--;
                }
            }
        }
        
        
        
    }
}
