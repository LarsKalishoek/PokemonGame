import greenfoot.*;

public class InventoryScreen extends World {
    private GreenfootImage bgImage;
    private int scrollOffset = 0;
    private static final int ITEM_HEIGHT = 40;
    private World previousWorld; // To store the previous world

    public InventoryScreen(World previousWorld) {
        super(600, 400, 1); // Set the size of the inventory screen
        this.previousWorld = previousWorld; // Store the previous world
        bgImage = new GreenfootImage("InventoryBgBoy.png"); // Set a background image
        setBackground(bgImage);

        // Add items to the inventory screen
        for (int i = 0; i < 10; i++) { // Change 10 to the number of items
            addObject(new InventoryItem("Item " + (i + 1)), 100, 50 + (i * ITEM_HEIGHT));
        }
    }

    public void act() {
        handleScrolling();
        closeMenuOnEscape(); // Check if ESC key is pressed
    }

    private void handleScrolling() {
        if (Greenfoot.isKeyDown("UP") && scrollOffset > 0) {
            scrollOffset -= ITEM_HEIGHT;
            scrollItems();
        } else if (Greenfoot.isKeyDown("DOWN") && scrollOffset < (ITEM_HEIGHT * 10 - getHeight())) {
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
