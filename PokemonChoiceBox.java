import greenfoot.*;

public class PokemonChoiceBox extends Actor {
    private String[] options = {"Treecko", "Torchic", "Mudkip"};
    private int selectedIndex = 0;
    private GreenfootImage boxImage;
    private boolean keyCooldown = false;
    private boolean hasChosen = false;

    public PokemonChoiceBox() {
        boxImage = new GreenfootImage(200, 100);
        updateImage();
    }

    public PokemonChoiceBox(String dummy) {
        this();
    }

    public void act() {
        if (hasChosen) return;

        if (Greenfoot.isKeyDown("up") && !keyCooldown) {
            selectedIndex = (selectedIndex + options.length - 1) % options.length;
            updateImage();
            keyCooldown = true;
        } else if (Greenfoot.isKeyDown("down") && !keyCooldown) {
            selectedIndex = (selectedIndex + 1) % options.length;
            updateImage();
            keyCooldown = true;
        } else if (!Greenfoot.isKeyDown("up") && !Greenfoot.isKeyDown("down")) {
            keyCooldown = false;
        }

        if (Greenfoot.isKeyDown("enter")) {
            hasChosen = true;
            choosePokemon();
        }
    }

    private void updateImage() {
        boxImage.clear();
        boxImage.setColor(Color.WHITE);
        boxImage.fill();
        boxImage.setColor(Color.BLACK);
        boxImage.drawRect(0, 0, boxImage.getWidth()-1, boxImage.getHeight()-1);

        for (int i = 0; i < options.length; i++) {
            if (i == selectedIndex) {
                boxImage.setColor(Color.YELLOW);
                boxImage.fillRect(5, i * 30 + 5, 190, 30);
            }
            boxImage.setColor(Color.BLACK);
            boxImage.drawString(options[i], 10, i * 30 + 25);
        }

        setImage(boxImage);
    }

    private void choosePokemon() {
        String chosen = options[selectedIndex];
        System.out.println("You chose: " + chosen);

        World world = getWorld();
        Boy boy = (Boy) world.getObjects(Boy.class).get(0);
        boy.addItemToInventory(chosen);

        GameState.hasChosenStarter = true;

        world.removeObjects(world.getObjects(PokemonChoiceBox.class));

        world.addObject(new DialogueBox("You chose " + chosen + "! Take good care of it!"), 300, 350);
        boy.setCanMove(true);
    }
}
