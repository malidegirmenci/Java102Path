package Inventory;

public class Inventory {
    private Weapons weapons;
    private Armors armors;
    private String treasureList="";
    private int treasure = 0;
    private final Weapons[] weaponsInBag = new Weapons[3];
    private final Armors[] armorsInBag = new Armors[3];

    public Inventory(){
        this.weapons = new Weapons(-1,"Fist",1, 0,"Newbie");
        this.armors  = new Armors(-1,"Sheet",1,0,"Newbie");
    }

    public void winTreasure(){
        if(treasure == 3){
            System.out.println("All treasures collected\nAll quest completed");
        }
    }

    public Weapons[] getWeaponsInBag() {
        return weaponsInBag;
    }

    public void setWeaponsInBag() {
        if(weaponsInBag[0] == null){
            weaponsInBag[0] = Weapons.randomWeapon();
            System.out.println("You earned to : "+ weaponsInBag[0].getName());
        }else if(weaponsInBag[1] == null){
            weaponsInBag[1] = Weapons.randomWeapon();
            System.out.println("You earned to : "+ weaponsInBag[1].getName());
        } else if (weaponsInBag[2] == null) {
            weaponsInBag[2] = Weapons.randomWeapon();
            System.out.println("You earned to : "+ weaponsInBag[2].getName());
        }else{
            System.out.println("Your Weapons Bag is FULL!");
            System.out.println("You can not take more item!");
        }
    }
    public Armors[] getArmorsInBag() {
        return armorsInBag;
    }
    public void setArmorsInBag() {
        if(armorsInBag[0] == null){
            armorsInBag[0] = Armors.randomArmor();
            System.out.println("You earned to : "+ armorsInBag[0].getName());
        }else if(armorsInBag[1] == null){
            armorsInBag[1] = Armors.randomArmor();
            System.out.println("You earned to : "+ armorsInBag[1].getName());
        } else if (armorsInBag[2] == null) {
            armorsInBag[2] = Armors.randomArmor();
            System.out.println("You earned to : "+ armorsInBag[2].getName());
        }else{
            System.out.println("Your Armors Bag is FULL!");
            System.out.println("You can not take more item!");
        }
    }
    public Weapons getWeapons() {
        return weapons;
    }

    public void setWeapons(Weapons weapons) {
        this.weapons = weapons;
    }

    public Armors getArmors() {
        return armors;
    }

    public void setArmors(Armors armors) {
        this.armors = armors;
    }

    public  int getTreasure() {
        return treasure;
    }

    public  void setTreasure(int treasure) {
        this.treasure += treasure;
    }

    public String getTreasureList() {
        return treasureList;
    }

    public void setTreasureList(String treasureList) {
        this.treasureList += treasureList;
    }
}
