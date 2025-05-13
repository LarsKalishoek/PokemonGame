import greenfoot.*;

public class SideMenu extends Actor {
    private GreenfootImage background;
    private int scrollOffset = 0;
    private final int MENU_ITEM_HEIGHT = 30;
    private String[] menuItems = { "Pokémon", "Inventory", "Settings" }; // Menu options
    private int selectedIndex = 1; // "Inventory" is selected by default
    private final int maxScrollOffset;

    public SideMenu() {
        int width = 100;
        int height = MENU_ITEM_HEIGHT * menuItems.length;

        background = new GreenfootImage(width, height);
        background.setColor(new Color(0, 0, 0, 180)); // semi-transparent black
        background.fill();

        maxScrollOffset = Math.max(0, MENU_ITEM_HEIGHT * menuItems.length - height); // Prevent overscrolling
        setImage(background);
        updateMenu();
    }

    public void act() {
        handleScrolling();
        handleSelection();
    }

    private void handleScrolling() {
        if (Greenfoot.isKeyDown("DOWN") && scrollOffset < maxScrollOffset) {
            scrollOffset += MENU_ITEM_HEIGHT;
            updateMenu();
        }
        if (Greenfoot.isKeyDown("UP") && scrollOffset > 0) {
            scrollOffset -= MENU_ITEM_HEIGHT;
            updateMenu();
        }
    }

    private void handleSelection() {
        if (Greenfoot.isKeyDown("ENTER")) {
            if (selectedIndex == 1) { // "Inventory" option
                openInventory();
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
                background.setColor(Color.WHITE);
                if (i == selectedIndex) {
                    background.setColor(Color.YELLOW); // Highlight selected item
                }
                background.fillRect(0, yPosition, 100, MENU_ITEM_HEIGHT);
                background.setColor(Color.BLACK);
                background.drawString(menuItems[i], 10, yPosition + 20);
            }
        }
    }

    private void openInventory() {
        // Pass the current world (this) as the previousWorld argument
        //Greenfoot.setWorld(new InventoryScreen(Greenfoot.getWorld()));
    }
}
