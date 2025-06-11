import greenfoot.*;

public class BoyDownstairs extends GameWorld
{
    public BoyDownstairs(int spawnX, int spawnY)
    {    
        super(600, 400, 1, new GreenfootImage("boyDownstairs.png"), 191, 160); 

        GreenfootImage bg = new GreenfootImage("boyDownstairs.png");
        bg.scale(getWidth(), getHeight()); 
        setBackground(bg);

        addObject(new Boy(), spawnX, spawnY);
        addObject(new Door(BoyBedroom.class,"up", 480, 100), 450, 115);
        addObject(new Door(LittleRoot.class, "down", 315, 316), 471, 351);

        int tileSize = 32;

        // Top wall (all the white top wall, skip hole where stairs are)
        for (int x = 0; x < getWidth(); x += tileSize) {
            if (x < 400 || x > 500) { 
                addObject(new Wall(), x + tileSize / 2, 110);
            }
        }

        // Right wall (from top of stairs downward)
        for (int y = 100; y < getHeight(); y += tileSize) {
            addObject(new Wall(), getWidth() - tileSize / 2, y + tileSize / 2);
        }

        // Left wall 
        for (int y = 0; y < getHeight(); y += tileSize) {
            addObject(new Wall(), tileSize / 2, y + tileSize / 2);
        }

        // Bottom wall
        for (int x = 0; x < getWidth(); x += tileSize) {
            if (x < 440 || x > 500) {
                addObject(new Wall(), x + tileSize / 2, getHeight() - tileSize / 2);
            }
        }
    }
}
