package kim.ian.yams;

import kim.ian.yams.cardtypes.Color;

import java.util.HashSet;
import java.util.Set;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Mana {
    private static final Pattern VALID_MANA_REGEX = Pattern.compile("0|(?<colorless>([1-9][0-9]*)?)" +
            "(?<colored>W*U*B*R*G*)(?<x>X*)");

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

    public static Set<Color> getColorsFromMana(Mana mana) {
        Set<Color> colors = new HashSet<>();
        if (mana != null && !mana.getRepr().equals("0")) {
            Matcher m = VALID_MANA_REGEX.matcher(mana.getRepr());
            m.find();  // prime the matcher for group lookup
            String coloredRepr = m.group("colored");
            for (int i = 0; i < coloredRepr.length(); i++) {
                char colorCharacter = coloredRepr.charAt(i);
                Color colorToAdd = null;
                switch (colorCharacter) {
                    case 'W':
                        colorToAdd = Color.White;
                        break;
                    case 'U':
                        colorToAdd = Color.Blue;
                        break;
                    case 'B':
                        colorToAdd = Color.Black;
                        break;
                    case 'R':
                        colorToAdd = Color.Red;
                        break;
                    case 'G':
                        colorToAdd = Color.Green;
                        break;
                }
                if (!colors.contains(colorToAdd)) {
                    colors.add(colorToAdd);
                }
            }
        }
        return colors;
    }

    public static boolean isReprValid(String repr) {
        return repr != null && VALID_MANA_REGEX.matcher(repr).matches();
    }

    public Mana getConvertedMana() {
        if (!this.repr.equals("0")) {
            Matcher m = VALID_MANA_REGEX.matcher(this.repr);
            m.find();  // prime the matcher for group lookup
            String colorlessPart = m.group("colorless");
            String coloredPart = m.group("colored");
            int totalCost = (colorlessPart.isEmpty()) ? 0 : Integer.parseInt(colorlessPart);
            if (!coloredPart.isEmpty()) {
                totalCost += coloredPart.length();
            }
            return new Mana(Integer.toString(totalCost));
        }
        return new Mana();
    }

    @Override
    public int hashCode() {
        return this.repr.hashCode();
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

    @Override
    public String toString() {
        return this.repr;
    }

    public String getRepr() {
        return this.repr;
    }
}
