import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class boyHouse here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class BoyBedroom extends World
{

    /**
     * Constructor for objects of class boyHouse.
     * 
     */
    public BoyBedroom()
    {    
        // Create a new world with 600x400 cells with a cell size of 1x1 pixels.
        super(600, 400, 1); 
        
        GreenfootImage bg = new GreenfootImage("boyHouse.png");
        bg.scale(getWidth(), getHeight()); 
        setBackground(bg);
        addObject(new Boy(), getWidth()/2, getHeight()/2);
        addObject(new Door(), 431, 75);
        int tileSize = 32;
        int wallY = 75;
        //wall left of door
        for (int x = 0; x < 430; x += 32) {
            addObject(new Wall(), x + 16, wallY);
        }
        //wall right of door
        for (int x = 520; x < getWidth(); x += 32) {
            addObject(new Wall(), x + 16, wallY);
        }
        //walls left and right
        for (int y=0; y <getHeight(); y+= tileSize){
            addObject(new Wall(),tileSize/2, y + tileSize/2);
            addObject(new Wall(), getWidth()- tileSize/2, y + tileSize/2);
        }
        for (int x = 0; x < getWidth(); x += tileSize) {
            addObject(new Wall(), x + tileSize / 2, getHeight() - tileSize / 2);
        }
    }
}
