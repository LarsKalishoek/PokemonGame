import greenfoot.*;

public class BattleWorld extends World {
    public BattleWorld() {
        super(600, 400, 1);

        // Achtergrondafbeelding voor battle
        setBackground("battle_background.png"); // zorg dat je deze toevoegt aan je project

        // Speler- en wilde Pokémon plaatsen (placeholder sprites)
        //addObject(new PlayerPokemon(), 150, 250);
        //addObject(new WildPokemon(), 450, 100);

        // Menu-opties (rechtsonder)
        addObject(new BattleButton("Fight"), 420, 300);
        addObject(new BattleButton("Bag"),   520, 300);
        addObject(new BattleButton("Pokémon"), 420, 350);
        addObject(new BattleButton("Run"),   520, 350);
    }
}
