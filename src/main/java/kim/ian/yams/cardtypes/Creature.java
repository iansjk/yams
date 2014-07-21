package kim.ian.yams.cardtypes;

import kim.ian.yams.cardtypes.CreatureSubtype;

import java.util.Set;

public interface Creature {
    public Set<CreatureSubtype> getSubtypes();
    public int getPower();
    public void setPower(int power);
    public int getToughness();
    public void setToughness(int toughness);
}
