import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Tags;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

class CalculatorTestTags {

    Calculator calculator = new Calculator();

    @Test
    @Tag("firstPriority")
    void testAdd() {
        assertEquals(5, calculator.add(2, 3));
    }

    @Test
    @Tag("fastTag")
    void testSubtract() {
        assertEquals(1, calculator.subtract(3, 2));
    }

    @Test
    @Tags({ @Tag("firstPriority"), @Tag("fastTag") })
    void testMultiply() {
        assertEquals(6, calculator.multiply(2, 3));
    }

    @Test
    @Tag("slowTag")
    void testDivide() {
        assertEquals(2, calculator.divide(6, 3));
    }

    @Test
    @Tag("firstPriority")
    void testDivideByZero() {
        Exception exception = assertThrows(IllegalArgumentException.class, () -> {
            calculator.divide(5, 0);
        });
        assertEquals("Cannot divide by zero", exception.getMessage());
    }
}
