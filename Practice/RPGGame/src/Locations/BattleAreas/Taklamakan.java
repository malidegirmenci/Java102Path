package Locations.BattleAreas;

import Characters.Player;
import Monsters.LordYarkan;
import Monsters.NiyasSoldier;
import Monsters.Uruchi;

public class Taklamakan extends BattleAreas{
    private static boolean completedLoc = false;
    public Taklamakan(Player player) {
        super(player, "Taklamakan", new NiyasSoldier(), 3, new LordYarkan(),"Lord Yarkan's Sword");
    }

    public static boolean isCompletedLoc() {
        return completedLoc;
    }

    public static void setCompletedLoc(boolean completedLoc) {
        Taklamakan.completedLoc = completedLoc;
    }
}
