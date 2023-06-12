package Locations.City;

import Characters.Player;
import Inventory.Armors;
import Inventory.Weapons;


public class Home extends City{
    public Home(Player player) {
        super(player, "Home");
    }
    @Override
    public boolean onLocation() {
        if(getPlayer().getInventory().getTreasure() >= 3){
            System.out.println();
            System.out.println("You completed all quest!");
            System.out.println("You came in your home as a hero!");
            System.out.println("You are the WINNER!");
            System.out.println();
            return false;
        } else {
            System.out.println("You are in safe house!");
            System.out.println("You are healing.");
            this.getPlayer().setHealth(this.getPlayer().getCloneHealth());
            System.out.println("Your health: " + getPlayer().getHealth());
            if(!isEmptySlot()) {
                System.out.print("Do you want to see your in bag? Y/N : ");
                String behavior = input.nextLine().toUpperCase();
                if (behavior.equals("Y")) {
                    System.out.println("1- Weapon");
                    System.out.println("2- Armor");
                    System.out.println("0- Leave");
                    System.out.print("Which item would you like to change? : ");
                    behavior = input.nextLine().toUpperCase();
                    switch (behavior) {
                        case "1" -> {
                            System.out.println("Be careful! You can change only in your class weapons");
                            System.out.println("Which weapon would you like to change?");
                            printWeaponInBag();
                            System.out.print("I choose to ... ");
                            behavior = input.nextLine().toUpperCase();
                            switch (behavior) {
                                case "1" -> {
                                    System.out.println("Previous Weapon: " + this.getPlayer().getInventory().getWeapons().getName());
                                    if (this.getPlayer().getInventory().getWeaponsInBag()[0] != null) {
                                        this.getPlayer().getInventory().setWeapons(this.getPlayer().getInventory().getWeaponsInBag()[0]);
                                    }
                                    System.out.println("Currently Weapon: " + this.getPlayer().getInventory().getWeapons().getName());
                                }
                                case "2" -> {
                                    System.out.println("Previous Weapon: " + this.getPlayer().getInventory().getWeapons().getName());
                                    if (this.getPlayer().getInventory().getWeaponsInBag()[1] != null) {
                                        this.getPlayer().getInventory().setWeapons(this.getPlayer().getInventory().getWeaponsInBag()[1]);
                                    }
                                    System.out.println("Currently Weapon: " + this.getPlayer().getInventory().getWeapons().getName());
                                }
                                case "3" -> {
                                    System.out.println("Previous Weapon: " + this.getPlayer().getInventory().getWeapons().getName());
                                    if (this.getPlayer().getInventory().getWeaponsInBag()[2] != null) {
                                        this.getPlayer().getInventory().setWeapons(this.getPlayer().getInventory().getWeaponsInBag()[2]);
                                    }
                                    System.out.println("Currently Weapon: " + this.getPlayer().getInventory().getWeapons().getName());
                                }
                            }
                        }
                        case "2" -> {
                            System.out.println("Which armor would you like to change?");
                            printArmorsInBag();
                            System.out.print("I choose to ... ");
                            behavior = input.nextLine().toUpperCase();
                            switch (behavior) {
                                case "1" -> {
                                    if(this.getPlayer().getInventory().getArmorsInBag()[0] != null && this.getPlayer().getInventory().getArmorsInBag()[0].getTypeChar().equals(this.getPlayer().getName())) {
                                        System.out.println("Previous Armor: " + this.getPlayer().getInventory().getArmors().getName());

                                        Armors tempArmor = this.getPlayer().getInventory().getArmors();
                                        this.getPlayer().getInventory().setArmors(this.getPlayer().getInventory().getArmorsInBag()[0]);
                                        this.getPlayer().getInventory().getArmorsInBag()[0] = tempArmor;

                                        System.out.println("Currently Armor: " + this.getPlayer().getInventory().getArmors().getName());
                                    }else{
                                        System.out.println("This armor is not for " + this.getPlayer().getName());
                                    }
                                }
                                case "2" -> {
                                    if(this.getPlayer().getInventory().getArmorsInBag()[1] != null && this.getPlayer().getInventory().getArmorsInBag()[1].getTypeChar().equals(this.getPlayer().getName())) {
                                        System.out.println("Previous Armor: " + this.getPlayer().getInventory().getArmors().getName());

                                        Armors tempArmor = this.getPlayer().getInventory().getArmors();
                                        this.getPlayer().getInventory().setArmors(this.getPlayer().getInventory().getArmorsInBag()[1]);
                                        this.getPlayer().getInventory().getArmorsInBag()[1] = tempArmor;

                                        System.out.println("Currently Armor: " + this.getPlayer().getInventory().getArmors().getName());
                                    }else{
                                        System.out.println("This armor is not for " + this.getPlayer().getName());
                                    }
                                }
                                case "3" -> {
                                    if(this.getPlayer().getInventory().getArmorsInBag()[2] != null && this.getPlayer().getInventory().getArmorsInBag()[2].getTypeChar().equals(this.getPlayer().getName())) {
                                        System.out.println("Previous Armor: " + this.getPlayer().getInventory().getArmors().getName());

                                        Armors tempArmor = this.getPlayer().getInventory().getArmors();
                                        this.getPlayer().getInventory().setArmors(this.getPlayer().getInventory().getArmorsInBag()[2]);
                                        this.getPlayer().getInventory().getArmorsInBag()[2] = tempArmor;

                                        System.out.println("Currently Armor: " + this.getPlayer().getInventory().getArmors().getName());
                                    }else {
                                        System.out.println("This armor is not for " + this.getPlayer().getName());
                                    }
                                }
                            }
                        }
                        case "3" -> {
                            return true;
                        }
                    }
                }
                return true;
            } else {
                System.out.println("##########################################");
                System.out.println("You don't have any items in your bag!");
                System.out.println("##########################################");
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
    public boolean isEmptySlot(){
        int emptySlotForWeapon = 0;
        for(Weapons droppedWeaponList : this.getPlayer().getInventory().getWeaponsInBag()){
            if(droppedWeaponList == null) {
                emptySlotForWeapon++;
            }
        }
        int emptySlotForArmor = 0;
        for(Armors droppedArmorList : this.getPlayer().getInventory().getArmorsInBag()){
            if(droppedArmorList == null){
                emptySlotForArmor++;
            }
        }
        return (emptySlotForWeapon == this.getPlayer().getInventory().getWeaponsInBag().length) && (emptySlotForArmor == this.getPlayer().getInventory().getArmorsInBag().length);
    }
    public void printWeaponInBag(){
        int i = 1;
        for(Weapons droppedWeaponList : this.getPlayer().getInventory().getWeaponsInBag()){
            if(droppedWeaponList != null) {
                System.out.println(i++ + "-> " + droppedWeaponList.getName() + " Damage: " + droppedWeaponList.getDamage() + " Coin: " + droppedWeaponList.getPrice());
            }
        }
        System.out.println("0-> Leave");
    }
}
