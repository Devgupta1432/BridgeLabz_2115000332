import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class DivisionTest {
    private final Division division = new Division();

    @Test
    public void testDivideByZero() {
        Exception exception = assertThrows(ArithmeticException.class, () -> division.divide(10, 0));
        assertEquals("Cannot divide by zero", exception.getMessage());
    }

    @Test
    public void testValidDivision() {
        assertEquals(5, division.divide(10, 2));
    }
}
