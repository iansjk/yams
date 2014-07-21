package kim.ian.yams.cardtypes;

import kim.ian.yams.cardtypes.PlaneswalkerSubtype;

public interface Planeswalker {
    public PlaneswalkerSubtype getSubtype();
    public int getLoyalty();
    public void setLoyalty(int loyalty);
}
