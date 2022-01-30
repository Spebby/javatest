/* AP(r) Computer Science GridWorld Case Study:
 * Copyright(c) 2005-2006 Cay S. Horstmann (http://horstmann.com)
 *
 * This code is free software; you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as published by
 * the Free Software Foundation.
 *
 * This code is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 * 
 * @author Cay Horstmann */

package GridWorld;
import GridWorld.Actors.ActorWorld;
import GridWorld.Actors.*;
import GridWorld.Objects.Rock;

// formerly bugrunner
/* This class runs a world that contains a bug and a rock, added at random
 * locations. Click on empty locations to add additional actors. Click on
 * populated locations to invoke methods on their occupants.
 * To build your own worlds, define your own actors and a runner class. See the
 * BoxBugRunner (in the boxBug folder) for an example. */
public class BugDriver
{
    public static void main(String[] args)
    {
        ActorWorld world = new ActorWorld();
        
        Bug bob = new Bug();
        BoxBug boxxy = new BoxBug();
        SpiralBug spugsy = new SpiralBug();
        JumpBug juggy = new JumpBug();
        //ZBug zuggy = new ZBug();
        world.add(bob);
        world.add(boxxy);
        world.add(spugsy, spugsy.getLocation());
        world.add(juggy);
        //world.add(zuggy);
        
        Rock rocker = new Rock();
        world.add(rocker);
    
        world.show();
    }
}