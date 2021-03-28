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
    public void greatestCommonDenominatorTest4() {
        int gcd = FractionImpl.greatestCommonDenominator(0, 61);
    }

    @Test (expected = ArithmeticException.class)
    public void greatestCommonDenominator() {
        int gcd = FractionImpl.greatestCommonDenominator(10, 0);
    }

    @Test
    public void greatestCommonDenominatorTest5() {
        int actual = FractionImpl.greatestCommonDenominator(-2, 6);
        int expected = 2;
        assertEquals(expected, actual);

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
    public void addTest2() {
        FractionImpl f1 = new FractionImpl(5);
        FractionImpl f2 = new FractionImpl(3);
        FractionImpl actual = (FractionImpl) f1.add(f2);
        FractionImpl expected = new FractionImpl(8, 1);
        assertEquals(expected, actual);
    }

    @Test
    public void addTest3() {
        FractionImpl f1 = new FractionImpl("2/6");
        FractionImpl f2 = new FractionImpl(" 3/7 ");
        FractionImpl actual = (FractionImpl) f1.add(f2);
        FractionImpl expected = new FractionImpl(16, 21);
        assertEquals(expected, actual);
    }

    @Test
    public void addTest4() {
        FractionImpl f1 = new FractionImpl("5/6");
        FractionImpl f2 = new FractionImpl("4/-12");
        FractionImpl actual = (FractionImpl) f1.add(f2);
        FractionImpl expected = new FractionImpl(1, 2);
        assertEquals(expected, actual);
    }

    @Test
    public void subtractTest1() {
        FractionImpl f1 = new FractionImpl(1, 2);
        FractionImpl f2 = new FractionImpl(1, 8);
        FractionImpl actual = (FractionImpl) f1.subtract(f2);
        FractionImpl expected = new FractionImpl(3, 8);
        assertEquals(actual, expected);
    }

    @Test
    public void subtractTest2() {
        FractionImpl f1 = new FractionImpl("1/2 ");
        FractionImpl f2 = new FractionImpl(-1, 8);
        FractionImpl actual = (FractionImpl) f1.subtract(f2);
        FractionImpl expected = new FractionImpl(5, 8);
        assertEquals(expected, actual);
    }

    @Test
    public void subtractTest3() {
        FractionImpl f1 = new FractionImpl(6);
        FractionImpl f2 = new FractionImpl(3);
        FractionImpl actual = (FractionImpl) f1.subtract(f2);
        FractionImpl expected = new FractionImpl(3);
        assertEquals(expected, actual);
    }

    @Test
    public void subtractTest4() {
        FractionImpl f1 = new FractionImpl("2/4");
        FractionImpl f2 = new FractionImpl(3, 4);
        FractionImpl actual = (FractionImpl) f1.subtract(f2);
        FractionImpl expected = new FractionImpl(-1, 4);
        assertEquals(expected, actual);
    }

    @Test
    public void multiplyTest1() {
        FractionImpl f1 = new FractionImpl(3, 5);
        FractionImpl f2 = new FractionImpl(2, 16);
        FractionImpl actual = (FractionImpl) f1.multiply(f2);
        FractionImpl expected = new FractionImpl(3, 40);
        assertEquals(actual, expected);
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
    public void absTest1() {
        FractionImpl f1 = new FractionImpl(-3,14);
        FractionImpl actual = (FractionImpl) f1.abs();
        FractionImpl expected = new FractionImpl(3, 14);
        assertTrue(actual.equals(expected));
    }

    @Test
    public void absTest2() {
        FractionImpl f1 = new FractionImpl(3, 14);
        FractionImpl actual = (FractionImpl) f1.abs();
        FractionImpl expected = new FractionImpl(3, 14);
        assertTrue(actual.equals(expected));
    }


    @Test
    public void negateTest1() {
        FractionImpl f1 = new FractionImpl(2, 5);
        FractionImpl actual = (FractionImpl) f1.negate();
        FractionImpl expected = new FractionImpl(-2, 5);
        assertTrue(actual.equals(expected));
    }

    @Test
    public void negateTest2() {
        FractionImpl f1 = new FractionImpl(-3, 5);
        FractionImpl actual = (FractionImpl) f1.negate();
        FractionImpl expected = new FractionImpl(3, 5);
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

    @Test
    public void inverseTest1() {
        FractionImpl f1 = new FractionImpl(2, 5);
        FractionImpl actual = (FractionImpl) f1.inverse();
        FractionImpl expected = new FractionImpl(5, 2);
        assertEquals(expected, actual);
    }

    @Test
    public void compareToTest1() {
        FractionImpl f1 = new FractionImpl(4, 5);
        FractionImpl f2 = new FractionImpl(1, 2);
        assertEquals(1, f1.compareTo(f2));
    }

    @Test
    public void compareToTest2() {
        FractionImpl f1 = new FractionImpl(-4, 5);
        FractionImpl f2 = new FractionImpl(1, 2);
        assertEquals(-1, f1.compareTo(f2));
    }

    @Test
    public void compareToTest3() {
        FractionImpl f1 = new FractionImpl(4, -16);
        FractionImpl f2 = new FractionImpl(-1, 4);
        assertEquals(0, f1.compareTo(f2));
    }

    @Test
    public void toStringTest1() {
        FractionImpl f = new FractionImpl(5, 1);
        String actual = f.toString();
        assertEquals("5", actual);
    }

    @Test
    public void toStringTest2() {
        FractionImpl f = new FractionImpl(-2, 5);
        String actual = f.toString();
        assertEquals("-2/5", actual);
    }

}