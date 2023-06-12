package Locations.City;

import Characters.Player;
import Inventory.Armors;
import Inventory.Inventory;
import Inventory.Weapons;
import Locations.Location;

public class Blacksmith extends City {
    public Blacksmith(Player player){
        super(player,"Blacksmith");
    }
    @Override
    public boolean onLocation(){
        System.out.println("Blacksmith: Welcome "+this.getPlayer().getName());
        boolean showMenu = true;
        while (showMenu){
                System.out.println("""
                        I want to buy ...
                        1-> Weapons
                        2-> Armors
                        3-> Bag
                        0-> Leave
                        """);
                System.out.println("What do you want "+this.getPlayer().getName());
                int behavior = input.nextInt();
                while (behavior < 0 || behavior > 3){
                    System.out.println("I don't understand you, say again!");
                    behavior = input.nextInt();
                }
                switch (behavior){
                    case 1 -> {
                        printWeapon();
                        buyWeapon();
                    }
                    case 2 -> {
                        printArmor();
                        buyArmor();
                    }
                    case 3 -> {
                        System.out.println("##########################################");
                        System.out.println("You are looking in your bag!");
                        System.out.println("These are in your bag"+ this.getPlayer().getName());
                        System.out.println("1- Weapons\n2- Armors\n0- Leave");
                        System.out.print("I want to look ... ");
                        behavior = input.nextInt();
                        while(behavior < 0 || behavior > 2){
                            System.out.println("I don't understand you, say again!");
                            behavior = input.nextInt();
                        }
                        if (behavior == 1) {
                            if(!(this.getPlayer().getInventory().getWeaponsInBag() == null)) {
                                printWeaponInBag();
                                System.out.print("Which one do you want to sell? : ");
                                behavior = input.nextInt();
                                while (behavior < 0 || behavior > 3) {
                                    System.out.println("I don't understand you, say again!");
                                    behavior = input.nextInt();
                                }
                                if (behavior == 1) {
                                    System.out.println("You sold to " + this.getPlayer().getInventory().getWeaponsInBag()[0].getName());
                                    System.out.println("You earned to " + this.getPlayer().getInventory().getWeaponsInBag()[0].getPrice() + " coin");
                                    this.getPlayer().setCoin(this.getPlayer().getCoin() + (this.getPlayer().getInventory().getWeaponsInBag()[0].getPrice()));
                                    System.out.println("Your balance: "+this.getPlayer().getCoin());
                                    this.getPlayer().getInventory().getWeaponsInBag()[0] = null;
                                    if(this.getPlayer().getInventory().getWeaponsInBag()[1] != null){
                                        this.getPlayer().getInventory().getWeaponsInBag()[0] = this.getPlayer().getInventory().getWeaponsInBag()[1];
                                        if(this.getPlayer().getInventory().getWeaponsInBag()[2] != null){
                                            this.getPlayer().getInventory().getWeaponsInBag()[1] = this.getPlayer().getInventory().getWeaponsInBag()[2];
                                            this.getPlayer().getInventory().getWeaponsInBag()[2] = null;
                                        }
                                    }
                                } else if (behavior == 2) {
                                    System.out.println("You sold to " + this.getPlayer().getInventory().getWeaponsInBag()[1].getName());
                                    System.out.println("You earned to " + this.getPlayer().getInventory().getWeaponsInBag()[1].getPrice() + " coin");
                                    this.getPlayer().setCoin(this.getPlayer().getCoin() + (this.getPlayer().getInventory().getWeaponsInBag()[1].getPrice()));
                                    System.out.println("Your balance: "+this.getPlayer().getCoin());
                                    this.getPlayer().getInventory().getWeaponsInBag()[1] = null;
                                    if(this.getPlayer().getInventory().getWeaponsInBag()[2] != null){
                                        this.getPlayer().getInventory().getWeaponsInBag()[1] = this.getPlayer().getInventory().getWeaponsInBag()[2];
                                        this.getPlayer().getInventory().getWeaponsInBag()[2] = null;
                                    }
                                } else if (behavior == 3) {
                                    System.out.println("You sold to " + this.getPlayer().getInventory().getWeaponsInBag()[2].getName());
                                    System.out.println("You earned to " + this.getPlayer().getInventory().getWeaponsInBag()[2].getPrice() + " coin");
                                    this.getPlayer().setCoin(this.getPlayer().getCoin() + (this.getPlayer().getInventory().getWeaponsInBag()[2].getPrice()));
                                    System.out.println("Your balance: "+this.getPlayer().getCoin());
                                    this.getPlayer().getInventory().getWeaponsInBag()[2] = null;
                                } else {
                                    showMenu = true;
                                }
                            }else {
                                System.out.println("You don't have any weapon!");
                                showMenu = true;
                            }
                        } else if (behavior == 2){
                            if(!(this.getPlayer().getInventory().getArmorsInBag() == null)) {
                                printArmorsInBag();
                                System.out.print("Which one do you want to sell? : ");
                                behavior = input.nextInt();
                                while (behavior < 0 || behavior > 3) {
                                    System.out.println("I don't understand you, say again!");
                                    behavior = input.nextInt();
                                }
                                if (behavior == 1) {
                                    System.out.println("You sold to " + this.getPlayer().getInventory().getArmorsInBag()[0].getName());
                                    System.out.println("You earned to " + this.getPlayer().getInventory().getArmorsInBag()[0].getPrice() + " coin");
                                    this.getPlayer().setCoin(this.getPlayer().getCoin() + (this.getPlayer().getInventory().getArmorsInBag()[0].getPrice()));
                                    System.out.println("Your balance: "+this.getPlayer().getCoin());
                                    this.getPlayer().getInventory().getArmorsInBag()[0] = null;
                                    if(this.getPlayer().getInventory().getArmorsInBag()[1] != null){
                                        this.getPlayer().getInventory().getArmorsInBag()[0] = this.getPlayer().getInventory().getArmorsInBag()[1];
                                        if(this.getPlayer().getInventory().getArmorsInBag()[2] != null){
                                            this.getPlayer().getInventory().getArmorsInBag()[1] = this.getPlayer().getInventory().getArmorsInBag()[2];
                                            this.getPlayer().getInventory().getArmorsInBag()[2] = null;
                                        }
                                    }
                                } else if (behavior == 2) {
                                    System.out.println("You sold to " + this.getPlayer().getInventory().getArmorsInBag()[1].getName());
                                    System.out.println("You earned to " + this.getPlayer().getInventory().getArmorsInBag()[1].getPrice() + " coin");
                                    this.getPlayer().setCoin(this.getPlayer().getCoin() + (this.getPlayer().getInventory().getArmorsInBag()[1].getPrice()));
                                    System.out.println("Your balance: "+this.getPlayer().getCoin());
                                    this.getPlayer().getInventory().getArmorsInBag()[1] = null;
                                    if(this.getPlayer().getInventory().getArmorsInBag()[2] != null){
                                        this.getPlayer().getInventory().getArmorsInBag()[1] = this.getPlayer().getInventory().getArmorsInBag()[2];
                                        this.getPlayer().getInventory().getArmorsInBag()[2] = null;
                                    }

                                } else if (behavior == 3) {
                                    System.out.println("You sold to " + this.getPlayer().getInventory().getArmorsInBag()[2].getName());
                                    System.out.println("You earned to " + this.getPlayer().getInventory().getArmorsInBag()[2].getPrice() + " coin");
                                    this.getPlayer().setCoin(this.getPlayer().getCoin() + (this.getPlayer().getInventory().getArmorsInBag()[2].getPrice()));
                                    System.out.println("Your balance: " + this.getPlayer().getCoin());
                                    this.getPlayer().getInventory().getArmorsInBag()[2] = null;
                                } else {
                                    showMenu = true;
                                }
                            }else {
                                System.out.println("You don't have any armor!");
                                showMenu = true;
                            }
                        } else{
                            showMenu = true;
                        }
                        System.out.println("##########################################");
                    }
                    case 0 -> {
                        System.out.println("Blacksmith: Come again! "+this.getPlayer().getName());
                        showMenu = false;
                    }
                }
            }
        return true;
    }
    public void printArmorsInBag(){
        int i = 1;
        for(Armors droppedArmorList : this.getPlayer().getInventory().getArmorsInBag()){
            if(droppedArmorList != null)
                System.out.println(i++ +"-> " + droppedArmorList.getName() +" Armor: "+ droppedArmorList.getDefence() + " Coin: "+ droppedArmorList.getPrice());
        }
        System.out.println("0-> Leave");
    }

