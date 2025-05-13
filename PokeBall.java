import greenfoot.*;

public class PokeBall extends Actor {
    private final String uniqueId;

    public PokeBall(String id) {
        this.uniqueId = id;
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
        getWorld().removeObject(this);
    }
}
