import java.util.HashSet;
import java.util.Set;

public class CollectedItems {
    private static final Set<String> collected = new HashSet<>();
    private static boolean isReset = false;  // Tracks if the game has been reset

    // Resets the collected items (e.g., when the player chooses to restart the game)
    public static void reset() {
        if (isReset) {
            collected.clear();
            isReset = false; // Ensures items are reset only once
        }
    }

    // Collect an item by its unique ID
    public static void collect(String id) {
        collected.add(id);
    }

    // Check if an item is collected
    public static boolean isCollected(String id) {
        return collected.contains(id);
    }

    // Flag the game as reset (this will be called when the game is restarted)
    public static void markAsReset() {
        isReset = true;
    }
}