    public void printWeaponInBag(){
        int i = 1;
        for(Weapons droppedWeaponList : this.getPlayer().getInventory().getWeaponsInBag()){
            if(droppedWeaponList != null)
                System.out.println(i++ + "-> " + droppedWeaponList.getName() +" Damage: "+ droppedWeaponList.getDamage() + " Coin: "+ droppedWeaponList.getPrice());
        }
        System.out.println("0-> Leave");
    }
    public void printWeapon(){
        switch (this.getPlayer().getName()) {
            case "Warrior" -> {
                System.out.println("Warrior's Weapons");
                System.out.println("---------------------");
                for (Weapons warriorWeapon : Weapons.warriorWeapons()) {
                    System.out.println(warriorWeapon.getID() + "-> " + warriorWeapon.getName()+
                                    " Damage: " + warriorWeapon.getDamage()+
                                    " Price: " + warriorWeapon.getPrice());
                }
            }
            case "Archer" -> {
                System.out.println("Archer's Weapons");
                System.out.println("---------------------");
                for (Weapons archerWeapon : Weapons.archerWeapons()) {
                    System.out.println(archerWeapon.getID() + "-> " + archerWeapon.getName() +
                                    " Damage: " + archerWeapon.getDamage()+
                                    " Price: " + archerWeapon.getPrice());
                }
            }
            case "Mage" -> {
                System.out.println("Mage's Weapons");
                System.out.println("---------------------");
                for (Weapons mageWeapon : Weapons.mageWeapons()) {
                    System.out.println(mageWeapon.getID() + "-> " + mageWeapon.getName() +
                                    " Damage: " + mageWeapon.getDamage()+
                                    " Price: " + mageWeapon.getPrice());
                }
            }
        }
        System.out.println("0-> Leave");
    }
    public void printArmor(){
        switch (this.getPlayer().getName()) {
            case "Warrior" -> {
                System.out.println("Warrior's Armor");
                System.out.println("---------------------");
                for (Armors warriorArmor : Armors.warriorArmors()) {
                    System.out.println(warriorArmor.getID() + "-> " + warriorArmor.getName() +
                                    " Defence: " + warriorArmor.getDefence()+
                                    " Price: " + warriorArmor.getPrice());
                }
            }
            case "Archer" -> {
                System.out.println("Archer's Armor");
                System.out.println("---------------------");
                for (Armors archerArmor : Armors.archerArmors()) {
                    System.out.println(archerArmor.getID() + "-> " + archerArmor.getName() +
                                    " Defence: " + archerArmor.getDefence()+
                                    " Price: " + archerArmor.getPrice());
                }
            }
            case "Mage" -> {
                System.out.println("Mage's Weapons");
                System.out.println("---------------------");
                for (Armors mageArmor : Armors.mageArmors()) {
                    System.out.println(mageArmor.getID() + "-> " + mageArmor.getName() +
                                    " Defence: " + mageArmor.getDefence()+
                                    " Price: " + mageArmor.getPrice());
                }
            }
        }
        System.out.println("0-> Leave");
    }
    public void buyWeapon(){
        System.out.println("Choose a weapon!");
        int weaponID = input.nextInt();
        while (weaponID < 0 || weaponID > 3){
            System.out.println("Blacksmith: I don't understand to you! Choose one!");
            weaponID = input.nextInt();
        }
        if(weaponID != 0){
            switch (this.getPlayer().getName()) {
                case "Warrior" -> {
                    Weapons selectedWeapon = Weapons.getWarriorWeaponObjByID(weaponID);
                    if (selectedWeapon != null) {
                        if (selectedWeapon.getPrice() > this.getPlayer().getCoin()) {
                            System.out.println("You don't have enough coin!");
                        } else {
                            System.out.println(selectedWeapon.getName() + " purchased");
                            int balance = this.getPlayer().getCoin() - selectedWeapon.getPrice();
                            this.getPlayer().setCoin(balance);
                            System.out.println("Remaining of balance: " + this.getPlayer().getCoin());
                            System.out.println("Previous weapon: " + this.getPlayer().getInventory().getWeapons().getName());
                            this.getPlayer().getInventory().setWeapons(selectedWeapon);
                            System.out.println("Currently weapon: " + this.getPlayer().getInventory().getWeapons().getName());
                        }
                    }
                }
                case "Archer" -> {
                    Weapons selectedWeapon = Weapons.getArcherWeaponObjByID(weaponID);
                    if (selectedWeapon != null) {
                        if (selectedWeapon.getPrice() > this.getPlayer().getCoin()) {
                            System.out.println("You don't have enough coin!");
                        } else {
                            System.out.println(selectedWeapon.getName() + " purchased");
                            int balance = this.getPlayer().getCoin() - selectedWeapon.getPrice();
                            this.getPlayer().setCoin(balance);
                            System.out.println("Remaining of balance: " + this.getPlayer().getCoin());
                            System.out.println("Previous weapon: " + this.getPlayer().getInventory().getWeapons().getName());
                            this.getPlayer().getInventory().setWeapons(selectedWeapon);
                            System.out.println("Currently weapon: " + this.getPlayer().getInventory().getWeapons().getName());
                        }
                    }
                }
                case "Mage" -> {
                    Weapons selectedWeapon = Weapons.getMageWeaponObjByID(weaponID);
                    if (selectedWeapon != null) {
                        if (selectedWeapon.getPrice() > this.getPlayer().getCoin()) {
                            System.out.println("You don't have enough coin!");
                        } else {
                            System.out.println(selectedWeapon.getName() + " purchased");
                            int balance = this.getPlayer().getCoin() - selectedWeapon.getPrice();
                            this.getPlayer().setCoin(balance);
                            System.out.println("Remaining of balance: " + this.getPlayer().getCoin());
                            System.out.println("Previous weapon: " + this.getPlayer().getInventory().getWeapons().getName());
                            this.getPlayer().getInventory().setWeapons(selectedWeapon);
                            System.out.println("Currently weapon: " + this.getPlayer().getInventory().getWeapons().getName());
                        }
                    }
                }
            }
        }
    }
    public void buyArmor(){
        System.out.println("Choose a armor!");
        int armorID = input.nextInt();
        while (armorID < 0 || armorID > 3){
            System.out.println("Blacksmith: I don't understand to you! Choose one!");
            armorID = input.nextInt();
        }
        if(armorID != 0){
            switch (this.getPlayer().getName()) {
                case "Warrior" -> {
                    Armors selectedArmor = Armors.getWarriorArmorObjByID(armorID);
                    if (selectedArmor != null) {
                        if (selectedArmor.getPrice() > this.getPlayer().getCoin()) {
                            System.out.println("You don't have enough coin!");
                        } else {
                            System.out.println(selectedArmor.getName() + " purchased");
                            int balance = this.getPlayer().getCoin() - selectedArmor.getPrice();
                            this.getPlayer().setCoin(balance);
                            System.out.println("Remaining of balance: " + this.getPlayer().getCoin());
                            System.out.println("Previous armor: " + this.getPlayer().getInventory().getArmors().getName());
                            this.getPlayer().getInventory().setArmors(selectedArmor);
                            System.out.println("Currently armor: " + this.getPlayer().getInventory().getArmors().getName());
                        }
                    }
                }
                case "Archer" -> {
                    Armors selectedArmor = Armors.getArcherArmorObjByID(armorID);
                    if (selectedArmor != null) {
                        if (selectedArmor.getPrice() > this.getPlayer().getCoin()) {
                            System.out.println("You don't have enough coin!");
                        } else {
                            System.out.println(selectedArmor.getName() + " purchased");
                            int balance = this.getPlayer().getCoin() - selectedArmor.getPrice();
                            this.getPlayer().setCoin(balance);
                            System.out.println("Remaining of balance: " + this.getPlayer().getCoin());
                            System.out.println("Previous armor: " + this.getPlayer().getInventory().getArmors().getName());
                            this.getPlayer().getInventory().setArmors(selectedArmor);
                            System.out.println("Currently armor: " + this.getPlayer().getInventory().getArmors().getName());
                        }
                    }
                }
                case "Mage" -> {
                    Armors selectedArmor = Armors.getMageArmorObjByID(armorID);
                    if (selectedArmor != null) {
                        if (selectedArmor.getPrice() > this.getPlayer().getCoin()) {
                            System.out.println("You don't have enough coin!");
                        } else {
                            System.out.println(selectedArmor.getName() + " purchased");
                            int balance = this.getPlayer().getCoin() - selectedArmor.getPrice();
                            this.getPlayer().setCoin(balance);
                            System.out.println("Remaining of balance: " + this.getPlayer().getCoin());
                            System.out.println("Previous armor: " + this.getPlayer().getInventory().getArmors().getName());
                            this.getPlayer().getInventory().setArmors(selectedArmor);
                            System.out.println("Currently armor: " + this.getPlayer().getInventory().getArmors().getName());
                        }
                    }
                }
            }
        }
    }
}
