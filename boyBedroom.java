import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class boyHouse here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class boyBedroom extends World
{

    /**
     * Constructor for objects of class boyHouse.
     * 
     */
    public boyBedroom()
    {    
        // Create a new world with 600x400 cells with a cell size of 1x1 pixels.
        super(600, 400, 1); 
        
        GreenfootImage bg = new GreenfootImage("boyHouse.png");
        bg.scale(getWidth(), getHeight()); // schaal tot wereldgrootte
        setBackground(bg);
        addObject(new Person(), getWidth()/2, getHeight()/2);
    }
}
