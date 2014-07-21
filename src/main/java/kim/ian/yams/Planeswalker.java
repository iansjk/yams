package kim.ian.yams;

import kim.ian.yams.enums.PlaneswalkerSubtype;

public interface Planeswalker {
    public PlaneswalkerSubtype getSubtype();
    public int getLoyalty();
    public void setLoyalty(int loyalty);
}
