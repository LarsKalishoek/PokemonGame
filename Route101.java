import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Route101 - bevat het gras en random encounters
 */
public class Route101 extends GameWorld {
    private static final double SCALE = 0.60;
    private Boy boy;
    private boolean cameraInitialized = false;

    public Route101(int spawnX, int spawnY) {
        super(600, 400, 1,
              getScaledBackground("Routes/Route101.png", SCALE),
              (int)(1200 * SCALE),
              (int)(1197 * SCALE)
        );

        boy = new Boy();
        boy.scaleAllImages(0.85);
        addObject(boy, spawnX, spawnY);
        addObject(new Door(LittleRoot.class, "down", 482, 15), 404, 697);

        // 🌿 Gras toevoegen via helperfunctie
        placeGrassBlock(65, 595, 4, 4);   // Linksonder
        placeGrassBlock(75, 85, 3, 3);    // Linksboven
        placeGrassBlock(265, 80, 2, 2);   // Middenboven
        placeGrassBlock(470, 235, 5, 5);  // Rechtsmidden
        placeGrassBlock(275, 480, 3, 2);  // Middenonder
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

    public static GreenfootImage getScaledBackground(String path, double scale) {
        GreenfootImage bg = new GreenfootImage(path);
        int newWidth = (int)(bg.getWidth() * scale);
        int newHeight = (int)(bg.getHeight() * scale);
        bg.scale(newWidth, newHeight);
        return bg;
    }

    /**
     * Helperfunctie om een blok gras toe te voegen.
     * @param startX linkerbovenhoek X (geschaald)
     * @param startY linkerbovenhoek Y (geschaald)
     * @param cols aantal kolommen (horizontaal)
     * @param rows aantal rijen (verticaal)
     */
    private void placeGrassBlock(int startX, int startY, int cols, int rows) {
        double tileSize = 16 * SCALE;
        for (int row = 0; row < rows; row++) {
            for (int col = 0; col < cols; col++) {
                int x = (int)(startX + col * tileSize);
                int y = (int)(startY + row * tileSize);
                addObject(new Grass(), x, y);
            }
        }
    }
}
