package Characters;

import Inventory.Inventory;

import java.util.Scanner;

public class Player {
    private final Scanner input = new Scanner(System.in);
    private final String charName;
    private String name;
    private int damage;
    private int health;
    private int coin;
    private final Inventory inventory;
    private int defence;
    private int cloneHealth;
    private int dodge;

    public Player(String name) {
        this.name = name;
        this.charName = name;
        this.inventory = new Inventory();
    }

    public void detailCharList() {
        Chars[] charList = {new Warrior(), new Archer(), new Mage()};
        System.out.println("######################################################################");
        System.out.println("                             Characters                               ");
        System.out.println("######################################################################");
        for (Chars gChars : charList) {
            System.out.println("(" + gChars.getID() + ") " + gChars.getName() + " |>" +
                    "| Damage: " + gChars.getDamage() + " |" +
                    "| Defence: " + gChars.getDefence() + " |" +
                    "| Health: " + gChars.getHealth() + " |" +
                    "| Coin: " + gChars.getCoin() + " ||");
        }
        System.out.println("######################################################################");
    }

    public void selectChar() {
        System.out.print("I selected -> ");
        int selectedChar = input.nextInt();
        switch (selectedChar) {
            case 1 -> initPlayer(new Warrior());
            case 2 -> initPlayer(new Archer());
            case 3 -> initPlayer(new Mage());
            default -> System.out.println("Invalid selection");
        }
    }

    public void initPlayer(Chars gChars) {
        this.setName(gChars.getName());
        this.setHealth(gChars.getHealth());
        this.setDamage(gChars.getDamage());
        this.setDefence(gChars.getDefence());
        this.setCoin(gChars.getCoin());
        this.setCloneHealth(gChars.getHealth());
        this.setDodge(gChars.getDodge());

    }

    public int getTotalDamage() {
        return this.getDamage() + this.getInventory().getWeapons().getDamage();
    }

    public int getTotalDefence() {
        return this.getDefence() + this.getInventory().getArmors().defence();
    }

    public void printInfo() {
        System.out.println("##############");
        System.out.println("   Statics    ");
        System.out.println("##############");
        System.out.println("You are " + this.getName());
        System.out.println(
                "Armor: " + this.getInventory().getArmors().name() +
                        "\nWeapon: " + this.getInventory().getWeapons().getName() +
                        "\nDamage: " + this.getTotalDamage() +
                        "\nDefence: " + this.getTotalDefence() +
                        "\nDodge: " + this.getDodge() +
                        "\nHealth: " + this.getHealth() +
                        "\nCoin: " + this.getCoin() +
                        "\nTreasures: " + this.getInventory().getTreasureList()
        );
        System.out.println("##############");
    }

    public int getCloneHealth() {
        return cloneHealth;
    }

    public void setCloneHealth(int cloneHealth) {
        this.cloneHealth = cloneHealth;
    }

    public String getCharName() {
        return charName;
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
        if (health < 0) {
            health = 0;
        }
        this.health = health;
    }

    public int getCoin() {
        return coin;
    }

    public void setCoin(int coin) {
        this.coin = coin;
    }

    public Inventory getInventory() {
        return inventory;
    }

    public int getDefence() {
        return defence;
    }

    public void setDefence(int defence) {
        this.defence = defence;
    }

    public int getDodge() {
        return dodge;
    }

    public void setDodge(int dodge) {
        this.dodge = dodge;
    }
}