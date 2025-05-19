import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
import java.util.HashSet;
import java.util.Set;

/**
 * A Person that can walk with animation using WASD keys.
 */
public class Boy extends Actor {
    private GreenfootImage[] walkLeftImages;
    private GreenfootImage[] walkRightImages;
    private int imageIndex = 0;
    private int animationCounter = 0;
    private String lastDirection = "right";
    private GreenfootImage idleLeft;
    private GreenfootImage idleRight;

    private int teleportCooldown = 0;

    private Set<String> inventory; 
    private boolean canMove = true;

    public void setCanMove(boolean canMove) {
        this.canMove = canMove;
    }
    
    public Boy() {
        walkLeftImages = new GreenfootImage[3];
        walkRightImages = new GreenfootImage[3];

        idleLeft = new GreenfootImage("boyWalkingAni/leftIdle.png");
        idleLeft.scale(50, 50);

        idleRight = new GreenfootImage(idleLeft);
        idleRight.mirrorHorizontally();

        for (int i = 0; i < 3; i++) {
            walkLeftImages[i] = new GreenfootImage("boyWalkingAni/walkLeft" + (i + 1) + ".png");
            walkLeftImages[i].scale(50, 50);

            walkRightImages[i] = new GreenfootImage(walkLeftImages[i]);
            walkRightImages[i].mirrorHorizontally();
        }

        setImage(walkRightImages[0]);

        teleportCooldown = 20;

        inventory = new HashSet<>();  // Use a HashSet to avoid duplicates
    }

    public void act() {
        if (!canMove) return;
    
        if (teleportCooldown > 0) {
            teleportCooldown--;
        }
    
        GameWorld gw = (GameWorld) getWorld();
        if (gw.isMenuOpen()) return;
    
        handleMovement();
    }

    public String getLastDirection() {
        return lastDirection;
    }

    public boolean canUseDoor() {
        return teleportCooldown <= 0;
    }

    public void setTeleportCooldown(int frames) {
        teleportCooldown = frames;
    }

    public void scaleAllImages(double factor) {
        int newSize = (int)(50 * factor);

        for (int i = 0; i < walkLeftImages.length; i++) {
            walkLeftImages[i].scale(newSize, newSize);
            walkRightImages[i].scale(newSize, newSize);
        }

        idleLeft.scale(newSize, newSize);
        idleRight.scale(newSize, newSize);

        setImage(lastDirection.equals("right") ? idleRight : idleLeft);
    }

    private void handleMovement() {
        boolean isMoving = false;

        int newX = getX();
        int newY = getY();

        if (Greenfoot.isKeyDown("w")) {
            newY -= 3;
            lastDirection = "up";
            isMoving = true;
        }
        if (Greenfoot.isKeyDown("a")) {
            newX -= 3;
            lastDirection = "left";
            isMoving = true;
        }
        if (Greenfoot.isKeyDown("s")) {
            newY += 3;
            lastDirection = "down";
            isMoving = true;
        }
        if (Greenfoot.isKeyDown("d")) {
            newX += 3;
            lastDirection = "right";
            isMoving = true;
        }

        if (!isTouchingWall(newX, newY)) {
            setLocation(newX, newY);
        }

        if (isMoving) {
            animateWalk();
        } else {
            animationCounter = 0;
            imageIndex = 0;
            if (lastDirection.equals("right")) {
                setImage(idleRight);
            } else {
                setImage(idleLeft);
            }
        }
    }

    private void animateWalk() {
        animationCounter++;

        if (animationCounter >= 5) {
            animationCounter = 0;
            imageIndex = (imageIndex + 1) % walkLeftImages.length;
            if (lastDirection.equals("right")) {
                setImage(walkRightImages[imageIndex]);
            } else {
                setImage(walkLeftImages[imageIndex]);
            }
        }
    }

    private boolean isTouchingWall(int x, int y) {
        Actor wall = getOneObjectAtOffset(x - getX(), y - getY(), Wall.class);
        return wall != null;
    }

    // Inventory logic
    public void addItemToInventory(String itemId) {
        inventory.add(itemId);
        System.out.println(itemId + " has been added to your inventory!");
    }

    public boolean hasCollected(String itemId) {
        return inventory.contains(itemId);
    }
}
