package kim.ian.yams.sets.m15.blue;

import kim.ian.yams.Card;
import kim.ian.yams.Mana;
import kim.ian.yams.Planeswalker;
import kim.ian.yams.enums.PlaneswalkerSubtype;

public class JaceTheLivingGuildpact implements Card, Planeswalker {
    private static final PlaneswalkerSubtype subtype = PlaneswalkerSubtype.Jace;
    private static Mana manaCost = new Mana("2UU");

    private int loyalty = 5;

    @Override
    public Mana getManaCost() {
        return manaCost;
    }

    @Override
    public PlaneswalkerSubtype getSubtype() {
        return subtype;
    }

    @Override
    public int getLoyalty() {
        return loyalty;
    }

    @Override
    public void setLoyalty(int loyalty) {
        this.loyalty = loyalty;
    }
}
