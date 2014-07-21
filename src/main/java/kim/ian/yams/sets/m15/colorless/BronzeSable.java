package kim.ian.yams.sets.m15.colorless;

import kim.ian.yams.Mana;
import kim.ian.yams.cardtypes.*;

import java.util.HashSet;
import java.util.Set;

public class BronzeSable extends Card implements Artifact, Creature {
    private static final String name = "Bronze Sable";
    private static final int basePower = 2;
    private static final int baseToughness = 1;
    private static final Mana manaCost = new Mana("2");
    private static Set<CreatureSubtype> subtypes;
    static {
        subtypes = new HashSet<>();
        subtypes.add(CreatureSubtype.Sable);
    }

    private int power = basePower;
    private int toughness = baseToughness;

    @Override
    public Mana getManaCost() {
        return manaCost;
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public Set<CreatureSubtype> getSubtypes() {
        return subtypes;
    }

    @Override
    public int getPower() {
        return this.power;
    }

    @Override
    public void setPower(int power) {
        this.power = power;
    }

    @Override
    public int getToughness() {
        return this.toughness;
    }

    @Override
    public void setToughness(int toughness) {
        this.toughness = toughness;
    }
}
