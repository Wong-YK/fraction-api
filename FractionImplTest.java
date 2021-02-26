package fraction;

import org.junit.Test;
import static org.junit.Assert.*;

public class FractionImplTest {

    @Test
    public void greatestCommonDivisorTest() {
        assertEquals(3, FractionImpl.greatestCommonDivisor(3, 9));
        assertEquals(1, FractionImpl.greatestCommonDivisor(4, 17));
        assertEquals(12, FractionImpl.greatestCommonDivisor(12, 144));
    }
}
