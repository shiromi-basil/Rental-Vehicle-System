import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

import java.math.BigDecimal;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class ManagerConsoleTest {

    private ManagerConsole managerConsole;

    @BeforeEach
    void beforeEach() {
        managerConsole = new ManagerConsole();
    }

    @Nested
    class IsIntValidTest {
        @Test
        void testEqualsZero() {
            assertFalse(managerConsole.isIntValid(0));
        }

        @Test
        void testEnterLessThanZero() {
            assertFalse(managerConsole.isIntValid(-1));
        }

        @Test
        void testEnterGreaterThanZero() {
            assertTrue(managerConsole.isIntValid(1));
        }
    }

    @Nested
    class IsBigDecimalValidTest {
        @Test
        void testEqualsZero() {
            assertFalse(managerConsole.isBigDecimalValid(new BigDecimal(0)));
        }

        @Test
        void testEnterLessThanZero() {
            assertFalse(managerConsole.isBigDecimalValid(new BigDecimal(-1)));
        }

        @Test
        void testEnterGreaterThanZeroInt() {
            assertTrue(managerConsole.isBigDecimalValid(new BigDecimal(1)));
        }

        @Test
        void testEnterGreaterThanZeroDouble() {
            assertTrue(managerConsole.isBigDecimalValid(new BigDecimal(1.5)));
        }
    }

    @Nested
    class IsBooleanValidTest {
        @Test
        void testEnterOtherString() {
            assertFalse(managerConsole.isBooleanValid("String"));
        }

        @Test
        void testEnterTrue() {
            assertTrue(managerConsole.isBooleanValid("true"));
        }

        @Test
        void testEnterFalse() {
            assertTrue(managerConsole.isBooleanValid("false"));
        }
    }

    @Nested
    class IsStringValidTest {
        @Test
        void testEnterNonAlphanumeric() {
            assertFalse(managerConsole.isStringValid("Shiromi_test"));
        }

        @Test
        void testEnterNumeric() {
            assertFalse(managerConsole.isStringValid("123"));
        }

        @Test
        void testEnterAlpha() {
            assertTrue(managerConsole.isStringValid("Shiromi"));
        }

        @Test
        void testEnterAlphanumeric() {
            assertTrue(managerConsole.isStringValid("Shiromi123"));
        }
    }

    @Nested
    class IsContactStringValidTest {
        @Test
        void testEnterNonAlphanumeric() {
            assertFalse(managerConsole.isContactStringValid("Shiromi_"));
        }

        @Test
        void testEnterAlpha() {
            assertFalse(managerConsole.isContactStringValid("Shiromi"));
        }

        @Test
        void testEnterNumericLessThan10Digits() {
            assertFalse(managerConsole.isContactStringValid("123"));
        }

        @Test
        void testEnterNumericLess10Digits() {
            assertTrue(managerConsole.isContactStringValid("1234567899"));
        }
    }

    @Nested
    class IsDoubleValidTest {
        @Test
        void testEqualsZero() {
            assertFalse(managerConsole.isDoubleValid(0));
        }

        @Test
        void testEnterLessThanZero() {
            assertFalse(managerConsole.isDoubleValid(-1));
        }

        @Test
        void testEnterGreaterThanZeroInt() {
            assertTrue(managerConsole.isDoubleValid(1));
        }

        @Test
        void testEnterGreaterThanZeroDouble() {
            assertTrue(managerConsole.isDoubleValid(1.5));
        }
    }
}
