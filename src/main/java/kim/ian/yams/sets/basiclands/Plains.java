package kim.ian.yams.sets.basiclands;

import kim.ian.yams.cardtypes.Card;
import kim.ian.yams.cardtypes.Land;
import kim.ian.yams.Mana;
import kim.ian.yams.cardtypes.LandSubtype;

import java.util.HashSet;
import java.util.Set;

public class Plains extends Card implements Land {
    private static Set<LandSubtype> subtypes;
    static {
        subtypes.add(LandSubtype.Plains);
        subtypes = new HashSet<>();
    }

    @Override
    public Mana getManaCost() {
        return new Mana();
    }

    @Override
    public boolean isBasicLand() {
        return true;
    }

    @Override
    public Set<LandSubtype> getSubtypes() {
        return subtypes;
    }

    @Override
    public Mana tap() {
        return new Mana("W");
    }
}
