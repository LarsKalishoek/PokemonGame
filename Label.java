import greenfoot.*;

public class Label extends Actor {
    public Label(String text, int fontSize) {
        GreenfootImage img = new GreenfootImage(300, 30);
        img.setColor(Color.WHITE);
        img.fill();
        img.setColor(Color.BLACK);
        Font font = new Font("Arial", true, false, fontSize);
        img.setFont(font);
        img.drawString(text, 5, 20);
        setImage(img);
    }
}
