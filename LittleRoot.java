import greenfoot.*;

public class LittleRoot extends GameWorld {
    private Boy boy;

    public LittleRoot(int spawnX, int spawnY) {
        super(600, 400, 1, new GreenfootImage("LittleRoot.png"), 906, 786);

        boy = new Boy();
        boy.scaleAllImages(0.75);
        addObject(boy, spawnX, spawnY);

        addObject(new Door(BoyDownstairs.class, "up", 471, 312), 311, 297);
        addObject(new Door(Lab.class, "up", 320, 540), 375, 540);
        addObject(new Door(Lab.class, "up", 320, 540, true), 482, 15);

        placeWalls();
    }

    public void act() {
        super.act(); // keep menu toggle working
        centerCameraOn(boy);
    }

    private void centerCameraOn(Actor actor) {
        int dx = actor.getX() - getWidth() / 2;
        int dy = actor.getY() - getHeight() / 2;
        scroll(dx, dy);
    }

    private void placeWalls() {
        int s = 32; // tile size shortcut
    
        // === Top Line ===
        for (int x = 128; x <= 256; x += s) addObject(new Wall(), x, 96);
        for (int x = 576; x <= 784; x += s) addObject(new Wall(), x, 96);
    
        // === Top Inner Corners ===
        addObject(new Wall(), 128, 128);
        addObject(new Wall(), 784, 128);
    
        // === Left Upper Vertical Line ===
        for (int y = 128; y <= 256; y += s) addObject(new Wall(), 128, y);
    
        // === Right Upper Vertical Line ===
        for (int y = 128; y <= 256; y += s) addObject(new Wall(), 784, y);
    
        // === Inward Corner to Midline Left ===
        addObject(new Wall(), 160, 256);
        for (int y = 288; y <= 384; y += s) addObject(new Wall(), 160, y);
        for (int x = 192; x <= 256; x += s) addObject(new Wall(), x, 384);
    
        // === Inward Corner to Midline Right ===
        addObject(new Wall(), 752, 256);
        for (int y = 288; y <= 384; y += s) addObject(new Wall(), 752, y);
        for (int x = 656; x <= 720; x += s) addObject(new Wall(), x, 384);
    
        // === Bottom Corners Around Lab ===
        addObject(new Wall(), 128, 416);
        addObject(new Wall(), 160, 416);
        for (int y = 448; y <= 672; y += s) addObject(new Wall(), 128, y);
        for (int x = 160; x <= 256; x += s) addObject(new Wall(), x, 672);
    
        addObject(new Wall(), 784, 416);
        addObject(new Wall(), 752, 416);
        for (int y = 448; y <= 672; y += s) addObject(new Wall(), 784, y);
        for (int x = 656; x <= 720; x += s) addObject(new Wall(), x, 672);
    
        // === Bottom Line ===
        for (int x = 288; x <= 624; x += s) addObject(new Wall(), x, 704);
        addObject(new Wall(), 288, 672);
        addObject(new Wall(), 624, 672);
    }

    private void addWallBox(int startX, int startY, int w, int h, int tileSize, boolean skipMiddleBottom) {
        for (int i = 0; i < w; i++) {
            for (int j = 0; j < h; j++) {
                boolean isMiddleBottom = (skipMiddleBottom && i == w / 2 && j == h - 1);
                if (isMiddleBottom) continue;

                int x = startX + i * tileSize;
                int y = startY + j * tileSize;
                addObject(new Wall(), x, y);
            }
        }
    }
}
