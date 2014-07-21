package kim.ian.yams;

import kim.ian.yams.type.CreatureSubtype;

import java.util.Set;

public interface Creature {
    public Set<CreatureSubtype> getSubtypes();
    public int getPower();
    public void setPower(int power);
    public int getToughness();
    public void setToughness(int toughness);
}
