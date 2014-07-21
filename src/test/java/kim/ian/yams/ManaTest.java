package kim.ian.yams;

import kim.ian.yams.cardtypes.Color;
import org.junit.Assert;
import org.junit.Test;

import java.util.Set;

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
    };

    @Test
    public void testConstructorWithInvalidRepr() {
        for (String s: invalidReprs) {
            try {
                new Mana(s);
                Assert.fail(s + " was an invalid repr but no IllegalArgumentException was raised");
            } catch (IllegalArgumentException e) {
                // expected
            }
        }
    }

    @Test
    public void testIsReprValid() {
        for (String s: validReprs) {
            Assert.assertTrue(s + " should be valid but was marked invalid", Mana.isReprValid(s));
        }
        for (String s: invalidReprs) {
            Assert.assertFalse(s + " should be invalid but was marked valid", Mana.isReprValid(s));
        }
    }

    @Test
    public void testEquals() {
        // null constructor should always be equal to {0}
        Assert.assertEquals(new Mana(), new Mana("0"));

        // reflexivity
        for (String s : validReprs) {
            Assert.assertEquals(new Mana(s), new Mana(s));
        }

        // transitivity
        Mana x = new Mana("10");
        Mana y = new Mana("10");
        Mana z = new Mana("10");
        Assert.assertEquals(x, y);
        Assert.assertEquals(y, z);
        Assert.assertEquals(x, z);

        // symmetry
        Assert.assertEquals(x, y);
        Assert.assertEquals(y, x);

        // null = false
        Assert.assertNotEquals(new Mana(), null);

        // class of type other than Mana = false
        Assert.assertNotEquals(new Mana(), new String());
        Assert.assertNotEquals(new Mana(), new Integer(0));
    }

    @Test
    public void testGetColorsFromMana() {
        // null should return empty set
        Assert.assertTrue(Mana.getColorsFromMana(null).isEmpty());

        // colorless should be an empty set
        Assert.assertTrue(Mana.getColorsFromMana(new Mana()).isEmpty());
        for (int i = 0; i <= 10; i++) {
            Assert.assertTrue(Mana.getColorsFromMana(new Mana(Integer.toString(i))).isEmpty());
        }

        String[] colorCombinations = {
                "W", "U", "B", "R", "G",
                "WU", "UB", "BR", "RG",
                "WUB", "BRG",
                "WUBRG",
        };
        for (String combination : colorCombinations) {
            Set<Color> result = Mana.getColorsFromMana(new Mana(combination));
            Assert.assertEquals(result.size(), combination.length());
            for (int i = 0; i < combination.length(); i++) {
                char color = combination.charAt(i);
                switch (color) {
                    case 'W':
                        Assert.assertTrue(result.contains(Color.White));
                        break;
                    case 'U':
                        Assert.assertTrue(result.contains(Color.Blue));
                        break;
                    case 'B':
                        Assert.assertTrue(result.contains(Color.Black));
                        break;
                    case 'R':
                        Assert.assertTrue(result.contains(Color.Red));
                        break;
                    case 'G':
                        Assert.assertTrue(result.contains(Color.Green));
                        break;
                }
            }
        }
    }
}
