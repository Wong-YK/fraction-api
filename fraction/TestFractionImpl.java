package fraction;

import org.junit.Test;
import static org.junit.Assert.*;

public class TestFractionImpl {

    @Test
    public void greatestCommonDenominatorTest1() {
        int actual = FractionImpl.greatestCommonDenominator(9, 3);
        int expected = 3;
        assertEquals(expected, actual);
    }

    @Test
    public void greatestCommonDenominatorTest2() {
        int actual = FractionImpl.greatestCommonDenominator(80, 64);
        int expected = 16;
        assertEquals(expected, actual);
    }

    @Test (expected = ArithmeticException.class)
    public void greatestCommonDenominatorTest3() {
        int gcd = FractionImpl.greatestCommonDenominator(0, 61);
    }

    @Test (expected = ArithmeticException.class)
    public void greatestCommonDenominator() {
        int gcd = FractionImpl.greatestCommonDenominator(10, 0);
    }

    @Test
    public void stringToNumeratorTest1() {
        int actual = FractionImpl.stringToNumerator("11/2");
        int expected = 11;
        assertEquals(expected, actual);
    }

    @Test
    public void stringToNumeratorTest2() {
        int actual = FractionImpl.stringToNumerator(" 2 / 12");
        int expected = 2;
        assertEquals(expected, actual);
    }

    @Test
    public void stringToDenominatorTest1() {
        int actual = FractionImpl.stringToDenominator("3/15");
        int expected = 15;
        assertEquals(expected, actual);
    }

    @Test
    public void addTest1() {
        FractionImpl f1 = new FractionImpl(1, 10);
        FractionImpl f2 = new FractionImpl(3, 15);
        FractionImpl actual = (FractionImpl) f1.add(f2);
        FractionImpl expected = new FractionImpl(3, 10);
        assertTrue(actual.equals(expected));
    }

    @Test
    public void subtractTest1() {
        FractionImpl f1 = new FractionImpl(1, 2);
        FractionImpl f2 = new FractionImpl(1, 8);
        FractionImpl actual = (FractionImpl) f1.subtract(f2);
        FractionImpl expected = new FractionImpl(3, 8);
        assertTrue(actual.equals(expected));
    }

    @Test
    public void multiplyTest1() {
        FractionImpl f1 = new FractionImpl(3, 5);
        FractionImpl f2 = new FractionImpl(2, 16);
        FractionImpl actual = (FractionImpl) f1.multiply(f2);
        FractionImpl expected = new FractionImpl(3, 40);
        assertTrue(actual.equals(expected));
    }

    @Test
    public void divideTest1() {
        FractionImpl f1 = new FractionImpl(1, 3);
        FractionImpl f2 = new FractionImpl(2, 3);
        FractionImpl actual = (FractionImpl) f1.divide(f2);
        FractionImpl expected = new FractionImpl(1, 2);
        assertTrue(actual.equals(expected));
    }

    @Test
    public void equalsTest1() {
        FractionImpl f1 = new FractionImpl(2, 5);
        FractionImpl f2 = new FractionImpl(2, 5);
        assertTrue(f1.equals(f2));
    }

    @Test
    public void equalsTest2() {
        FractionImpl f1 = new FractionImpl(1, 8);
        FractionImpl f2 = new FractionImpl(8, 64);
        assertTrue(f1.equals(f2));
    }
}