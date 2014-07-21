package kim.ian.yams.sets.m15.white;

import kim.ian.yams.Mana;
import kim.ian.yams.cardtypes.Card;
import kim.ian.yams.cardtypes.Planeswalker;
import kim.ian.yams.cardtypes.PlaneswalkerSubtype;

public class AjaniSteadfast extends Card implements Planeswalker {
    private static final PlaneswalkerSubtype subtype = PlaneswalkerSubtype.Ajani;
    private static Mana manaCost = new Mana("3W");

    private int loyalty = 4;

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
