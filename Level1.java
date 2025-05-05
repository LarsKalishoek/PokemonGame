import greenfoot.*;

public class Level1 extends World {
    private int selectedOption = 0; // 0 = boy, 1 = girl
    private String[] opties = {"Boy", "Girl"};
    private boolean keyPressed = false;

    public Level1() {
        super(600, 400, 1);
        updateText();
    }

    public void act() {
        if (!keyPressed) {
            if (Greenfoot.isKeyDown("up") || Greenfoot.isKeyDown("down")) {
                selectedOption = 1 - selectedOption;
                updateText();
                keyPressed = true;
            } else if (Greenfoot.isKeyDown("space")) {
                if (selectedOption == 0) {
                    Greenfoot.setWorld(new boyBedroom());
                } else {
                    Greenfoot.setWorld(new girlBedroom());
                }                
                keyPressed = true;
            }
        }

        if (!Greenfoot.isKeyDown("up") && !Greenfoot.isKeyDown("down") && !Greenfoot.isKeyDown("enter")) {
            keyPressed = false;
        }
    }

    private void updateText() {
        showText("Are you a boy or a girl", getWidth()/2, 100);
        showText((selectedOption == 0 ? "> " : "") + "Boy", getWidth()/2, 180);
        showText((selectedOption == 1 ? "> " : "") + "Girl", getWidth()/2, 220);
        showText("Use ↑/↓ to scroll and press SPACE to choose", getWidth()/2, 300);
    }
}
