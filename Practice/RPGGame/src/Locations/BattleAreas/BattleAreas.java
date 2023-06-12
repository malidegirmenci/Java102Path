package Locations.BattleAreas;

import Characters.Player;
import Locations.Location;
import Monsters.Monsters;
import java.util.Random;
import java.util.Scanner;

public abstract class BattleAreas extends Location {
    private Scanner input = new Scanner(System.in);
    private Monsters monsters;
    private final Monsters uniqueMonster;
    private final int maxMonsters;
    private final String award;
    private Random rAD = new Random();
    private Random rAQueue = new Random();
    private Random rDodge = new Random();
    private Random rItem = new Random();
    private static int remainingMonster = 0;
    public BattleAreas(Player player, String name, Monsters monsters,  int maxMonsters, Monsters uniqueMonster , String award) {
        super(player, name);
        this.monsters = monsters;
        this.award = award;
        this.maxMonsters = maxMonsters;
        this.uniqueMonster = uniqueMonster;
    }

    public int randMonsterNum(){
        Random r = new Random();
        return r.nextInt(this.getMaxMonsters())+1;
    }
    @Override
    public boolean onLocation() {

        this.getPlayer().getInventory().winTreasure();

        if (this.getPlayer().getHealth() <= 0){
            System.out.println("You are dead!");
            return false;
        }

        int monsterNum = this.randMonsterNum();
        System.out.println("You are in "+ this.getName());
        System.out.println("You can earn "+this.getAward());
        System.out.println("Be careful! "+ monsterNum + " "+ this.monsters.getName() + " are living in here!");
        System.out.print("(E)nter or (L)eave : ");
        String behavior = input.nextLine().toUpperCase();
        while(true) {
            if (behavior.equals("E")) {
                if (!combat(monsterNum) && getRemainingMonster() == 0) {
                    System.out.println("Whole monsters are dead!");
                    System.out.println(this.getName() + " is completed");
                    switch (this.getName()) {
                        case "Jangan" -> Jangan.setCompletedLoc(true);
                        case "Downhang" -> Downhang.setCompletedLoc(true);
                        case "Taklamakan" -> Taklamakan.setCompletedLoc(true);
                    }
                    return true;
                } else {
                    return true;
                }
            } else if (behavior.equals("L")) {
                System.out.println("You escaped");
                return true;
            } else {
                System.out.println("Don't you know what do you do? ");
                System.out.print("(E)nter or (L)eave : ");
                behavior = input.nextLine().toUpperCase();
            }
        }
    }

