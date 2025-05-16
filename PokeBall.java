import greenfoot.*;
import java.util.HashMap;

public class PokeBall extends Actor {
    private final String uniqueId;
    private final String itemName;
    private final int quantity;

    public PokeBall(String id, String itemName, int quantity) {
        this.uniqueId = id;
        this.itemName = itemName;
        this.quantity = quantity;
    }

    protected void addedToWorld(World world) {
        if (CollectedItems.isCollected(uniqueId)) {
            world.removeObject(this);
        }
    }

    public void act() {
        if (isTouching(Boy.class) && Greenfoot.isKeyDown("e")) {
            collectItem();
        }
    }

    public void collectItem() {
        CollectedItems.collect(uniqueId);
        Inventory.addItem(itemName, quantity); // Add the quantity to inventory
        getWorld().removeObject(this);
    }
}

