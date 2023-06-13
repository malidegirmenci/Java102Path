package Locations.BattleAreas;

import Characters.Player;
import Monsters.WingTribe;
import Monsters.WingTribeDuke;

public class Dungeons extends BattleAreas {
    public Dungeons(Player player) {
        super(player, "Dungeons", new WingTribe(), 5, new WingTribeDuke(), "weapons or armors");
    }
}
