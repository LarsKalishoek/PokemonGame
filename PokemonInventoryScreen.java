import greenfoot.*;
import java.util.Map;

public class PokemonInventoryScreen extends World {
    private World previousWorld;

    public PokemonInventoryScreen(World previousWorld) {
        super(600, 400, 1);
        this.previousWorld = previousWorld;

        // Add a simple background
        GreenfootImage bg = new GreenfootImage(600, 400);
        bg.setColor(new Color(255, 255, 255));
        bg.fill();
        setBackground(bg);

        int y = 50;
    for (Pokemon p : PokemonParty.getPokemons().values()) {
        String text = p.getName() + " | HP: " + p.getHp() + " | ATK: " + p.getAttack() + " | DEF: " + p.getDefense();
        Label label = new Label(text, 16);
        addObject(label, getWidth()/2, y);
        y += 30;

    for (String move : p.getMoves()) {
        Label moveLabel = new Label(" - " + move, 16);
        addObject(moveLabel, getWidth()/2, y);
        y += 20;
    }

    y += 10; 
}


        Label backLabel = new Label("Press ESC to return", 18);
        addObject(backLabel, getWidth()/2, getHeight() - 30);
    }

    public void act() {
        if (Greenfoot.isKeyDown("escape")) {
            Greenfoot.setWorld(previousWorld);
        }
    }
}
