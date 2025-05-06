import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class BoyDownstairs here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class BoyDownstairs extends World
{

    /**
     * Constructor for objects of class BoyDownstairs.
     * 
     */
    public BoyDownstairs()
    {    
        // Create a new world with 600x400 cells with a cell size of 1x1 pixels.
        super(600, 400, 1); 
        GreenfootImage bg = new GreenfootImage("boyDownstairs.png");
        bg.scale(getWidth(), getHeight()); 
        setBackground(bg);
        addObject(new Boy(), 444, 128);
    }
}
