package kim.ian.yams;

public class Mana {
    private static final String VALID_MANA_REGEX = "(0|([1-9][0-9]*)?W*U*B*R*G*X*)";

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

    public boolean equals(Mana other) {
        return this.repr.hashCode() == other.getRepr().hashCode();
    }

    public int hashCode() {
        return this.repr.hashCode();
    }

    public String getRepr() {
        return this.repr;
    }

    public static boolean isReprValid(String repr) {
        return repr.matches(VALID_MANA_REGEX);
    }
}
