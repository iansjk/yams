package kim.ian.yams;

public class ManaCost {
    private static final String VALID_MANA_COST_REGEX = "(0|([1-9][0-9]*)?W*U*B*R*G*X*)";

    private String repr;

    public ManaCost(String repr) {
        if (isReprValid(repr)) {
            this.repr = repr;
        } else {
            throw new IllegalArgumentException(repr + " is not a valid mana cost representation");
        }
    }

    public boolean isReprValid(String repr) {
        return repr.matches(VALID_MANA_COST_REGEX);
    }
}
