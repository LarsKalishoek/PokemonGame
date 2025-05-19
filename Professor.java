import greenfoot.*;

public class Professor extends Actor {
    private boolean spacePressedLastFrame = false;
    private int dialogueIndex = 0;
    private boolean inDialogue = false;
    private DialogueBox dialogueBox;
    private boolean hasChosenPokemon = false;
    private String[] dialogue = {};

    public Professor() {
        GreenfootImage fullImage = new GreenfootImage("professor/professorIdle.png");

        int cropWidth = 20;
        int cropHeight = 28;
        GreenfootImage cropped = new GreenfootImage(cropWidth, cropHeight);
        cropped.drawImage(fullImage, -37, -36);

        int targetHeight = 65;
        double scaleFactor = (double) targetHeight / cropHeight;
        int newWidth = (int)(cropWidth * scaleFactor);
        int newHeight = (int)(cropHeight * scaleFactor);
        cropped.scale(newWidth, newHeight);

        setImage(cropped);
    }

    public void act() {
        World world = getWorld();
        boolean spaceNow = Greenfoot.isKeyDown("space");
        Boy boy = (Boy) getOneObjectAtOffset(0, 0, Boy.class);
    
        if (boy != null && spaceNow && !spacePressedLastFrame && !inDialogue) {
            startDialogue(world);
        }
    
        if (inDialogue && spaceNow && !spacePressedLastFrame) {
            nextDialogueStep(world);
        }
    
        spacePressedLastFrame = spaceNow;
    }


    private void startDialogue(World world) {
        inDialogue = true;
        dialogueIndex = 0;
    
        if (GameState.hasChosenStarter) {
            dialogue = new String[]{
                "You have already chosen a Pokémon. Good luck on your journey!"
            };
        } else {
            dialogue = new String[]{
                "Hello there! I'm Professor Birch.",
                "Welcome to the world of Pokémon!",
                "It's time to choose your first Pokémon."
            };
        }
    
        dialogueBox = new DialogueBox(dialogue[dialogueIndex]);
        world.addObject(dialogueBox, 300, 350);
    
        Boy boy = (Boy) world.getObjects(Boy.class).get(0);
        boy.setCanMove(false);
    }


    private void nextDialogueStep(World world) {
        dialogueIndex++;
        if (dialogueIndex < dialogue.length) {
            dialogueBox.updateText(dialogue[dialogueIndex]);
        } else {
            endDialogue(world);

            if (!GameState.hasChosenStarter) {
                showPokemonChoices(world);
            }
        }
    }

    private void endDialogue(World world) {
        world.removeObject(dialogueBox);
        inDialogue = false;
    
        Boy boy = (Boy) world.getObjects(Boy.class).get(0);
        boy.setCanMove(true);
    }


    private void showPokemonChoices(World world) {
        world.addObject(new PokemonChoiceBox(), 300, 350);
    }
}
