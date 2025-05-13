import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class BoyDownstairs here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class BoyDownstairs extends GameWorld
{

    /**
     * Constructor for objects of class BoyDownstairs.
     * 
     */
    public BoyDownstairs(int spawnX, int spawnY)
    {    
        // Create a new world with 600x400 cells with a cell size of 1x1 pixels.
        super(600, 400, 1, new GreenfootImage("boyDownstairs.png"),191, 160 ); 
        GreenfootImage bg = new GreenfootImage("boyDownstairs.png");
        bg.scale(getWidth(), getHeight()); 
        setBackground(bg);
        addObject(new Boy(), spawnX, spawnY);
        addObject(new Door(BoyBedroom.class,"up", 480, 100), 450, 115);
        addObject(new Door(LittleRoot.class, "down", 315, 316), 471, 351);
    }
}
