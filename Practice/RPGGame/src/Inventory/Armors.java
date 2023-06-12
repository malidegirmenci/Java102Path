package Inventory;

import java.util.Random;

public class Armors {
    private int ID;
    private String name;
    private int defence;
    private int price;
    private String typeChar;
    private static Random randomID = new Random();

    public Armors(int ID, String name, int defence, int price, String typeChar) {
        this.ID = ID;
        this.name = name;
        this.defence = defence;
        this.price = price;
        this.typeChar = typeChar;
    }

    public static Armors[] warriorArmors(){
        Armors[] armorList = new Armors[2];
        armorList[0] = new Armors(1,"Light Armor",5, 15,"Warrior");
        armorList[1] = new Armors(2,"Heavy Armor",10, 25,"Warrior");
        return armorList;
    }
    public static Armors[] archerArmors(){
        Armors[] armorList = new Armors[2];
        armorList[0] = new Armors(1,"Cape",3,10,"Archer");
        armorList[1] = new Armors(2,"Camouflage", 5, 20,"Archer");
        return armorList;
    }

    public static Armors[] mageArmors(){
        Armors[] armorList = new Armors[2];
        armorList[0] = new Armors(1,"Robe",2,15,"Mage");
        armorList[1] = new Armors(2,"Eldritch Robe", 4, 30,"Mage");

        return armorList;
    }
    public static Armors[] droppableArmors(){
        Armors[] armor = new Armors[6];
        armor[0] = new Armors(0,"Robe",2,15,"Mage");
        armor[1] = new Armors(1,"Cape",3,15,"Archer");
        armor[2] = new Armors(2,"Light Armor",5, 15,"Warrior");
        armor[3] = new Armors(3,"Eldritch Robe", 4, 30,"Mage");
        armor[4] = new Armors(4,"Camouflage", 5, 30,"Archer");
        armor[5] = new Armors(5,"Heavy Armor",10, 30,"Warrior");
        return armor;
    }

    public static Armors randomArmor(){
        for(Armors randomArmor : droppableArmors()){
            if(randomID.nextInt(100) < 50) {
                int randomArmorID = randomID.nextInt(3,6);
                if (randomArmor.getID() == randomArmorID) {
                    return randomArmor;
                }
            } else{
                int randomArmorID = randomID.nextInt(0,3);
                if (randomArmor.getID() == randomArmorID) {
                    return randomArmor;
                }
            }
        }
        return randomArmor();
    }

    public static Armors getWarriorArmorObjByID(int ID){
        for(Armors warriorA : Armors.warriorArmors()) {
            if (warriorA.getID() == ID) {
                return warriorA;
            }
        }
        return null;
    }
    public static Armors getArcherArmorObjByID(int ID){
        for(Armors archerA : Armors.archerArmors()) {
            if (archerA.getID() == ID) {
                return archerA;
            }
        }
        return null;
    }
    public static Armors getMageArmorObjByID(int ID){
        for(Armors mageA : Armors.mageArmors()) {
            if (mageA.getID() == ID) {
                return mageA;
            }
        }
        return null;
    }

    public String getTypeChar() {
        return typeChar;
    }

    public void setTypeChar(String typeChar) {
        this.typeChar = typeChar;
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

    public int getDefence() {
        return defence;
    }

    public void setDefence(int defence) {
        this.defence = defence;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }
}
