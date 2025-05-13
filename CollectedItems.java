import java.util.HashSet;
import java.util.Set;

public class CollectedItems {
    private static final Set<String> collected = new HashSet<>();

    public static void collect(String id) {
        collected.add(id);
    }

    public static boolean isCollected(String id) {
        return collected.contains(id);
    }

    public static void reset() {
        collected.clear();
    }
}
