package solarSystemCreators;

import astronomicalObjects.Asteroid;
import astronomicalObjects.Planet;
import astronomicalObjects.Star;
import java.util.ArrayList;
import solarSystem.SolarSystem;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */


// @author William Kirby
public class SolarSystemCreator 
{
    
    public static SolarSystem generateSolarSystem(int seed)
    {
        Star star = StarCreator.generateStar(seed);
        ArrayList<Planet> planets = getPlanetList(star,seed);
        ArrayList<Asteroid> asteroids = getAsteroidList();
        return new SolarSystem(star,planets,asteroids);
    }
    
    public static ArrayList<Planet> getPlanetList(Star star,int seed)
    {      
        ArrayList<Planet> planets = new ArrayList<>();
        for(int x = 0;x < 10;x++)
        {
            planets.add(PlanetCreator.generatePlanetOrbitingStar(seed, star, 1));
            seed = (int) (seed * 0.9);
        }
        return planets;
    }
    
    public static ArrayList<Asteroid>  getAsteroidList()
    {
        ArrayList<Asteroid> asteroids = new ArrayList<>();
        return asteroids;
    }
}
