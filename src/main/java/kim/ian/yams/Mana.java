package kim.ian.yams;

import kim.ian.yams.cardtypes.Color;

import java.util.HashSet;
import java.util.Set;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Mana {
    private static final Pattern VALID_MANA_REGEX = Pattern.compile("0|(?<colorless>([1-9][0-9]*)?)" +
            "(?<colored>W*U*B*R*G*)(?<xs>X*)");

    private String repr = "0";
    private String colorlessPart = "0";
    private String coloredPart = "";
    private String xs = "";

    public Mana(String repr) {
        boolean valid = true;
        
        if (repr == null) {
            valid = false;
        } else {
            Matcher m = VALID_MANA_REGEX.matcher(repr);
            if (!m.matches()) {
                valid = false;
            } else {
                this.repr = repr;
                if (!repr.equals("0")) {
                    this.colorlessPart = m.group("colorless");
                    this.coloredPart = m.group("colored");
                    this.xs = m.group("xs");
                }
            }
        }
        
        if (!valid) {
            throw new IllegalArgumentException(repr + " is not a valid mana representation");
        }
    }

    public static Set<Color> getColorsFromMana(Mana mana) {
        Set<Color> colors = new HashSet<>();
        if (mana != null && !mana.getRepr().equals("0")) {
            String coloredPart = mana.getColoredPart();
            for (int i = 0; i < coloredPart.length(); i++) {
                char colorCharacter = coloredPart.charAt(i);
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

    public String getColorlessPart() {
        return this.colorlessPart;
    }

    public String getColoredPart() {
        return this.coloredPart;
    }

    public String getXs() {
        return this.xs;
    }

    public Mana getConvertedMana() {
        int totalCost = (colorlessPart.isEmpty()) ? 0 :Integer.parseInt(colorlessPart);
        if (!coloredPart.isEmpty()) {
            totalCost += coloredPart.length();
        }
        return new Mana(Integer.toString(totalCost));
    }

    @Override
    public int hashCode() {
        return repr.hashCode();
    }

    @Override
    public boolean equals(Object other) {
        if (other == null) {
            return false;
        }
        try {
            Mana otherMana = (Mana) other;
            return repr.equals(otherMana.getRepr());
        } catch (ClassCastException e) {
            return false;
        }
    }

    @Override
    public String toString() {
        return repr;
    }

    public String getRepr() {
        return repr;
    }
}
