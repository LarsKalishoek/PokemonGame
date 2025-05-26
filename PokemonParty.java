import java.util.HashMap;

public class PokemonParty {
    private static HashMap<String, Pokemon> pokemons = new HashMap<>();

    public static void addPokemon(String name) {
        if (!pokemons.containsKey(name)) {
            pokemons.put(name, createPokemonFromName(name));
        }
    }
    private static Pokemon createPokemonFromName(String name) {
    switch (name.toLowerCase()) {
        case "treecko":
            return new Pokemon("Treecko", 40, 45, 35, new String[]{"Pound", "Leer"});
        case "torchic":
            return new Pokemon("Torchic", 45, 60, 40, new String[]{"Scratch", "Growl"});
        case "mudkip":
            return new Pokemon("Mudkip", 50, 70, 50, new String[]{"Tackle", "Water Gun"});
        default:
            return new Pokemon(name, 0, 0, 0, new String[]{"Unknown"});
    }
}


    public static HashMap<String, Pokemon> getPokemons() {
        return pokemons;
    }
    
    public static boolean hasStarter() {
        return !pokemons.isEmpty();
    }



    public static void clear() {
        pokemons.clear();
    }
}
