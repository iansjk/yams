package kim.ian.yams.cardtypes;

import kim.ian.yams.Mana;

import java.util.Set;

public abstract class Card {
    public abstract Mana getManaCost();

    public abstract String getName();

    public Set<Color> getColors() {
        return Mana.getColorsFromMana(getManaCost());
    }
}
