/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hitDetector;

//@author William Kirby

import hitBoxes.HitBox;
import hitBoxes.SphericalHitBox;

public class HitDetector 
{
    public static boolean overLapping(HitBox hitBoxOne, HitBox hitBoxTwo)
    {
        if((hitBoxOne instanceof SphericalHitBox) && (hitBoxTwo instanceof SphericalHitBox))
        {
            SphericalHitBox sphereOne = (SphericalHitBox) hitBoxOne;
            SphericalHitBox sphereTwo = (SphericalHitBox) hitBoxTwo;
            double distance = sphereOne.closestDistanceFromCoordinate(sphereTwo.getCentre());
            return distance <= sphereTwo.getRadius();
        }
        else
        {
            return false;
        }
    }
    
    
}
