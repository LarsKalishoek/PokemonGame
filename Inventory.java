import java.util.HashMap;

public class Inventory {
    private static HashMap<String, Integer> items = new HashMap<>();

    public static void addItem(String itemName) {
        addItem(itemName, 1);
    }

    public static void addItem(String itemName, int quantity) {
        items.put(itemName, items.getOrDefault(itemName, 0) + quantity);
    }

    public static HashMap<String, Integer> getItems() {
        return items;
    }

    public static void clear() {
        items.clear();
    }
}

