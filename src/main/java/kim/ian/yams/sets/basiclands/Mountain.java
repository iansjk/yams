package kim.ian.yams.sets.basiclands;

import kim.ian.yams.Mana;
import kim.ian.yams.cardtypes.Card;
import kim.ian.yams.cardtypes.Land;
import kim.ian.yams.cardtypes.LandSubtype;

import java.util.HashSet;
import java.util.Set;

public class Mountain extends Card implements Land {
    private static String name = "Mountain";
    private static Set<LandSubtype> subtypes;

    static {
        subtypes = new HashSet<LandSubtype>();
        subtypes.add(LandSubtype.Mountain);
    }

    @Override
    public Mana getManaCost() {
        return new Mana("0");
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public boolean isBasicLand() {
        return true;
    }

    @Override
    public Set<LandSubtype> getSubtypes() {
        return subtypes;
    }
}
