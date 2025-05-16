import greenfoot.*;
import java.util.HashMap;

public class InventoryScreen extends World {
    private GreenfootImage bgImage;
    private int scrollOffset = 0;
    private static final int ITEM_HEIGHT = 40;
    private World previousWorld;

    public InventoryScreen(World previousWorld) {
        super(600, 400, 1);
        this.previousWorld = previousWorld;
        bgImage = new GreenfootImage("InventoryBgBoy.png");
        setBackground(bgImage);

        // Add items to the inventory screen
        HashMap<String, Integer> items = Inventory.getItems();
        int i = 0;
        for (String itemName : items.keySet()) {
            int quantity = items.get(itemName);
            addObject(new InventoryItem(itemName + " x" + quantity), 100, 50 + (i * ITEM_HEIGHT));
            i++;
        }
    }

    public void act() {
        handleScrolling();
        closeMenuOnEscape(); // Check if ESC key is pressed
    }

    private void handleScrolling() {
        if (Greenfoot.isKeyDown("w") && scrollOffset > 0) {
            scrollOffset -= ITEM_HEIGHT;
            scrollItems();
        } else if (Greenfoot.isKeyDown("s") && scrollOffset < (ITEM_HEIGHT * 10 - getHeight())) {
            scrollOffset += ITEM_HEIGHT;
            scrollItems();
        }
    }

    private void scrollItems() {
        for (int i = 0; i < getObjects(InventoryItem.class).size(); i++) {
            InventoryItem item = (InventoryItem) getObjects(InventoryItem.class).get(i);
            int newY = 50 + (i * ITEM_HEIGHT) - scrollOffset;
            item.setLocation(item.getX(), newY);
        }
    }

    private void closeMenuOnEscape() {
        if (Greenfoot.isKeyDown("escape")) {
            Greenfoot.setWorld(previousWorld); // Switch back to the previous world
        }
    }
}