    public boolean combat(int monsterNum){
        remainingMonster = monsterNum;
        for(int i=1; i <= monsterNum; i++) {
            this.getMonsters().setHealth(getMonsters().getCloneHealth());
            playerStats();
            monsterInfo(i);
            int queue =  rAQueue.nextInt(3);
            if(queue == 0) {
                System.out.println("##########################################");
                System.out.println("Firstly you will attack to "+this.getMonsters().getName());
                System.out.println("##########################################");
                int roundNum=1;
                while (this.getPlayer().getHealth() > 0 && this.getMonsters().getHealth() > 0) {
                    System.out.println("################ ROUND "+(roundNum++)+" #################");
                    System.out.print("(A)ttack or (L)eave : ");
                    String behavior = input.nextLine().toUpperCase();
                    System.out.println("##########################################");
                    while(true) {
                        if (behavior.equals("A")) {
                            if (this.getMonsters().getDodge() >= rDodge.nextInt(10)) {
                                System.out.println(this.getMonsters().getName() + " dodged you!");
                                System.out.println();
                            } else {
                                int playerDamaged = ((this.getPlayer().getTotalDamage() - rAD.nextInt(3)) - this.getMonsters().getDefence());
                                System.out.println("You damaged " + playerDamaged + " to " + this.getMonsters().getName());
                                System.out.println("##########################################");
                                this.getMonsters().setHealth(this.getMonsters().getHealth() - playerDamaged);
                            }
                            if (this.getMonsters().getHealth() > 0) {
                                if (this.getPlayer().getDodge() >= rDodge.nextInt(10)) {
                                    System.out.println("##########################################");
                                    System.out.println("You dodged " + this.getMonsters().getName());
                                } else {
                                    int monsterDamage = (this.getMonsters().getDamage() - (rAD.nextInt(3) + 1)) - this.getPlayer().getTotalDefence();
                                    if (monsterDamage < 0) {
                                        monsterDamage = 0;
                                    }
                                    this.getPlayer().setHealth(this.getPlayer().getHealth() - monsterDamage);
                                    System.out.println(this.getMonsters().getName() + " damaged " + monsterDamage + " to you!");
                                    System.out.println("##########################################");
                                }
                            }
                            afterHit();
                            break;
                        } else if (behavior.equals("L")) {
                            System.out.println("You are left!");
                            return true;
                        } else {
                            System.out.println("Don't you know what do you do? ");
                            System.out.print("(A)ttack or (L)eave : ");
                            behavior = input.nextLine().toUpperCase();
                        }
                    }
                }
            }else{
                System.out.println("##########################################");
                System.out.println("Firstly "+ this.getMonsters().getName()+" attacked to you!");
                System.out.println("##########################################");
                int roundNum = 1;
                while (this.getPlayer().getHealth() > 0 && this.getMonsters().getHealth() > 0) {
                    System.out.println("################ ROUND "+(roundNum++)+" #################");
                    if(this.getPlayer().getDodge() >= rDodge.nextInt(10)){
                        System.out.println("You dodged "+this.getMonsters().getName());
                    }else {
                        int monsterDamage = (this.getMonsters().getDamage() - (rAD.nextInt(3) + 1)) - this.getPlayer().getTotalDefence();
                        System.out.println(this.getMonsters().getName() + " damaged "+monsterDamage+" to you");
                        if (monsterDamage < 0) {
                            monsterDamage = 0;
                        }
                        this.getPlayer().setHealth(this.getPlayer().getHealth() - monsterDamage);
                    }
                    if (this.getPlayer().getHealth() > 0) {
                        System.out.println("##########################################");
                        System.out.print("(A)ttack or (L)eave : ");
                        String behavior = input.nextLine().toUpperCase();
                        System.out.println("##########################################");
                        while(true) {
                            if (behavior.equals("A")) {
                                if (this.getMonsters().getDodge() >= rDodge.nextInt(10)) {
                                    System.out.println(this.getMonsters().getName() + " dodged you!");
                                    System.out.println("##########################################");
                                } else {
                                    int playerDamage = (this.getPlayer().getTotalDamage() - rAD.nextInt(3) - this.getMonsters().getDefence());
                                    this.getMonsters().setHealth(this.getMonsters().getHealth() - playerDamage);
                                    System.out.println("You damaged " + playerDamage + " to " + this.getMonsters().getName());
                                    System.out.println("##########################################");
                                }
                                break;
                            } else if (behavior.equals("L")) {
                                System.out.println("You are left!");
                                System.out.println("##########################################");
                                return false;
                            } else {
                                System.out.println("Don't you know what do you do? ");
                                System.out.print("(A)ttack or (L)eave : ");
                                behavior = input.nextLine().toUpperCase();
                            }
                        }
                    }
                    afterHit();
                }
            }
            if (this.getMonsters().getHealth() <= 0) {
                setRemainingMonster(1);
                this.getPlayer().setCoin(this.getPlayer().getCoin() + this.getMonsters().getReward());

            }
        }
        System.out.println("##########################################");
        System.out.println("Whole "+this.getMonsters().getName()+" are dead!");
        System.out.println("You earned " + (this.getMonsters().getReward() * monsterNum) + " coin");
        System.out.println("Your balance: " + this.getPlayer().getCoin() + " coin");
        System.out.println("You will see "+this.getUniqueMonster().getName());
        System.out.println("Be careful! It is so strong!");
        System.out.println("##########################################");
        while (this.getPlayer().getHealth() > 0 && this.getUniqueMonster().getHealth() > 0){
            remainingMonster = 1;
            System.out.println("##########################################");
            System.out.print("(A)ttack or (L)eave : ");
            String behavior = input.nextLine().toUpperCase();
            System.out.println("##########################################");
            while(true) {
                if (behavior.equals("A")) {
                    if (this.getUniqueMonster().getDodge() >= rDodge.nextInt(10)) {
                        System.out.println(this.getUniqueMonster().getName() + " dodged you!");
                    } else {
                        int playerDamage = (this.getPlayer().getTotalDamage() - rAD.nextInt(3) - this.getUniqueMonster().getDefence());
                        this.getUniqueMonster().setHealth(this.getUniqueMonster().getHealth() - playerDamage);
                        System.out.println("You damaged " + playerDamage + " to " + this.getUniqueMonster().getName());
                    }
                    if (this.getUniqueMonster().getHealth() > 0) {
                        if (this.getPlayer().getDodge() >= rDodge.nextInt(10)) {
                            System.out.println("You dodged " + this.getUniqueMonster().getName());
                        } else {
                            int monsterDamage = (this.getUniqueMonster().getDamage() - rAD.nextInt(3)) - this.getPlayer().getTotalDefence();
                            if (monsterDamage < 0) {
                                monsterDamage = 0;
                            }
                            System.out.println(this.getUniqueMonster().getName() + " damaged " + monsterDamage + " to you!");
                            this.getPlayer().setHealth(this.getPlayer().getHealth() - monsterDamage);
                        }
                    }
                    afterHitForUM();
                    break;
                } else if (behavior.equals("L")) {
                    System.out.println("You are left!");
                    System.out.println("##########################################");
                    return false;
                } else {
                    System.out.println("Don't you know what do you do? ");
                    System.out.print("(A)ttack or (L)eave : ");
                    behavior = input.nextLine().toUpperCase();
                }
            }
        }
        if (this.getUniqueMonster().getHealth() <= 0) {
            remainingMonster = 0;
            System.out.println("You killed to "+this.getUniqueMonster().getName());
            if(this.getName().equals("Dungeons")){
                int randItem = rItem.nextInt(100);
                if(randItem < 10){
                    this.getPlayer().getInventory().setWeaponsInBag();
                } else if(randItem < 80){
                    this.getPlayer().getInventory().setArmorsInBag();
                } else if (randItem < 90) {
                    System.out.println("You earned "+this.getUniqueMonster().getReward()+" coin");
                    this.getPlayer().setCoin(this.getPlayer().getCoin() + this.getUniqueMonster().getReward());
                    System.out.println("Your balance: "+ this.getPlayer().getCoin());
                } else {
                    System.out.println("You couldn't earn anything");
                }
            } else{
                this.getPlayer().getInventory().setTreasure(1);
                System.out.println("You collected "+ this.getAward());
                this.getPlayer().getInventory().setTreasureList("| " + this.getAward() + " |");
                System.out.println("You earned "+this.getUniqueMonster().getReward()+" coin");
                this.getPlayer().setCoin(this.getPlayer().getCoin() + this.getUniqueMonster().getReward());
                System.out.println("Your balance: "+ this.getPlayer().getCoin());
            }
        }
        System.out.println("##########################################");
        return false;
    }

