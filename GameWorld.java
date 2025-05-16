import greenfoot.*;

public abstract class GameWorld extends World {
    private SideMenu sideMenu;
    private boolean menuVisible = false;
    private boolean toggleCooldown = false;

    protected Scroller scroller;
    protected GreenfootImage backgroundImage;

    public GameWorld(int viewWidth, int viewHeight, int cellSize, GreenfootImage background, int worldWidth, int worldHeight) {
        super(viewWidth, viewHeight, cellSize, false); // false = unbounded world
        
        if (Greenfoot.isKeyDown("r")) {
            CollectedItems.markAsReset();  // Mark collected items to be reset
            Greenfoot.setWorld(new StartScreen());  // Set the world back to the initial one
        }

        this.backgroundImage = background;
        this.scroller = new Scroller(this, background, worldWidth / cellSize, worldHeight / cellSize);

        // Initially draw the full background at 0,0
        setBackground(background);
    }

    public void act() {
        handleMenuToggle();
    }
    public boolean isMenuOpen() {
        return menuVisible;
    }


    private void handleMenuToggle() {
        if (Greenfoot.isKeyDown("m") && !toggleCooldown) {
            toggleCooldown = true;

            if (!menuVisible) {
                sideMenu = new SideMenu(this);
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

    public void scroll(int dx, int dy) {
        scroller.scroll(dx, dy);
    }

    public int getScrolledX() {
        return scroller.getScrolledX();
    }

    public int getScrolledY() {
        return scroller.getScrolledY();
    }
}
