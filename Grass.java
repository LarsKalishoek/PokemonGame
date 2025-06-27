import greenfoot.*;

public class Grass extends Actor {
    private static final double SCALE = 0.60;

    public Grass() {
        int size = (int)(16 * SCALE);
        GreenfootImage img = new GreenfootImage(size, size);
        img.setColor(Color.RED); // tijdelijk zichtbaar
        img.fill();
        setImage(img);
    }
}
