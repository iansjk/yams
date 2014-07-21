package kim.ian.yams.sets.basiclands;

import kim.ian.yams.Card;
import kim.ian.yams.Land;
import kim.ian.yams.ManaCost;
import kim.ian.yams.enums.LandSubtype;

import java.util.HashSet;
import java.util.Set;

public class Forest implements Card, Land {
    private static Set<LandSubtype> subtypes;
    static {
        subtypes = new HashSet<>();
        subtypes.add(LandSubtype.Forest);
    }

    @Override
    public ManaCost getManaCost() {
        return new ManaCost("0");
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
    public ManaCost tap() {
        return new ManaCost("G");
    }
}
