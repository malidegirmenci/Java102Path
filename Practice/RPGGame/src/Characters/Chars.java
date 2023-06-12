package Characters;

public abstract class Chars {
    private int ID;
    private String name;
    private int damage;
    private int defence;
    private int health;
    private int coin;
    private int dodge;

    public Chars(int ID, String name, int damage,int defence, int dodge,int health, int coin) {
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

    public void setDefence(int defence) {
        this.defence = defence;
    }

    public int getID() {
        return ID;
    }

    public void setID(int ID) {
        this.ID = ID;
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

    public void setDamage(int damage) {
        this.damage = damage;
    }

    public int getHealth() {
        return health;
    }

    public void setHealth(int health) {
        this.health = health;
    }

    public int getCoin() {
        return coin;
    }

    public void setCoin(int coin) {
        this.coin = coin;
    }

    public int getDodge() {
        return dodge;
    }

    public void setDodge(int dodge) {
        this.dodge = dodge;
    }
}
