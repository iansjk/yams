package kim.ian.yams.sets.m15.white;

import kim.ian.yams.Card;
import kim.ian.yams.Creature;
import kim.ian.yams.ManaCost;
import kim.ian.yams.type.CreatureSubtype;

import java.util.HashSet;
import java.util.Set;

public class AjanisPridemate implements Card, Creature {
    private static ManaCost manaCost = new ManaCost("1W");
    private static Set<CreatureSubtype> subtypes;
    static {
        subtypes = new HashSet<>();
        subtypes.add(CreatureSubtype.Cat);
        subtypes.add(CreatureSubtype.Soldier);
    }

    private int power = 2;
    private int toughness = 2;

    @Override
    public ManaCost getManaCost() {
        return manaCost;
    }

    @Override
    public Set<CreatureSubtype> getSubtypes() {
        return null;
    }

    @Override
    public int getPower() {
        return power;
    }

    @Override
    public void setPower(int power) {
        this.power = power;
    }

    @Override
    public int getToughness() {
        return toughness;
    }

    @Override
    public void setToughness(int toughness) {
        this.toughness = toughness;
    }
}
