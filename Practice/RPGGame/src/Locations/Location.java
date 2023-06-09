package Locations;
import Characters.*;

import java.util.Scanner;

public abstract class Location  {
    public static Scanner input = new Scanner(System.in);
    private Player player;
    private final String name;
    public Location(Player player, String name){
        this.player = player;
        this.name = name;
    }

    public abstract boolean onLocation();

    public Player getPlayer() {
        return player;
    }

    public void setPlayer(Player player) {
        this.player = player;
    }

    public String getName() {
        return name;
    }

}
