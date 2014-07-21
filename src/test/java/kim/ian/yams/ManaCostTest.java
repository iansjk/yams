package kim.ian.yams;

import kim.ian.yams.ManaCost;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;

@RunWith(JUnit4.class)
public class ManaCostTest {
    private static final String[] validCosts = {
            "0", "1", "500",
            "X", "XX", "XXX",
            "WUBRG",
            "5WUB",
            "90RG",
    };
    private static final String[] invalidCosts = {
            "01", "0W", "0X",
            "XW",
            "GRBUW",
    };

    @Test
    public void testConstructorWithInvalidRepr() {
        for (String s: invalidCosts) {
            try {
                new ManaCost(s);
                Assert.fail(s + " was an invalid cost but no IllegalArgumentException was raised");
            } catch (IllegalArgumentException e) {
                // expected
            }
        }
    }

    @Test
    public void testIsReprValid() {
        for (String s: validCosts) {
            Assert.assertTrue(s + " should be valid but was marked invalid", ManaCost.isReprValid(s));
        }
        for (String s: invalidCosts) {
            Assert.assertFalse(s + " should be invalid but was marked valid", ManaCost.isReprValid(s));
        }
    }
}
