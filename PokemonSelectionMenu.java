import greenfoot.*;

public class PokemonSelectionMenu extends Actor {
    private String[] options = { "Treecko", "Torchic", "Mudkip" };
    private int selected = 0;
    private GreenfootImage image;

    public PokemonSelectionMenu() {
        updateImage();
    }

    public void act() {
        if (Greenfoot.isKeyDown("up")) {
            Greenfoot.delay(5);
            selected = (selected - 1 + options.length) % options.length;
            updateImage();
        } else if (Greenfoot.isKeyDown("down")) {
            Greenfoot.delay(5);
            selected = (selected + 1) % options.length;
            updateImage();
        } else if (Greenfoot.isKeyDown("enter")) {
            Greenfoot.delay(10);
            confirmSelection();
        }
    }

    private void updateImage() {
        image = new GreenfootImage(200, 100);
        image.setColor(Color.WHITE);
        image.fillRect(0, 0, 200, 100);
        image.setColor(Color.BLACK);
        image.drawRect(0, 0, 200, 100);

        for (int i = 0; i < options.length; i++) {
            if (i == selected) {
                image.setColor(Color.YELLOW);
                image.fillRect(5, 5 + i * 30, 190, 30);
                image.setColor(Color.BLACK);
            }
            image.drawString(options[i], 10, 25 + i * 30);
        }

        setImage(image);
    }

    private void confirmSelection() {
        String chosen = options[selected];
        System.out.println("You chose: " + chosen);

        // Add to inventory (assuming you have access to the Boy instance)
        GameWorld gw = (GameWorld) getWorld();
        Boy boy = gw.getBoy();  // You'll need a method like getBoy() in GameWorld
        boy.addItemToInventory(chosen);

        // Show confirmation
        gw.addObject(new DialogueBox("You chose " + chosen + "!"), 300, 350);

        // Remove the menu
        gw.removeObject(this);
    }
}
    