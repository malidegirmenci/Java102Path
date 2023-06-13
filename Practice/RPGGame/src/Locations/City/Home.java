package Locations.City;

import Characters.Player;
import Inventory.Armors;
import Inventory.Weapons;

public class Home extends City {
    public Home(Player player) {
        super(player, "Home");
    }

    @Override
    public boolean onLocation() {
        if (getPlayer().getInventory().getTreasure() >= 3) {
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
            if (!isEmptySlot()) {
                System.out.print("Do you want to see your in bag? Y/N : ");
                String behavior = input.nextLine().toUpperCase();
                while (!(behavior.equals("Y") || behavior.equals("N"))) {
                    System.out.println("Invalid choice!");
                    System.out.print("Do you want to see your in bag? Y/N : ");
                    behavior = input.nextLine().toUpperCase();
                }
                changeItems(behavior);
            } else {
                System.out.println("##########################################");
                System.out.println("You don't have any items in your bag!");
                System.out.println("##########################################");
            }
        }
        return true;
    }

    public void changeItems(String behavior) {
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
                    System.out.print("I choose to ... : ");
                    behavior = input.nextLine().toUpperCase();
                    switch (behavior) {
                        case "1" -> {
                            if (this.getPlayer().getInventory().getWeaponsInBag()[0] != null && this.getPlayer().getInventory().getWeaponsInBag()[0].getTypeChar().equals(this.getPlayer().getName())) {
                                System.out.println("Previous Weapon: " + this.getPlayer().getInventory().getWeapons().getName());

                                Weapons tempWeapon = this.getPlayer().getInventory().getWeapons();
                                this.getPlayer().getInventory().setWeapons(this.getPlayer().getInventory().getWeaponsInBag()[0]);
                                this.getPlayer().getInventory().getWeaponsInBag()[0] = tempWeapon;

                                System.out.println("Currently Weapon: " + this.getPlayer().getInventory().getWeapons().getName());

                            } else {
                                System.out.println("##########################################");
                                System.out.println("This weapon is not for " + this.getPlayer().getName());
                                System.out.println("##########################################");
                            }
                        }
                        case "2" -> {
                            if (this.getPlayer().getInventory().getWeaponsInBag()[1] != null && this.getPlayer().getInventory().getWeaponsInBag()[1].getTypeChar().equals(this.getPlayer().getName())) {
                                System.out.println("Previous Weapon: " + this.getPlayer().getInventory().getWeapons().getName());

                                Weapons tempWeapon = this.getPlayer().getInventory().getWeapons();
                                this.getPlayer().getInventory().setWeapons(this.getPlayer().getInventory().getWeaponsInBag()[1]);
                                this.getPlayer().getInventory().getWeaponsInBag()[1] = tempWeapon;

                                System.out.println("Currently Weapon: " + this.getPlayer().getInventory().getWeapons().getName());
                            } else {
                                System.out.println("##########################################");
                                System.out.println("This weapon is not for " + this.getPlayer().getName());
                                System.out.println("##########################################");
                            }
                        }
                        case "3" -> {
                            if (this.getPlayer().getInventory().getWeaponsInBag()[2] != null && this.getPlayer().getInventory().getWeaponsInBag()[2].getTypeChar().equals(this.getPlayer().getName())) {
                                System.out.println("Previous Weapon: " + this.getPlayer().getInventory().getWeapons().getName());

                                Weapons tempWeapon = this.getPlayer().getInventory().getWeapons();
                                this.getPlayer().getInventory().setWeapons(this.getPlayer().getInventory().getWeaponsInBag()[2]);
                                this.getPlayer().getInventory().getWeaponsInBag()[2] = tempWeapon;

                                System.out.println("Currently Weapon: " + this.getPlayer().getInventory().getWeapons().getName());
                            } else {
                                System.out.println("##########################################");
                                System.out.println("This weapon is not for " + this.getPlayer().getName());
                                System.out.println("##########################################");
                            }
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
                            if (this.getPlayer().getInventory().getArmorsInBag()[0] != null && this.getPlayer().getInventory().getArmorsInBag()[0].typeChar().equals(this.getPlayer().getName())) {
                                System.out.println("Previous Armor: " + this.getPlayer().getInventory().getArmors().name());

                                Armors tempArmor = this.getPlayer().getInventory().getArmors();
                                this.getPlayer().getInventory().setArmors(this.getPlayer().getInventory().getArmorsInBag()[0]);
                                this.getPlayer().getInventory().getArmorsInBag()[0] = tempArmor;

                                System.out.println("Currently Armor: " + this.getPlayer().getInventory().getArmors().name());
                            } else {
                                System.out.println("##########################################");
                                System.out.println("This armor is not for " + this.getPlayer().getName());
                                System.out.println("##########################################");
                            }
                        }
                        case "2" -> {
                            if (this.getPlayer().getInventory().getArmorsInBag()[1] != null && this.getPlayer().getInventory().getArmorsInBag()[1].typeChar().equals(this.getPlayer().getName())) {
                                System.out.println("Previous Armor: " + this.getPlayer().getInventory().getArmors().name());

                                Armors tempArmor = this.getPlayer().getInventory().getArmors();
                                this.getPlayer().getInventory().setArmors(this.getPlayer().getInventory().getArmorsInBag()[1]);
                                this.getPlayer().getInventory().getArmorsInBag()[1] = tempArmor;

                                System.out.println("Currently Armor: " + this.getPlayer().getInventory().getArmors().name());
                            } else {
                                System.out.println("##########################################");
                                System.out.println("This armor is not for " + this.getPlayer().getName());
                                System.out.println("##########################################");
                            }
                        }
                        case "3" -> {
                            if (this.getPlayer().getInventory().getArmorsInBag()[2] != null && this.getPlayer().getInventory().getArmorsInBag()[2].typeChar().equals(this.getPlayer().getName())) {
                                System.out.println("Previous Armor: " + this.getPlayer().getInventory().getArmors().name());

                                Armors tempArmor = this.getPlayer().getInventory().getArmors();
                                this.getPlayer().getInventory().setArmors(this.getPlayer().getInventory().getArmorsInBag()[2]);
                                this.getPlayer().getInventory().getArmorsInBag()[2] = tempArmor;

                                System.out.println("Currently Armor: " + this.getPlayer().getInventory().getArmors().name());
                            } else {
                                System.out.println("##########################################");
                                System.out.println("This armor is not for " + this.getPlayer().getName());
                                System.out.println("##########################################");
                            }
                        }
                    }
                }
            }
        }
    }

    public void printArmorsInBag() {
        int i = 1;
        for (Armors droppedArmorList : this.getPlayer().getInventory().getArmorsInBag()) {
            if (droppedArmorList != null)
                System.out.println(i++ + "-> " + droppedArmorList.name() + " Armor: " + droppedArmorList.defence() + " Coin: " + droppedArmorList.price());
        }
        System.out.println("0-> Leave");
    }

    public boolean isEmptySlot() {
        int emptySlotForWeapon = 0;
        for (Weapons droppedWeaponList : this.getPlayer().getInventory().getWeaponsInBag()) {
            if (droppedWeaponList == null) {
                emptySlotForWeapon++;
            }
        }
        int emptySlotForArmor = 0;
        for (Armors droppedArmorList : this.getPlayer().getInventory().getArmorsInBag()) {
            if (droppedArmorList == null) {
                emptySlotForArmor++;
            }
        }
        return (emptySlotForWeapon == this.getPlayer().getInventory().getWeaponsInBag().length) && (emptySlotForArmor == this.getPlayer().getInventory().getArmorsInBag().length);
    }

    public void printWeaponInBag() {
        int i = 1;
        for (Weapons droppedWeaponList : this.getPlayer().getInventory().getWeaponsInBag()) {
            if (droppedWeaponList != null) {
                System.out.println(i++ + "-> " + droppedWeaponList.getName() + " Damage: " + droppedWeaponList.getDamage() + " Coin: " + droppedWeaponList.getPrice());
            }
        }
        System.out.println("0-> Leave");
    }
}
