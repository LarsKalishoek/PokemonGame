import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Route101 here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Route101 extends GameWorld
{
    private static final double SCALE = 0.60;
    private Boy boy;
    /**
     * Constructor for objects of class Route101.
     * 
     */
    public Route101(int spawnX, int spawnY)
    {
        super(600, 400, 1,
              getScaledBackground("Routes/Route101.png", SCALE),
              (int)(1200 * SCALE),
              (int)(1197 * SCALE)
        );
        boy = new Boy();
        boy.scaleAllImages(0.75);
        addObject(boy, spawnX, spawnY);
        addObject(new Door(LittleRoot.class, "down", 482, 15), 404, 697);
    }
    
    public void act() {
        super.act();
        centerCameraOn(boy);
    }
    private void centerCameraOn(Actor actor) {
        int dx = actor.getX() - getWidth() / 2;
        int dy = actor.getY() - getHeight() / 2;
        scroll(dx, dy);
    }
    
    public static GreenfootImage getScaledBackground(String path, double scale) {
        GreenfootImage bg = new GreenfootImage(path);
        int newWidth = (int)(bg.getWidth() * scale);
        int newHeight = (int)(bg.getHeight() * scale);
        bg.scale(newWidth, newHeight);
        return bg;
}

}
