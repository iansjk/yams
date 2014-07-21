package kim.ian.yams;

import kim.ian.yams.enums.LandSubtype;

import java.util.Set;

public interface Land {
    public boolean isBasicLand();
    public Set<LandSubtype> getSubtypes();
    public ManaCost tap();
}
