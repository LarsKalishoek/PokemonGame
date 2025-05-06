import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * A Person that can walk with animation using WASD keys.
 */
public class Boy extends Actor
{
    private GreenfootImage[] walkLeftImages;
    private GreenfootImage[] walkRightImages;
    private int imageIndex = 0;
    private int animationCounter = 0;
    private String lastDirection = "right";
    private GreenfootImage idleLeft;
    private GreenfootImage idleRight;
    
    public Boy() {
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

        // Bepaal de nieuwe locatie op basis van de toetsen
        int newX = getX();
        int newY = getY();

        if (Greenfoot.isKeyDown("w")) {
            newY -= 3;
            isMoving = true;
        }
        if (Greenfoot.isKeyDown("a")) {
            newX -= 3;
            lastDirection = "left";
            isMoving = true;
        }
        if (Greenfoot.isKeyDown("s")) {
            newY += 3;
            isMoving = true;
        }
        if (Greenfoot.isKeyDown("d")) {
            newX += 3;
            lastDirection = "right";
            isMoving = true;
        }

        // Controleer of de nieuwe locatie geen muur raakt
        if (!isTouchingWall(newX, newY)) {
            setLocation(newX, newY);
        }

        // Animeer het bewegen of toon de idle-afbeelding
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
    
        if (animationCounter >= 5) { // Pas 5 aan om de snelheid van de animatie te regelen (lager = sneller)
            animationCounter = 0; // Reset de teller na elke cyclus
    
            imageIndex = (imageIndex + 1) % walkLeftImages.length;
    
            if (lastDirection.equals("right")) {
                setImage(walkRightImages[imageIndex]);
            } else {
                setImage(walkLeftImages[imageIndex]);
            }
        }
    }

    // Controleer of er een muur is op de nieuwe locatie
    private boolean isTouchingWall(int x, int y) {
        // Stel hier in welke actor een muur vertegenwoordigt (bijvoorbeeld "Wall")
        Actor wall = getOneObjectAtOffset(x - getX(), y - getY(), Wall.class);
        return wall != null;
    }
}
