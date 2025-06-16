import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Route101 here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Route101 extends GameWorld
{
    private Boy boy;
    /**
     * Constructor for objects of class Route101.
     * 
     */
    public Route101(int spawnX, int spawnY)
    {
        super(600, 400, 1, new GreenfootImage("LittleRoot.png"), 906, 786);

        boy = new Boy();
        boy.scaleAllImages(0.75);
        addObject(boy, spawnX, spawnY);
    }
}
