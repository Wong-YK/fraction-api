package fraction;

import org.junit.Test;
import static org.junit.Assert.*;

public class TestFractionImpl {

    /*
    Commented out tests below run and pass when the helper methods they test
    are switched to public. They have been commented out since
    these methods have now been switched to private
    */

    // i and j are both positive numbers
    @Test
    public void greatestCommonDenominatorTest1() {
        int actual = FractionImpl.greatestCommonDenominator(80, 64);
        int expected = 16;
        assertEquals(expected, actual);
    }

    // Throws an ArithmeticException when i = 0
    @Test (expected = ArithmeticException.class)
    public void greatestCommonDenominatorTest2() {
        int gcd = FractionImpl.greatestCommonDenominator(0, 61);
    }

    // Throws an ArithmeticException when j = 0
    @Test (expected = ArithmeticException.class)
    public void greatestCommonDenominatorTest3() {
        int gcd = FractionImpl.greatestCommonDenominator(61, 0);
    }

    // Throws an ArithmeticException when i= 0 and j = 0
    @Test (expected = ArithmeticException.class)
    public void greatestCommonDenominatorTest4() {
        int gcd = FractionImpl.greatestCommonDenominator(0, 0);
    }

    // i and j are negative
    @Test
    public void greatestCommonDenominatorTest5() {
        int actual = FractionImpl.greatestCommonDenominator(-10, -2);
        int expected = 2;
        assertEquals(expected, actual);
    }

    // i is negative and j is positive
    @Test
    public void greatestCommonDenominatorTest6() {
        int actual = FractionImpl.greatestCommonDenominator(-16, 4);
        int expected = 4;
        assertEquals(expected, actual);
    }

    // No leading or trailing spaces
    @Test
    public void stringToNumeratorTest1() {
        int actual = FractionImpl.stringToNumerator("11/2");
        int expected = 11;
        assertEquals(expected, actual);
    }

    // Leading and trailing spaces
    @Test
    public void stringToNumeratorTest2() {
        int actual = FractionImpl.stringToNumerator(" 2 / 12");
        int expected = 2;
        assertEquals(expected, actual);
    }

    // Negative numerator
    @Test
    public void stringToNumeratorTest3() {
        int actual = FractionImpl.stringToNumerator(" -2 / 12");
        int expected = -2;
        assertEquals(expected, actual);
    }

    // No leading or trailing spaces
    @Test
    public void stringToDenominatorTest1() {
        int actual = FractionImpl.stringToDenominator("3/15");
        int expected = 15;
        assertEquals(expected, actual);
    }

    // Leading and trailing spaces
    @Test
    public void stringToDenominatorTest2() {
        int actual = FractionImpl.stringToDenominator("33/ 7 ");
        int expected = 7;
        assertEquals(expected, actual);
    }

    // Negative denominator
    @Test
    public void stringToDenominatorTest3() {
        int actual = FractionImpl.stringToDenominator("33/ -7 ");
        int expected = -7;
        assertEquals(expected, actual);
    }

    // Constructor normalises fractions
    @Test
    public void FractionImpl1Test1() {
        FractionImpl actual = new FractionImpl(2, 4);
        FractionImpl expected = new FractionImpl(1, 2);
        assertEquals(expected, actual);
    }

    /*
     Negative fractions are represented as having a negative numerator
     and a positive denominator
     */
    @Test
    public void FractionImpl1Test2() {
        FractionImpl actual = new FractionImpl(3, -4);
        FractionImpl expected = new FractionImpl(-3, 4);
        assertEquals(expected, actual);
    }

    // 0 is represented as 0/1
    @Test
    public void FractionImpl1Test3() {
        FractionImpl actual = new FractionImpl(0, -4);
        FractionImpl expected = new FractionImpl(0, 1);
        assertEquals(expected, actual);
    }

    // Arithmetic exception is thrown when the denominator is 0
    @Test (expected = ArithmeticException.class)
    public void FractionImpl1Test4() {
        FractionImpl f = new FractionImpl(1, 0);
    }

