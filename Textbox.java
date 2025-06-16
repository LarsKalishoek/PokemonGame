import greenfoot.*;

public class Textbox extends Actor {
    private String message;
    private GreenfootImage background;
    private boolean waitingForKey = true;

    public Textbox(String message) {
        this.message = message;
        background = new GreenfootImage(480, 110); // Match your screenshot size
        drawMessage();
    }

    private void drawMessage() {
        background.setColor(new Color(255, 255, 255));
        background.fill();
        background.setColor(new Color(0, 0, 0));
        background.drawRect(0, 0, background.getWidth() - 1, background.getHeight() - 1);
    
        greenfoot.Font font = new greenfoot.Font(18); 
        background.setFont(font);
        background.setColor(Color.BLACK);
    
        int lineHeight = 20;
        String[] lines = message.split("\n");
        for (int i = 0; i < lines.length; i++) {
            background.drawString(lines[i], 10, 25 + i * lineHeight);
        }
    
        setImage(background);
    }


    public void act() {
        if (waitingForKey && Greenfoot.isKeyDown("space")) {
            World world = getWorld();
            world.removeObject(this);
            waitingForKey = false;

            if (world instanceof GameWorld) {
                ((GameWorld) world).setTextboxActive(false); // Allow player to move again
            }
        }
    }
}
