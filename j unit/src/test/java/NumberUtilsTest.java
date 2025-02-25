import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

public class NumberUtilsTest {

    @ParameterizedTest
    @ValueSource(ints = {2, 4, 6, 8, 10}) // Even numbers
    public void testIsEven_WithEvenNumbers_ShouldReturnTrue(int number) {
        assertTrue(NumberUtils.isEven(number), number + " should be even");
    }

    @ParameterizedTest
    @ValueSource(ints = {1, 3, 5, 7, 9}) // Odd numbers
    public void testIsEven_WithOddNumbers_ShouldReturnFalse(int number) {
        assertFalse(NumberUtils.isEven(number), number + " should be odd");
    }
}