    // Constructor normalises fractions
    @Test
    public void FractionImpl2Test1() {
        FractionImpl actual = new FractionImpl(5);
        FractionImpl expected = new FractionImpl(10, 2);
        assertEquals(expected, actual);
    }

    // 0 is represented as 0/1
    @Test
    public void FractionImpl2Test2() {
        FractionImpl actual = new FractionImpl(0);
        FractionImpl expected = new FractionImpl(0, 1);
        assertEquals(expected, actual);
    }

    // Constructor normalises fractions
    @Test
    public void FractionImpl3Test1() {
        FractionImpl actual = new FractionImpl("2/4");
        FractionImpl expected = new FractionImpl(1, 2);
        assertEquals(expected, actual);
    }

    /*
    Negative fractions are represented as having a negative numerator and a
    positive denominator
     */
    @Test
    public void FractionImpl3Test2() {
        FractionImpl actual = new FractionImpl("2/-4");
        FractionImpl expected = new FractionImpl(-1, 2);
        assertEquals(expected, actual);
    }

    // Arithmetic exception is thrown when the denominator is 0
    @Test (expected = ArithmeticException.class)
    public void FractionImpl3Test3() {
        FractionImpl f = new FractionImpl("3/0");
    }

    // Constructor can create fractions from a String representation of an integer
    @Test
    public void FractionImpl3Test4() {
        FractionImpl actual = new FractionImpl("-4");
        FractionImpl expected = new FractionImpl(-4, 1);
        assertEquals(expected, actual);
    }

    /*
    Constructor can handle spaces on either side of the string representation
    of the numerator or denominator
     */
    @Test
    public void FractionImpl3Test5() {
        FractionImpl actual = new FractionImpl("  3   /  4 ");
        FractionImpl expected = new FractionImpl(3, 4);
        assertEquals(expected, actual);
    }

    // Addition of two positive fractions
    @Test
    public void addTest1() {
        FractionImpl f1 = new FractionImpl(1, 10);
        FractionImpl f2 = new FractionImpl(3, 15);
        FractionImpl actual = (FractionImpl) f1.add(f2);
        FractionImpl expected = new FractionImpl(3, 10);
        assertEquals(expected, actual);
    }

    /*
     Addition using two fractions created using the constructor that takes
     a single int as an argument
     */
    @Test
    public void addTest2() {
        FractionImpl f1 = new FractionImpl(5);
        FractionImpl f2 = new FractionImpl(3);
        FractionImpl actual = (FractionImpl) f1.add(f2);
        FractionImpl expected = new FractionImpl(8, 1);
        assertEquals(expected, actual);
    }

    /*
    Addition of two fractions created using the constructor that
    takes a String as an argument
     */
    @Test
    public void addTest3() {
        FractionImpl f1 = new FractionImpl("2/6");
        FractionImpl f2 = new FractionImpl(" 3/7 ");
        FractionImpl actual = (FractionImpl) f1.add(f2);
        FractionImpl expected = new FractionImpl(16, 21);
        assertEquals(expected, actual);
    }

    // addition of a positive and negative fraction
    @Test
    public void addTest4() {
        FractionImpl f1 = new FractionImpl("5/6");
        FractionImpl f2 = new FractionImpl("4/-12");
        FractionImpl actual = (FractionImpl) f1.add(f2);
        FractionImpl expected = new FractionImpl(1, 2);
        assertEquals(expected, actual);
    }

    // Adding a fraction to the negative of that fraction
    @Test
    public void addTest5() {
        FractionImpl f1 = new FractionImpl(1, 10);
        FractionImpl f2 = new FractionImpl(-1, 10);
        FractionImpl actual = (FractionImpl) f1.add(f2);
        FractionImpl expected = new FractionImpl(0, 1);
        assertEquals(expected, actual);
    }

