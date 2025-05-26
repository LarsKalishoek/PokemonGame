import greenfoot.*; 
import java.util.*;

public class PokemonChoiceBox extends Actor {
    private String[] dialogue = {
        "You chose: Treecko",
        "Treecko has been added to your inventory!"
    };
    private int dialogueIndex = 0;
    private DialogueBox dialogueBox;
    private boolean inDialogue = false;
    private boolean spacePressedLastFrame = false;
    private boolean hasChosen = false;

    public void act() {
        if (hasChosen) return;
        
        if (inDialogue) {
            handleDialogueInput();
        } else {
            choosePokemon();
        }

        if (inDialogue && dialogueBox != null && !getWorld().getObjects(DialogueBox.class).contains(dialogueBox)) {
            System.out.println("Failsafe: dialogueBox disappeared unexpectedly.");
            endDialogue(getWorld());
        }

        spacePressedLastFrame = Greenfoot.isKeyDown("space");
    }

    private void choosePokemon() {
        System.out.println("PokemonChoiceBox is alive and acting");

        if (!inDialogue) {
            String chosenPokemon = "Treecko";
            System.out.println("You chose: " + chosenPokemon);

            // Get player and inventory
            List<Boy> boys = getWorld().getObjects(Boy.class);
            if (!boys.isEmpty()) {
                Boy boy = boys.get(0);
                boy.addItemToInventory(chosenPokemon);
                System.out.println(chosenPokemon + " has been added to your inventory!");

                // Start dialogue
                startDialogue(getWorld());
            }
        }
    }

    private void startDialogue(World world) {
        System.out.println("Starting dialogue...");
        inDialogue = true;
        dialogueIndex = 0;
        dialogueBox = new DialogueBox(dialogue[dialogueIndex]);
        world.addObject(dialogueBox, world.getWidth() / 2, world.getHeight() - 50);
    }

    private void handleDialogueInput() {
        boolean spaceNow = Greenfoot.isKeyDown("space");

        // Trigger next dialogue step only on new key press
        if (spaceNow && !spacePressedLastFrame) {
            nextDialogueStep(getWorld());
        }
    }

    private void nextDialogueStep(World world) {
        dialogueIndex++;
        System.out.println("nextDialogueStep called, dialogueIndex: " + dialogueIndex + "/" + dialogue.length);

        if (dialogueIndex < dialogue.length) {
            dialogueBox.updateText(dialogue[dialogueIndex]);
        } else {
            System.out.println("Reached end of dialogue, calling endDialogue()");
            endDialogue(world);
        }
    }

    private void endDialogue(World world) {
        System.out.println("endDialogue() - Removing dialogue box and enabling movement");
        if (dialogueBox != null) {
            world.removeObject(dialogueBox);
        }
        inDialogue = false;

        List<Boy> boys = world.getObjects(Boy.class);
        if (!boys.isEmpty()) {
            Boy boy = boys.get(0);
            boy.setCanMove(true);
        }
    }
}
