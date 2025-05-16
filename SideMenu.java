import greenfoot.*;

public class SideMenu extends Actor {
    private GreenfootImage background;
    private int scrollOffset = 0;
    private final int MENU_ITEM_HEIGHT = 30;
    private String[] menuItems = { "Pokémon", "Inventory", "Settings" }; // Menu options
    private int selectedIndex = 1; // "Inventory" is selected by default
    private final int maxScrollOffset;
    private World parentWorld; // Reference to the world that this menu belongs to
    private boolean scrollCooldown = false;
    
    public SideMenu(World world) {
        this.parentWorld = world;

        int width = 100;
        int height = MENU_ITEM_HEIGHT * menuItems.length;

        background = new GreenfootImage(width, height);
        background.setColor(new Color(0, 0, 0, 180)); // semi-transparent black
        background.fill();

        maxScrollOffset = Math.max(0, MENU_ITEM_HEIGHT * menuItems.length - height);
        setImage(background);
        updateMenu();
    }

    public void act() {
        handleScrolling();
        handleSelection();
    }

    private void handleScrolling() {
    if (!scrollCooldown) {
        if (Greenfoot.isKeyDown("DOWN")) {
            selectedIndex = (selectedIndex + 1) % menuItems.length;
            scrollCooldown = true;
            updateMenu();
        } else if (Greenfoot.isKeyDown("UP")) {
            selectedIndex = (selectedIndex - 1 + menuItems.length) % menuItems.length;
            scrollCooldown = true;
            updateMenu();
        }
    }

    if (!Greenfoot.isKeyDown("UP") && !Greenfoot.isKeyDown("DOWN")) {
        scrollCooldown = false;
    }
}


    private void handleSelection() {
        if (Greenfoot.isKeyDown("ENTER")) {
            if (selectedIndex == 1) { // "Inventory" option
                openInventory();
                Greenfoot.delay(10); // Small delay to prevent immediate input in the new screen
            }
        }
    }

    private void updateMenu() {
        // Clear the background
        background.setColor(new Color(0, 0, 0, 180));
        background.fill();

        // Draw the menu items
        for (int i = 0; i < menuItems.length; i++) {
            int yPosition = i * MENU_ITEM_HEIGHT - scrollOffset;
            if (yPosition >= 0 && yPosition < getImage().getHeight()) {
                if (i == selectedIndex) {
                    background.setColor(Color.GRAY); // Highlight selected item
                    background.fillRect(0, yPosition, 100, MENU_ITEM_HEIGHT);
                    background.setColor(Color.BLACK);
                } else {
                    background.setColor(Color.WHITE);
                }
                background.drawString(menuItems[i], 10, yPosition + 20);
            }
        }
    }

    private void openInventory() {
        Greenfoot.setWorld(new InventoryScreen(parentWorld));
    }
}
