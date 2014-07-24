package kim.ian.yams.sets.m15.colorless;

import com.google.common.collect.Sets;
import kim.ian.yams.Mana;
import kim.ian.yams.cardtypes.Artifact;
import kim.ian.yams.cardtypes.Card;
import kim.ian.yams.cardtypes.Creature;
import kim.ian.yams.cardtypes.CreatureSubtype;

import java.util.Set;

public class BronzeSable extends Card implements Artifact, Creature {
    private static final String name = "Bronze Sable";
    private static final int basePower = 2;
    private int power = basePower;
    private static final int baseToughness = 1;
    private int toughness = baseToughness;
    private static final Mana manaCost = new Mana("2");
    private static Set<CreatureSubtype> subtypes = Sets.newHashSet(CreatureSubtype.Sable);

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
