package kim.ian.yams.sets.m15.white;

import kim.ian.yams.Card;
import kim.ian.yams.ManaCost;
import kim.ian.yams.Planeswalker;
import kim.ian.yams.enums.PlaneswalkerSubtype;

public class AjaniSteadfast implements Card, Planeswalker {
    private static final PlaneswalkerSubtype subtype = PlaneswalkerSubtype.Ajani;
    private static ManaCost manaCost = new ManaCost("3W");

    private int loyalty = 4;

    @Override
    public ManaCost getManaCost() {
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
