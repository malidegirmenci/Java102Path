package Locations.City;

import Characters.Player;
import Locations.Location;

public abstract class City extends Location {
    public City(Player player, String name) {
        super(player, name);
    }
    @Override
    public boolean onLocation(){
        return true;
    }
}