    // Adding zero to a fraction
    @Test
    public void addTest6() {
        FractionImpl f1 = new FractionImpl(1, 10);
        FractionImpl f2 = new FractionImpl(0, 10);
        FractionImpl actual = (FractionImpl) f1.add(f2);
        FractionImpl expected = new FractionImpl(1, 10);
        assertEquals(expected, actual);
    }

    /*
     Subtraction of two fractions, both created using the constructor
     that takes two int arguments
     */
    @Test
    public void subtractTest1() {
        FractionImpl f1 = new FractionImpl(1, 2);
        FractionImpl f2 = new FractionImpl(1, 8);
        FractionImpl actual = (FractionImpl) f1.subtract(f2);
        FractionImpl expected = new FractionImpl(3, 8);
        assertEquals(actual, expected);
    }


    /*
    Subtraction of a negative integer, created using the constructor that
    takes to int arguments, from a positive integer, created using
    the constructor that takes a String as an argument
     */
    @Test
    public void subtractTest2() {
        FractionImpl f1 = new FractionImpl("1/2 ");
        FractionImpl f2 = new FractionImpl(-1, 8);
        FractionImpl actual = (FractionImpl) f1.subtract(f2);
        FractionImpl expected = new FractionImpl(5, 8);
        assertEquals(expected, actual);
    }

    /*
     Subtraction of two fractions both created with the constructor that
     takes a single int as an argument
     */
    @Test
    public void subtractTest3() {
        FractionImpl f1 = new FractionImpl(6);
        FractionImpl f2 = new FractionImpl(3);
        FractionImpl actual = (FractionImpl) f1.subtract(f2);
        FractionImpl expected = new FractionImpl(3);
        assertEquals(expected, actual);
    }

    // Subtraction of two negative fractions
    @Test
    public void subtractTest4() {
        FractionImpl f1 = new FractionImpl("-2/4");
        FractionImpl f2 = new FractionImpl(-3, 4);
        FractionImpl actual = (FractionImpl) f1.subtract(f2);
        FractionImpl expected = new FractionImpl(1, 4);
        assertEquals(expected, actual);
    }

    // Subtraction of 0 from a negative fraction
    @Test
    public void subtractTest5() {
        FractionImpl f1 = new FractionImpl("-2/4");
        FractionImpl f2 = new FractionImpl(0, 4);
        FractionImpl actual = (FractionImpl) f1.subtract(f2);
        FractionImpl expected = new FractionImpl(-1, 2);
        assertEquals(expected, actual);
    }

    // Multiplication of two positive fractions
    @Test
    public void multiplyTest1() {
        FractionImpl f1 = new FractionImpl(3, 5);
        FractionImpl f2 = new FractionImpl(2, 16);
        FractionImpl actual = (FractionImpl) f1.multiply(f2);
        FractionImpl expected = new FractionImpl(3, 40);
        assertEquals(actual, expected);
    }

    // multiplication of a positive and negative fraction
    @Test
    public void multiplyTest2() {
        FractionImpl f1 = new FractionImpl("-3/ 5");
        FractionImpl f2 = new FractionImpl(2, 16);
        FractionImpl actual = (FractionImpl) f1.multiply(f2);
        FractionImpl expected = new FractionImpl(-3, 40);
        assertEquals(actual, expected);
    }

    // multiplication of two negative fractions
    @Test
    public void multiplyTest3() {
        FractionImpl f1 = new FractionImpl(-3);
        FractionImpl f2 = new FractionImpl("-2/16");
        FractionImpl actual = (FractionImpl) f1.multiply(f2);
        FractionImpl expected = new FractionImpl(3, 8);
        assertEquals(actual, expected);
    }

    // multiplication by 0
    @Test
    public void multiplyTest4() {
        FractionImpl f1 = new FractionImpl(-3);
        FractionImpl f2 = new FractionImpl(0, 4);
        FractionImpl actual = (FractionImpl) f1.multiply(f2);
        FractionImpl expected = new FractionImpl(0, 1);
        assertEquals(actual, expected);
    }

