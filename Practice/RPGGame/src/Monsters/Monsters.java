package Monsters;

public abstract class Monsters {
    private String name;
    private final int damage;
    private int health;
    private final int cloneHealth;
    private final int defence;
    private final int reward;
    private final int dodge;

    public Monsters(String name, int damage, int health, int defence, int dodge, int reward) {
        this.name = name;
        this.damage = damage;
        this.health = health;
        this.defence = defence;
        this.reward = reward;

        this.cloneHealth = health;
        this.dodge = dodge;
    }

    public int getDodge() {
        return dodge;
    }

    public int getDefence() {
        return defence;
    }

    public int getReward() {
        return reward;
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

    public void setHealth(int health) {
        if (health < 0) {
            health = 0;
        }
        this.health = health;
    }

    public int getCloneHealth() {
        return cloneHealth;
    }

}
