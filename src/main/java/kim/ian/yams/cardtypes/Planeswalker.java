package kim.ian.yams.cardtypes;

public interface Planeswalker {
    public PlaneswalkerSubtype getSubtype();

    public int getLoyalty();

    public void setLoyalty(int loyalty);
}
