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
        
        PokeBall pokeball = new PokeBall("pokeball_1", "Potion",1 );
        PokeBall pokeball1 = new PokeBall("pokeball_2", "Pokeball",5 );
        pokeball.getImage().scale(30,30);
        pokeball1.getImage().scale(30,30);
        addObject(pokeball, 190,110);
        addObject(pokeball1, 250,150);
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
}
