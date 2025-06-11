import greenfoot.*;

public class LittleRoot extends GameWorld {
    private Boy boy;

    public LittleRoot(int spawnX, int spawnY) {
        super(600, 400, 1, new GreenfootImage("LittleRoot.png"), 906, 786);

        boy = new Boy();
        boy.scaleAllImages(0.75);
        addObject(boy, spawnX, spawnY);

        addObject(new Door(BoyDownstairs.class, "up", 471, 312), 311, 297);
        addObject(new Door(Lab.class, "up", 320,540), 375, 540);
        addObject(new Door(Lab.class, "up", 320,540, true), 482, 15);
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
