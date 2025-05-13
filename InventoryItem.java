import greenfoot.*;

public class InventoryItem extends Actor {
    private String itemName;

    public InventoryItem(String itemName) {
        this.itemName = itemName;
        updateImage();
    }

    private void updateImage() {
        GreenfootImage image = new GreenfootImage(200, 40);
        image.setColor(Color.WHITE);
        image.fillRect(0, 0, image.getWidth(), image.getHeight());
        image.setColor(Color.BLACK);
        image.drawString(itemName, 10, 20);
        setImage(image);
    }
}
