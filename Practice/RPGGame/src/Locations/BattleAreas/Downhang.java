package Locations.BattleAreas;

import Characters.Player;
import Monsters.Robber;
import Monsters.Uruchi;

public class Downhang extends BattleAreas{
    private static boolean completedLoc = false;

    public Downhang(Player player) {
        super(player, "Downhang", new Robber(), 3, new Uruchi(),"Uruchi's Head");
    }

    public static boolean isCompletedLoc() {
        return completedLoc;
    }

    public static void setCompletedLoc(boolean completedLoc) {
        Downhang.completedLoc = completedLoc;
    }
}
