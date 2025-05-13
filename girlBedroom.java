import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class GirlBedroom here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class GirlBedroom extends World
{

    /**
     * Constructor for objects of class GirlBedroom.
     * 
     */
    public GirlBedroom()
    {    
        // Create a new world with 600x400 cells with a cell size of 1x1 pixels.
        super(600, 400, 1); 
        
        GreenfootImage bg = new GreenfootImage("girlBedroom.png");
        bg.scale(getWidth(), getHeight()); 
        setBackground(bg);
    }
}
