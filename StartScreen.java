import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

public class StartScreen extends World
{
    public StartScreen()
    {    
        super(1280, 720, 1); 
        setBackground(new GreenfootImage("titlescreen.jpg"));
    
        showText("Press enter to start", getWidth()/2, 450);
    }


    public void act() {
        if (Greenfoot.isKeyDown("enter")) {
            Greenfoot.setWorld(new Level1());
        }
    }
}
