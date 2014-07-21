package kim.ian.yams;

import org.junit.Assert;
import org.junit.Test;

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
}
