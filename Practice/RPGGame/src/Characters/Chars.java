package Characters;

public abstract class Chars {
    private final int ID;
    private String name;
    private final int damage;
    private final int defence;
    private final int health;
    private final int coin;
    private final int dodge;

    public Chars(int ID, String name, int damage, int defence, int dodge, int health, int coin) {
        this.ID = ID;
        this.name = name;
        this.damage = damage;
        this.defence = defence;
        this.health = health;
        this.coin = coin;
        this.dodge = dodge;
    }

    public int getDefence() {
        return defence;
    }

    public int getID() {
        return ID;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getDamage() {
        return damage;
    }

    public int getHealth() {
        return health;
    }


    public int getCoin() {
        return coin;
    }

    public int getDodge() {
        return dodge;
    }
}
