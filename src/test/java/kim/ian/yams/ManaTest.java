package kim.ian.yams;

import kim.ian.yams.cardtypes.Color;
import org.junit.Test;

import java.util.Set;

import static org.junit.Assert.*;

public class ManaTest {
    private static final String[] validReprs = {
            "0", "1", "500",
            "X", "XX", "XXX",
            "WUBRG",
            "5WUB",
            "90RG",
    };
    private static final String[] invalidReprs = {
            "01", "0W", "0X",
            "XW",
            "GRBUW",
            "w", "u", "b", "r", "g", "WuBrG", "wUbRg",
            "x", "xx", "xxx",
    };
    private static final String[] colorCombinations = {
            "W", "U", "B", "R", "G",
            "WU", "UB", "BR", "RG",
            "WUB", "BRG",
            "WUBRG",
    };

    @Test
    public void testConstructorWithInvalidRepr() {
        for (String s : validReprs) {
            try {
                new Mana(s);
            } catch (IllegalArgumentException e) {
                fail(s + " was a valid repr but IllegalArgumentException was raised");
            }
        }

        for (String s : invalidReprs) {
            try {
                new Mana(s);
                fail(s + " was an invalid repr but no IllegalArgumentException was raised");
            } catch (IllegalArgumentException e) {
                // expected
            }
        }
    }

    @Test
    public void testEquals() {
        // reflexivity
        for (String s : validReprs) {
            assertEquals(new Mana(s), new Mana(s));
        }

        // transitivity
        Mana x = new Mana("10");
        Mana y = new Mana("10");
        Mana z = new Mana("10");
        assertEquals(x, y);
        assertEquals(y, z);
        assertEquals(x, z);

        // symmetry
        assertEquals(x, y);
        assertEquals(y, x);

        // null = false
        assertNotEquals(new Mana("0"), null);

        // class of type other than Mana = false
        assertNotEquals(new Mana("0"), new String());
        assertNotEquals(new Mana("0"), new Integer(0));
    }

    @Test
    public void testGetColorsFromMana() {
        // null should return empty set
        assertTrue(Mana.getColorsFromMana(null).isEmpty());

        // colorless should be an empty set
        for (int i = 0; i <= 10; i++) {
            assertTrue(Mana.getColorsFromMana(new Mana(Integer.toString(i))).isEmpty());
        }

        for (String combination : colorCombinations) {
            Set<Color> result = Mana.getColorsFromMana(new Mana(combination));
            assertEquals(combination.length(), result.size());
            for (int i = 0; i < combination.length(); i++) {
                char color = combination.charAt(i);
                switch (color) {
                    case 'W':
                        assertTrue(result.contains(Color.White));
                        break;
                    case 'U':
                        assertTrue(result.contains(Color.Blue));
                        break;
                    case 'B':
                        assertTrue(result.contains(Color.Black));
                        break;
                    case 'R':
                        assertTrue(result.contains(Color.Red));
                        break;
                    case 'G':
                        assertTrue(result.contains(Color.Green));
                        break;
                }
            }
        }
    }

    @Test
    public void testGetConvertedMana() {
        for (int i = 0; i <= 10; i++) {
            assertEquals(new Mana(Integer.toString(i)), new Mana(Integer.toString(i)).getConvertedMana());
        }

        // color combinations return length
        for (String combination : colorCombinations) {
            assertEquals(new Mana(Integer.toString(combination.length())), new Mana(combination).getConvertedMana());
        }

        // {X} is always {0} CMC
        String[] xs = {"X", "XX", "XXX"};
        for (String x : xs) {
            assertEquals(new Mana("0"), new Mana(x).getConvertedMana());
        }

        // all together now:
        String allCombined = "15WUBRGXXX";  // should return {20}
        assertEquals(new Mana("20"), new Mana(allCombined).getConvertedMana());
    }

    @Test
    public void testManaParts() {
        Mana allCombined = new Mana("15WUBRGXXX");
        assertEquals("15", allCombined.getColorlessPart());
        assertEquals("WUBRG", allCombined.getColoredPart());
        assertEquals("XXX", allCombined.getXs());
    }

    @Test
    public void testGetColorlessPart() {
        for (int i = 0; i <= 10; i++) {
            Mana m = new Mana(Integer.toString(i));
            assertEquals(m.getRepr(), m.getColorlessPart());
            assertEquals("", m.getColoredPart());
            assertEquals("", m.getXs());
        }
    }

    @Test
    public void testGetColoredPart() {
        for (String combination : colorCombinations) {
            Mana m = new Mana(combination);
            assertEquals(m.getRepr(), m.getColoredPart());
            assertEquals("", m.getColorlessPart());
            assertEquals("", m.getXs());
        }
    }

    @Test
    public void testGetXs() {
        for (int i = 0; i < 3; i++) {
            String manaRepr = "X";
            for (int j = 0; j < i; j++) {
                manaRepr += "X";
            }
            Mana m = new Mana(manaRepr);
            assertEquals(manaRepr, m.getXs());
            assertEquals("", m.getColorlessPart());
            assertEquals("", m.getColoredPart());
        }
    }
}
