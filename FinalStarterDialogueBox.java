import greenfoot.*;

public class FinalStarterDialogueBox extends DialogueBox {
    private boolean spacePressedLastFrame = false;

    public FinalStarterDialogueBox(String text) {
        super(text);
    }

    public void act() {
        boolean spaceNow = Greenfoot.isKeyDown("space");

        if (spaceNow && !spacePressedLastFrame) {
            endDialogue();
        }

        spacePressedLastFrame = spaceNow;
    }

    private void endDialogue() {
        World world = getWorld();
        world.removeObject(this);

        Boy boy = (Boy) world.getObjects(Boy.class).get(0);
        boy.setCanMove(true);
    }
}
