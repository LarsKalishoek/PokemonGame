import greenfoot.*;

public class Door extends Actor {
    private boolean transitioning = false;

    public Door() {
        GreenfootImage image = new GreenfootImage(32, 32);
        image.setColor(new Color(0, 0, 0, 0));  // Volledig transparant
        image.fill();
        setImage(image);
    }

    public void act() {
        // Voorkom meerdere triggers
        if (!transitioning && isTouching(Boy.class)) {
            transitioning = true;
            startLevelTransition();
        }
    }

    private void startLevelTransition() {
        // Fade-out animatie (optioneel, basic manier)
        World world = getWorld();
        GreenfootImage fade = new GreenfootImage(world.getWidth(), world.getHeight());
        fade.setColor(Color.BLACK);
        fade.fill();
        world.getBackground().drawImage(fade, 0, 0);

        // Korte pauze voor effect (werkt alleen als je geen andere animatie gebruikt)
        Greenfoot.delay(30);

        // Naar het volgende level gaan (vervang met je eigen klasse)
        Greenfoot.setWorld(new BoyDownstairs());
    }
}
