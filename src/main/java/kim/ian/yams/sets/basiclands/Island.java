package kim.ian.yams.sets.basiclands;

import kim.ian.yams.Card;
import kim.ian.yams.Land;
import kim.ian.yams.Mana;
import kim.ian.yams.enums.LandSubtype;

import java.util.HashSet;
import java.util.Set;

public class Island implements Card, Land {
    private static Set<LandSubtype> subtypes;
    static {
        subtypes = new HashSet<>();
        subtypes.add(LandSubtype.Island);
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
        return new Mana("U");
    }
}
