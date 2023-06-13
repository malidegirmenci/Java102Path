package Locations.BattleAreas;

import Characters.Player;
import Monsters.Mangyang;
import Monsters.TigerGirl;


public class Jangan extends BattleAreas {
    private static boolean CompletedLoc = false;
    public Jangan(Player player) {
        super(player, "Jangan",new Mangyang(), 5,new TigerGirl(),"Tiger Girl's Necklace");
    }

    public static boolean isCompletedLoc() {
        return CompletedLoc;
    }

    public static void setCompletedLoc(boolean completedLoc) {
        CompletedLoc = completedLoc;
    }
}
