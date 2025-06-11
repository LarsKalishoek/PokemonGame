import greenfoot.*;

public abstract class GameWorld extends World {
    private SideMenu sideMenu;
    private boolean menuVisible = false;
    private boolean toggleCooldown = false;
    protected Scroller scroller;
    protected GreenfootImage backgroundImage;
    private Boy boy;
    private boolean textboxActive = false;

    public GameWorld(int viewWidth, int viewHeight, int cellSize, GreenfootImage background, int worldWidth, int worldHeight) {
        super(viewWidth, viewHeight, cellSize, false);
        
        if (Greenfoot.isKeyDown("r")) {
            CollectedItems.markAsReset();
            Greenfoot.setWorld(new StartScreen()); 
        }

        this.backgroundImage = background;
        this.scroller = new Scroller(this, background, worldWidth / cellSize, worldHeight / cellSize);

        setBackground(background);
    }

    public void act() {
        handleMenuToggle();
    }
    
    public boolean isMenuOpen() {
        return menuVisible;
    }

    public Boy getBoy() {
        return boy;
    }
    
    public boolean isTextboxActive() {
        return textboxActive;
    }
    
    public void setTextboxActive(boolean active) {
        this.textboxActive = active;
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
