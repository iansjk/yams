package kim.ian.yams;

import java.util.regex.Pattern;

public class Mana {
    private static final Pattern VALID_MANA_REGEX = Pattern.compile("(0|([1-9][0-9]*)?W*U*B*R*G*X*)");

    private final String repr;

    public Mana() {
        this.repr = "0";
    }

    public Mana(String repr) {
        if (isReprValid(repr)) {
            this.repr = repr;
        } else {
            throw new IllegalArgumentException(repr + " is not a valid mana representation");
        }
    }

    @Override
    public boolean equals(Object other) {
        if (other == null) {
            return false;
        }
        try {
            Mana otherMana = (Mana) other;
            return this.repr.equals(otherMana.getRepr());
        } catch (ClassCastException e) {
            return false;
        }
    }

    public int hashCode() {
        return this.repr.hashCode();
    }

    public String getRepr() {
        return this.repr;
    }

    public static boolean isReprValid(String repr) {
        return VALID_MANA_REGEX.matcher(repr).matches();
    }
}
