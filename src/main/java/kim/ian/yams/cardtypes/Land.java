package kim.ian.yams.cardtypes;

import java.util.Set;

public interface Land {
    public boolean isBasicLand();

    public Set<LandSubtype> getSubtypes();
}
