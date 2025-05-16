import greenfoot.*;

public class Lab extends GameWorld {
    private Boy boy;

    public Lab(int spawnX, int spawnY) {
        super(600, 400, 1, new GreenfootImage("Lab.png"), 593, 590);

        boy = new Boy();
        boy.scaleAllImages(0.9);
        addObject(boy, spawnX, spawnY);
        addObject(new Door(LittleRoot.class, "down", 375, 560),320,560);
    }

    public void act() {
        super.act();
        centerCameraOn(boy);
    }

    private void centerCameraOn(Actor actor) {
        int dx = actor.getX() - getWidth() / 2;
        int dy = actor.getY() - getHeight() / 2;
        scroll(dx, dy);
    }
}
