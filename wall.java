import greenfoot.*;

public class Wall extends Actor {
    public Wall() {
        GreenfootImage image = new GreenfootImage(32, 32);
        image.setColor(new Color(0, 0, 0, 0));
        image.fill();
        setImage(image);
    }

    public void act() {
        // Static wall; no action required
    }
}
