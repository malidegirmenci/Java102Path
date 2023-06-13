package Inventory;

import java.util.Random;

public class Weapons {
    private final int ID;
    private String name;
    private final int damage;
    private final int price;
    private final String typeChar;
    private static final Random randomID = new Random();
    public Weapons(int ID, String name, int damage, int price,String typeChar) {
        this.name = name;
        this.ID = ID;
        this.damage = damage;
        this.price = price;
        this.typeChar = typeChar;
    }
    public static Weapons[] warriorWeapons(){
        Weapons[] weaponList = new Weapons[3];
        weaponList[0] = new Weapons(1,"Sword",5, 15,"Warrior");
        weaponList[1] = new Weapons(2,"Axe", 7, 25,"Warrior");
        weaponList[2] = new Weapons(3,"Spear",10, 40,"Warrior");
        return weaponList;
    }
    public static Weapons[] archerWeapons(){
        Weapons[] weaponList = new Weapons[2];
        weaponList[0] = new Weapons(1,"Bow",7, 20,"Archer");
        weaponList[1] = new Weapons(2,"Crossbow", 9, 25,"Archer");
        return weaponList;
    }
    public static Weapons[] mageWeapons(){
        Weapons[] weaponList = new Weapons[2];
        weaponList[0] = new Weapons(1,"Harp",10, 15,"Mage");
        weaponList[1] = new Weapons(2,"Staff", 12, 35,"Mage");

        return weaponList;
    }
    public static Weapons[] droppableWeapons(){
        Weapons[] weapon = new Weapons[7];
        weapon[0] = new Weapons(0,"Sword",5, 15,"Warrior");
        weapon[1] = new Weapons(1,"Bow",7, 20,"Archer");
        weapon[2] = new Weapons(2,"Harp",10, 15,"Mage");
        weapon[3] = new Weapons(3,"Staff", 12, 35,"Mage");
        weapon[4] = new Weapons(4,"Crossbow", 9, 25,"Archer");
        weapon[5] = new Weapons(5,"Axe", 7, 25,"Warrior");
        weapon[6] = new Weapons(6,"Spear",10, 40,"Warrior");
        return weapon;
    }
    public static Weapons randomWeapon(){
        for(Weapons randomWeapon : droppableWeapons()){
            if(randomID.nextInt(100) < 30) {
                int randomWeaponID = randomID.nextInt(3,7);
                if (randomWeapon.getID() == randomWeaponID) {
                    return randomWeapon;
                }
            } else{
                int randomWeaponID = randomID.nextInt(0,3);
                if (randomWeapon.getID() == randomWeaponID) {
                    return randomWeapon;
                }
            }
        }
        return randomWeapon();
    }
    public static Weapons getWarriorWeaponObjByID(int ID){
        for ( Weapons warriorW : Weapons.warriorWeapons()){
            if(warriorW.getID() == ID){
                return warriorW;
            }
        }
        return null;
    }
    public static Weapons getArcherWeaponObjByID(int ID){
        for ( Weapons archerW : Weapons.archerWeapons()){
            if(archerW.getID() == ID){
                return archerW;
            }
        }
        return null;
    }
    public static Weapons getMageWeaponObjByID(int ID){
        for ( Weapons mageW : Weapons.mageWeapons()){
            if(mageW.getID() == ID){
                return mageW;
            }
        }
        return null;
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

    public int getPrice() {
        return price;
    }

    public String getTypeChar() {
        return typeChar;
    }

}
