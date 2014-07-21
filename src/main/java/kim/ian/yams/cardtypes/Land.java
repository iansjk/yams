package kim.ian.yams.cardtypes;

import kim.ian.yams.Mana;
import kim.ian.yams.cardtypes.LandSubtype;

import java.util.Set;

public interface Land {
    public boolean isBasicLand();
    public Set<LandSubtype> getSubtypes();
    public Mana tap();
}