    // Division of two positive fractions
    @Test
    public void divideTest1() {
        FractionImpl f1 = new FractionImpl(1, 3);
        FractionImpl f2 = new FractionImpl(2, 3);
        FractionImpl actual = (FractionImpl) f1.divide(f2);
        FractionImpl expected = new FractionImpl(1, 2);
        assertEquals(expected, actual);
    }

    // division of a positive and negative fraction
    @Test
    public void divideTest2() {
        FractionImpl f1 = new FractionImpl("1/3");
        FractionImpl f2 = new FractionImpl(-2, 3);
        FractionImpl actual = (FractionImpl) f1.divide(f2);
        FractionImpl expected = new FractionImpl(-1, 2);
        assertEquals(expected, actual);
    }

    // division of two negative fractions
    @Test
    public void divideTest3() {
        FractionImpl f1 = new FractionImpl("-4/8");
        FractionImpl f2 = new FractionImpl(-3, 8);
        FractionImpl actual = (FractionImpl) f1.divide(f2);
        FractionImpl expected = new FractionImpl(4, 3);
        assertEquals(expected, actual);
    }

    // 0 divided by another fraction
    @Test
    public void divideTest4() {
        FractionImpl f1 = new FractionImpl(0);
        FractionImpl f2 = new FractionImpl("-3/8");
        FractionImpl actual = (FractionImpl) f1.divide(f2);
        FractionImpl expected = new FractionImpl(0, 1);
        assertEquals(expected, actual);
    }

    // Division by 0 throws an ArithmeticException
    @Test(expected = ArithmeticException.class)
    public void divideTest5() {
        FractionImpl f1 = new FractionImpl(6, 7);
        FractionImpl f2 = new FractionImpl(0);
        FractionImpl actual = (FractionImpl) f1.divide(f2);
    }

    // Absolute value of a negative fraction
    @Test
    public void absTest1() {
        FractionImpl f1 = new FractionImpl(-3,14);
        FractionImpl actual = (FractionImpl) f1.abs();
        FractionImpl expected = new FractionImpl(3, 14);
        assertTrue(actual.equals(expected));
    }

    // Absolute value of a positive fraction
    @Test
    public void absTest2() {
        FractionImpl f1 = new FractionImpl(3, 14);
        FractionImpl actual = (FractionImpl) f1.abs();
        FractionImpl expected = new FractionImpl(3, 14);
        assertTrue(actual.equals(expected));
    }

    // Absolute value of 0
    @Test
    public void absTest3() {
        FractionImpl f1 = new FractionImpl("0/ 14");
        FractionImpl actual = (FractionImpl) f1.abs();
        FractionImpl expected = new FractionImpl(0);
        assertEquals(expected, actual);
    }


    // Negation of a positive fraction
    @Test
    public void negateTest1() {
        FractionImpl f1 = new FractionImpl(2, 5);
        FractionImpl actual = (FractionImpl) f1.negate();
        FractionImpl expected = new FractionImpl(-2, 5);
        assertEquals(expected, actual);
    }

    //Negation of a negative fraction
    @Test
    public void negateTest2() {
        FractionImpl f1 = new FractionImpl("  -3    /5");
        FractionImpl actual = (FractionImpl) f1.negate();
        FractionImpl expected = new FractionImpl(3, 5);
        assertEquals(expected, actual);
    }

    //Negation of 0
    @Test
    public void negateTest3() {
        FractionImpl f1 = new FractionImpl("0");
        FractionImpl actual = (FractionImpl) f1.negate();
        FractionImpl expected = new FractionImpl(0, 1);
        assertEquals(expected, actual);
    }

    // Equal fractions return True
    @Test
    public void equalsTest1() {
        FractionImpl f1 = new FractionImpl(2, 5);
        FractionImpl f2 = new FractionImpl("4/ 10");
        assertTrue(f1.equals(f2));
    }

