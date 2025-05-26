public class Pokemon {
    private String name;
    private int hp;
    private int attack;
    private int defense;
    private String[] moves;

    public Pokemon(String name, int hp, int attack, int defense, String[] moves) {
        this.name = name;
        this.hp = hp;
        this.attack = attack;
        this.defense = defense;
        this.moves = moves;
    }

    public String getName() { return name; }
    public int getHp() { return hp; }
    public int getAttack() { return attack; }
    public int getDefense() { return defense; }
    public String[] getMoves() { return moves; }
}
