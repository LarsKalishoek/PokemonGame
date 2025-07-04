import greenfoot.*;

public class Door extends Actor {
    private boolean transitioning = false;
    private int spawnX, spawnY;
    private Class<? extends World> targetWorld;
    private String requiredDirection;
    private boolean requireStarter; // new flag

    public Door(Class<? extends World> targetWorld, String requiredDirection, int spawnX, int spawnY) {
        this(targetWorld, requiredDirection, spawnX, spawnY, false); // default: no starter required
    }

    public Door(Class<? extends World> targetWorld, String requiredDirection, int spawnX, int spawnY, boolean requireStarter) {
        this.targetWorld = targetWorld;
        this.requiredDirection = requiredDirection;
        this.spawnX = spawnX;
        this.spawnY = spawnY;
        this.requireStarter = requireStarter;

        GreenfootImage image = new GreenfootImage(32, 32);
        image.setColor(new Color(0, 0, 0, 0));
        image.fill();
        setImage(image);
    }

    public void act() {
        if (!transitioning && isTouching(Boy.class)) {
            Boy boy = (Boy) getOneIntersectingObject(Boy.class);
            if (boy != null && boy.canUseDoor() && boy.getLastDirection().equals(requiredDirection) && isDirectionKeyPressed(boy)) {
                // Require starter Pokémon before entering
                if (requireStarter && !PokemonParty.hasStarter()) {
                    World world = getWorld();
                    if (world instanceof GameWorld) {
                        ((GameWorld) world).setTextboxActive(true);
                    }
                    world.addObject(new Textbox("You need your first Pokémon!"), world.getWidth() / 2, world.getHeight() - 55);
                    return;
                }

                transitioning = true;
                boy.setTeleportCooldown(20);
                startLevelTransition();
            }
        }
    }
    
    private boolean isDirectionKeyPressed(Boy boy) {
        switch (requiredDirection) {
            case "up": return boy.isKeyDown("w");
            case "down": return boy.isKeyDown("s");
            case "left": return boy.isKeyDown("a");
            case "right": return boy.isKeyDown("d");
        }
        return false;
    }

    private void startLevelTransition() {
        // Remove all non-Boy objects before transitioning
        World currentWorld = getWorld();
        for (Object obj : currentWorld.getObjects(Actor.class)) {
            if (!(obj instanceof Boy)) {
                currentWorld.removeObject((Actor) obj);  // Remove all objects except Boy
            }
        }

        GreenfootImage fade = new GreenfootImage(currentWorld.getWidth(), currentWorld.getHeight());
        fade.setColor(Color.BLACK);
        fade.fill();
        currentWorld.getBackground().drawImage(fade, 0, 0);
        Greenfoot.delay(30);
        
        try {
            World newWorld = targetWorld.getDeclaredConstructor(int.class, int.class).newInstance(spawnX, spawnY);
            Greenfoot.setWorld(newWorld);
        } catch (Exception e) {
            System.out.println("Error loading world: " + e.getMessage());
        }
    }
}
