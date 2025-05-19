import greenfoot.*;

public class DialogueBox extends Actor {
    private GreenfootImage boxImage;
    private Font font = new Font("Arial", true, false, 16);

    public DialogueBox(String text) {
        boxImage = new GreenfootImage(400, 100);
        boxImage.setColor(Color.WHITE);
        boxImage.fillRect(0, 0, 400, 100);
        boxImage.setColor(Color.BLACK);
        boxImage.drawRect(0, 0, 400, 100);
        boxImage.setFont(font);
        boxImage.drawString(text, 10, 30);
        setImage(boxImage);
    }

    public void updateText(String text) {
        boxImage.clear();
        boxImage.setColor(Color.WHITE);
        boxImage.fillRect(0, 0, 400, 100);
        boxImage.setColor(Color.BLACK);
        boxImage.drawRect(0, 0, 400, 100);
        boxImage.setFont(font);
        boxImage.drawString(text, 10, 30);
        setImage(boxImage);
    }
}
