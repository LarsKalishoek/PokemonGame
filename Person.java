import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * A Person that can walk with animation using WASD keys.
 */
public class Person extends Actor
{
    private GreenfootImage[] walkLeftImages;
    private GreenfootImage[] walkRightImages;
    private int imageIndex = 0;
    private int animationCounter = 0;
    private String lastDirection = "right";
    private GreenfootImage idleLeft;
    private GreenfootImage idleRight;
    
    public Person() {
        walkLeftImages = new GreenfootImage[3];
        walkRightImages = new GreenfootImage[3];
        idleLeft = new GreenfootImage("boyWalkingAni/leftIdle.png");
        idleLeft.scale(50,50);
        
        idleRight = new GreenfootImage(idleLeft);
        idleRight.mirrorHorizontally();
        for (int i = 0; i < 3; i++) {
            walkLeftImages[i] = new GreenfootImage("boyWalkingAni/walkLeft" + (i + 1) + ".png");
            walkLeftImages[i].scale(50 ,50);
            
            walkRightImages[i] = new GreenfootImage(walkLeftImages[i]);
            walkRightImages[i].mirrorHorizontally();
        }

        setImage(walkRightImages[0]);
    }

    public void act() {
        handleMovement();
    }

    private void handleMovement() {
        boolean isMoving = false;

        if (Greenfoot.isKeyDown("w")) {
            setLocation(getX(), getY() - 2);
            isMoving = true;
        }
        if (Greenfoot.isKeyDown("a")) {
            setLocation(getX() - 2, getY());
            lastDirection = "left";
            isMoving = true;
        }
        if (Greenfoot.isKeyDown("s")) {
            setLocation(getX(), getY() + 2);
            isMoving = true;
        }
        if (Greenfoot.isKeyDown("d")) {
            setLocation(getX() + 2, getY());
            lastDirection = "right";
            isMoving = true;
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
    
        if (animationCounter >= 5) { // Adjust 5 to control animation speed (lower = faster)
            animationCounter = 0; // Reset the counter every cycle
    
            imageIndex = (imageIndex + 1) % walkLeftImages.length;
    
            if (lastDirection.equals("right")) {
                setImage(walkRightImages[imageIndex]);
            } else {
                setImage(walkLeftImages[imageIndex]);
            }
        }
    }
}