    // Fractions that are not equal do not return true
    @Test
    public void equalsTest2() {
        FractionImpl f1 = new FractionImpl(8);
        FractionImpl f2 = new FractionImpl("15/8");
        assertTrue(!f1.equals(f2));
    }

    /*
     The inverse of a positive fraction, numerator/denominator is equal to
     denominator/numerator
     */
    @Test
    public void inverseTest1() {
        FractionImpl f1 = new FractionImpl(2, 5);
        FractionImpl actual = (FractionImpl) f1.inverse();
        FractionImpl expected = new FractionImpl(5, 2);
        assertEquals(expected, actual);
    }

    /*
     The inverse of a negative fraction, -numerator/denominator is equal to
     -denominator/numerator
     */
    @Test
    public void inverseTest2() {
        FractionImpl f1 = new FractionImpl("-4 /3");
        FractionImpl actual = (FractionImpl) f1.inverse();
        FractionImpl expected = new FractionImpl(-3, 4);
        assertEquals(expected, actual);
    }

    /*
     The inverse of a negative fraction, -numerator/denominator is equal to
     -denominator/numerator
     */
    @Test (expected = ArithmeticException.class)
    public void inverseTest3() {
        FractionImpl f1 = new FractionImpl(0, 1);
        FractionImpl actual = (FractionImpl) f1.inverse();
    }

    // Comparing positive fractions
    @Test
    public void compareToTest1() {
        FractionImpl f1 = new FractionImpl(4, 5);
        FractionImpl f2 = new FractionImpl(1, 2);
        assertTrue(f1.compareTo(f2)>0);
    }

    // Comparing a positive and negative fraction
    @Test
    public void compareToTest2() {
        FractionImpl f1 = new FractionImpl(-4, 5);
        FractionImpl f2 = new FractionImpl(1, 2);
        assertTrue(f1.compareTo(f2)<0);
    }

    // Comparing negative fractions
    @Test
    public void compareToTest3() {
        FractionImpl f1 = new FractionImpl(4, -16);
        FractionImpl f2 = new FractionImpl(-1, 3);
        assertTrue(f1.compareTo(f2)>0);
    }

    // Comparing equal fractions
    @Test
    public void compareToTest4() {
        FractionImpl f1 = new FractionImpl(-3);
        FractionImpl f2 = new FractionImpl("-6/2");
        assertTrue(f1.compareTo(f2)==0);
    }

    // Denominator is 1
    @Test
    public void toStringTest1() {
        FractionImpl f = new FractionImpl(5, 1);
        String actual = f.toString();
        assertEquals("5", actual);
    }

    // Negative fraction
    @Test
    public void toStringTest2() {
        FractionImpl f = new FractionImpl(-2, 5);
        String actual = f.toString();
        assertEquals("-2/5", actual);
    }

    // Positive fraction
    @Test
    public void toStringTest3() {
        FractionImpl f = new FractionImpl("4/7");
        String actual = f.toString();
        assertEquals("4/7", actual);
    }

    public static void main(String[] args) {
        // a short program that uses the Fraction API
        Fraction f1 = new FractionImpl(4, 6);
        Fraction f2 = new FractionImpl(2);
        f2 = f2.negate();
        Fraction f3 = new FractionImpl("16  /  4  ");
        Fraction f4 = f1.add(f2).abs();
        f4 = f4.multiply(f3);
        System.out.println(f4);
        f4 = f4.inverse();
        Fraction f5 = f3.divide(f4);
        Fraction f6 = new FractionImpl(2);
        f5 = f5.subtract(f6);
        System.out.println(f5);
        if (!f4.equals(f5)) {
            String s = String.format("%s is not equal to %s", f4.toString(), f5.toString());
            System.out.println(s);
        }
        if (f4.compareTo(f5)<0) {
            String s = String.format("%s is less than %s", f4.toString(), f5.toString());
            System.out.println(s);
        }
    }

}