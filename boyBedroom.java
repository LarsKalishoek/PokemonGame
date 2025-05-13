import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

public class BoyBedroom extends GameWorld {
    private SideMenu sideMenu;
    private boolean menuVisible = false;
    private boolean toggleCooldown = false;

    public BoyBedroom() {
        this(300, 200); // default spawn
    }

    public BoyBedroom(int spawnX, int spawnY) {
        super(600, 400, 1,new GreenfootImage("boyHouse.png"),160, 146 );

        GreenfootImage bg = new GreenfootImage("boyHouse.png");
        bg.scale(getWidth(), getHeight());
        setBackground(bg);
        
        PokeBall pokeball = new PokeBall("pokeball_1");
        pokeball.getImage().scale(30,30);
        addObject(pokeball, 190,110);
        
        addObject(new Boy(), spawnX, spawnY);
        addObject(new Door(BoyDownstairs.class, "up", 444, 130), 480, 75);

        int tileSize = 32;
        int wallY = 75;

        for (int x = 0; x < 430; x += 32) {
            addObject(new Wall(), x + 16, wallY);
        }
        for (int x = 520; x < getWidth(); x += 32) {
            addObject(new Wall(), x + 16, wallY);
        }
        for (int x = 0; x < getWidth(); x += tileSize) {
            addObject(new Wall(), x + tileSize / 2, getHeight() - tileSize / 2);
        }
        for (int y = 0; y < getHeight(); y += tileSize) {
            addObject(new Wall(), tileSize / 2, y + tileSize / 2);
            addObject(new Wall(), getWidth() - tileSize / 2, y + tileSize / 2);
        }
    }

    public void act() {
        handleMenuToggle();
    }

    private void handleMenuToggle() {
        if (Greenfoot.isKeyDown("m") && !toggleCooldown) {
            toggleCooldown = true;

            if (!menuVisible) {
                sideMenu = new SideMenu();
                addObject(sideMenu, getWidth() - sideMenu.getImage().getWidth() / 2, getHeight() / 2);

                menuVisible = true;
            } else {
                removeObject(sideMenu);
                menuVisible = false;
            }
        }

        if (!Greenfoot.isKeyDown("m")) {
            toggleCooldown = false;
        }
    }
}
