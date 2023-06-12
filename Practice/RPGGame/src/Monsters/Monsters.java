package Monsters;

public abstract class Monsters {
    private String name;
    private int damage;
    private int health;
    private int cloneHealth;
    private int defence;
    private int reward;
    private int dodge;
    private String questItem;
 

    public Monsters(String name, int damage, int health, int defence, int dodge,int reward, String questItem) {
        this.name = name;
        this.damage = damage;
        this.health = health;
        this.defence = defence;
        this.reward = reward;
        this.questItem = questItem;
        this.cloneHealth = health;
        this.dodge = dodge;
    }

    public int getDodge() {
        return dodge;
    }

    public void setDodge(int dodge) {
        this.dodge = dodge;
    }

    public String getQuestItem() {
        return questItem;
    }

    public void setQuestItem(String questItem) {
        this.questItem = questItem;
    }

    public int getDefence() {
        return defence;
    }

    public void setDefence(int defence) {
        this.defence = defence;
    }

    public int getReward() {
        return reward;
    }

    public void setReward(int reward) {
        this.reward = reward;
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
        if(health < 0) {
            health = 0;
        }
        this.health = health;
    }

    public int getCloneHealth() {
        return cloneHealth;
    }

    public void setCloneHealth(int cloneHealth) {
        this.cloneHealth = cloneHealth;
    }
}