    public void afterHit(){
        System.out.println("##########################################");
        System.out.println(this.getPlayer().getCharName()+"'s Health: "+ this.getPlayer().getHealth());
        System.out.println(this.getMonsters().getName() + "'s Health: "+ this.getMonsters().getHealth());
        System.out.println("##########################################");
    }
    public void afterHitForUM(){
        System.out.println("##########################################");
        System.out.println(this.getPlayer().getCharName()+"'s Health: "+ this.getPlayer().getHealth());
        System.out.println(this.getUniqueMonster().getName() + "'s Health: "+ this.getUniqueMonster().getHealth());
        System.out.println("##########################################");
    }
    public void playerStats(){
        System.out.println("####################");
        System.out.println("    Player Stats    ");
        System.out.println("####################");
        System.out.println("Weapon: "+ this.getPlayer().getInventory().getWeapons().getName());
        System.out.println("Armor: "+ this.getPlayer().getInventory().getArmors().getName());
        System.out.println("Health: "+ this.getPlayer().getHealth());
        System.out.println("Damage: "+ this.getPlayer().getTotalDamage());
        System.out.println("Defence: "+this.getPlayer().getTotalDefence());
        System.out.println("Coin: "+ this.getPlayer().getCoin());
        System.out.println("Your treasures: "+getPlayer().getInventory().getTreasureList());
    }
    public void monsterInfo(int i){
        System.out.println("####################");
        System.out.println(i + " th "+ this.getMonsters().getName() + "'s Stats");
        System.out.println("####################");
        System.out.println("Health: "+ this.getMonsters().getHealth());
        System.out.println("Damage: "+ this.getMonsters().getDamage());
        System.out.println("Defence: "+ this.getMonsters().getDefence());
        System.out.println("Award: "+ this.getMonsters().getReward());
    }

    public Monsters getMonsters() {
        return monsters;
    }
    public void setMonsters(Monsters monsters) {
        this.monsters = monsters;
    }
    public int getMaxMonsters() {
        return maxMonsters;
    }
    public String getAward() {
        return award;
    }
    public Monsters getUniqueMonster() {
        return uniqueMonster;
    }
    public static int getRemainingMonster() {
        return remainingMonster;
    }
    public static void setRemainingMonster(int remainingMonster) {
        BattleAreas.remainingMonster -= remainingMonster;
    }
}
