package fraction;

public class FractionImpl implements Fraction {
    /**
     * Parameters are the <em>numerator</em> and the <em>denominator</em>.
     * Normalize the fraction as you create it.
     * For instance, if the parameters are <pre>(8, -12)</pre>, create a <pre>Fraction</pre> with numerator
     * <pre>-2</pre> and denominator <pre>3</pre>.
     *
     * The constructor should throw an <pre>ArithmeticException</pre> if the denominator is zero.
     *
     * @param numerator
     * @param denominator
     */
    //TODO change these variables back to private
    private int num;
    private int denom;

    public FractionImpl(int numerator, int denominator) {
        if (denominator==0) {
            throw new ArithmeticException("Denominator must be a non-zero value");
        }
        else if (denominator<0) {
            numerator*=-1;
            denominator*=-1;
        }
        int gcd = greatestCommonDenominator(numerator, denominator);
        this.num = numerator/gcd;
        this.denom = denominator/gcd;
    }

    /**
     * The parameter is the numerator and <pre>1</pre> is the implicit denominator.
     *
     * @param wholeNumber representing the numerator
     */
    public FractionImpl(int wholeNumber) {
        this.num = wholeNumber;
        this.denom = 1;
    }

    /**
     * The parameter is a <pre>String</pre> containing either a whole number, such as `5` or `-3`, or a fraction,
     * such as "8/-12".
     * Allow blanks around (but not within) integers.
     * The constructor should throw an <pre>ArithmeticException</pre>
     * if given a string representing a fraction whose denominator is zero.
     * <p>
     * You may find it helpful to look at the available String API methods in the Java API.
     *
     * @param fraction the string representation of the fraction
     */
    public FractionImpl(String fraction) {
        int num;
        int denom;
        if (fraction.contains("/")) {
            num = stringToNumerator(fraction);
            denom = stringToDenominator(fraction);
        }
        else {
            num = Integer.parseInt(fraction.trim());
            denom = 1;
        }
        new FractionImpl(num,denom);
    }

    /**
     * @inheritDoc
     */
    @Override
    public Fraction add(Fraction f) {
        int numerator = (this.num * ((FractionImpl) f).denom) + (((FractionImpl) f).num * this.denom);
        int denominator = this.denom * ((FractionImpl) f).denom;
        return new FractionImpl(numerator, denominator);
    }

    /**
     * @inheritDoc
     */
    @Override
    public Fraction subtract(Fraction f) {
        return null;
    }

    /**
     * @inheritDoc
     */
    @Override
    public Fraction multiply(Fraction f) {
        return null;
    }

    /**
     * @inheritDoc
     */
    @Override
    public Fraction divide(Fraction f) {
        return null;
    }

    /**
     * @inheritDoc
     */
    @Override
    public Fraction abs() {
        return null;
    }

    /**
     * @inheritDoc
     */
    @Override
    public Fraction negate() {
        return null;
    }

    /**
     * @inheritDoc
     */
    @Override
    public int hashCode() {
        return super.hashCode();
    }

    /**
     * @inheritDoc
     */
    @Override
    public boolean equals(Object obj) {
        FractionImpl f1 = (FractionImpl) obj;
        return this.num==f1.num && this.denom==f1.denom;
    }

    /**
     * @inheritDoc
     */
    @Override
    protected Object clone() throws CloneNotSupportedException {
        return super.clone();
    }

    /**
     * @inheritDoc
     */
    @Override
    public Fraction inverse() {
        return null;
    }

    /**
     * @inheritDoc
     */
    @Override
    public int compareTo(Fraction o) {
        return 0;
    }

    /**
     * @inheritDoc
     */
    @Override
    public String toString() {
        return null;
    }

    public static int greatestCommonDenominator(int i, int j) {
        if (i==0 || j==0) {
            throw new ArithmeticException("GCD algorithm accepts only non-zero inputs");
        }
        while (i!=0 && j!=0) {
            if (i>j) {
                i%=j;
            }
            else {
                j%=i;
            }
        }
        if (i!=0) {
            return i;
        }
        else {
            return j;
        }
    }

    public static int stringToNumerator(String s) {
        int divisionIndex = s.indexOf('/');
        char[] arr = s.toCharArray();
        String numString = "";
        for (int i = 0; i<divisionIndex; i++) {
            numString+=arr[i];
        }
        numString = numString.trim();
        int result = Integer.parseInt(numString);
        return result;
    }

    public static int stringToDenominator(String s) {
        int divisionIndex = s.indexOf('/');
        char[] arr = s.toCharArray();
        String denomString = "";
        for (int i = divisionIndex+1; i<arr.length; i++) {
            denomString+=arr[i];
        }
        denomString = denomString.trim();
        int result = Integer.parseInt(denomString);
        return result;
    }



}