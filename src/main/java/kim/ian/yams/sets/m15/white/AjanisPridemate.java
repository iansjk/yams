package kim.ian.yams.sets.m15.white;

import kim.ian.yams.Mana;
import kim.ian.yams.cardtypes.Card;
import kim.ian.yams.cardtypes.Creature;
import kim.ian.yams.cardtypes.CreatureSubtype;

import java.util.HashSet;
import java.util.Set;

public class AjanisPridemate extends Card implements Creature {
    private static Mana manaCost = new Mana("1W");
    private static Set<CreatureSubtype> subtypes;
    static {
        subtypes = new HashSet<>();
        subtypes.add(CreatureSubtype.Cat);
        subtypes.add(CreatureSubtype.Soldier);
    }

    private int power = 2;
    private int toughness = 2;

    @Override
    public Mana getManaCost() {
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
