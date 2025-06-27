import greenfoot.*;

public class BattleButton extends Actor {
    private String label;

    public BattleButton(String label) {
        this.label = label;
        updateImage();
    }

    private void updateImage() {
        GreenfootImage img = new GreenfootImage(90, 30);
        img.setColor(Color.LIGHT_GRAY);
        img.fillRect(0, 0, 90, 30);
        img.setColor(Color.BLACK);
        img.drawRect(0, 0, 90 - 1, 30 - 1);
        img.drawString(label, 10, 20);
        setImage(img);
    }

    public void act() {
        if (Greenfoot.mouseClicked(this)) {
            if (label.equals("Run")) {
                int x = Boy.DataPlayer.getLastX();
                int y = Boy.DataPlayer.getLastY();
                // tijdelijke fix: kleine correctie naar beneden
                Greenfoot.setWorld(new Route101(x, y + 100));
            } else {
                Greenfoot.playSound("select.wav"); // optioneel
                // andere acties voor Fight, Bag, etc.
            }
        }
    }
}
