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
    private int numerator;
    private int denominator;

    public FractionImpl(int numerator, int denominator) {
        if (denominator==0) {
            throw new ArithmeticException("Denominator must be a non-zero value");
        }
        else if (denominator<0) {
            numerator*=-1;
            denominator*=-1;
        }
        if (numerator==0) {
            this.numerator=0;
            this.denominator=1;
        }
        else {
            int gcd = greatestCommonDenominator(numerator, denominator);
            this.numerator = numerator/gcd;
            this.denominator = denominator/gcd;
        }
    }

    /**
     * The parameter is the numerator and <pre>1</pre> is the implicit denominator.
     *
     * @param wholeNumber representing the numerator
     */
    public FractionImpl(int wholeNumber) {
        FractionImpl f = new FractionImpl(wholeNumber, 1);
        this.numerator = f.numerator;
        this.denominator = f.denominator;
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
        FractionImpl f = new FractionImpl(num,denom);
        this.numerator = f.numerator;
        this.denominator = f.denominator;
    }

    /**
     * @inheritDoc
     */
    @Override
    public Fraction add(Fraction f) {
        FractionImpl f1 = (FractionImpl) f;
        int numerator = (this.numerator * f1.denominator) + (f1.numerator * this.denominator);
        int denominator = this.denominator * ((FractionImpl) f).denominator;
        return new FractionImpl(numerator, denominator);
    }

    /**
     * @inheritDoc
     */
    @Override
    public Fraction subtract(Fraction f) {
        FractionImpl f1 = (FractionImpl) f;
        int numerator = (this.numerator * f1.denominator) - (f1.numerator * this.denominator);
        int denominator = this.denominator * f1.denominator;
        return new FractionImpl(numerator, denominator);
    }

    /**
     * @inheritDoc
     */
    @Override
    public Fraction multiply(Fraction f) {
        FractionImpl f1 = (FractionImpl) f;
        numerator = this.numerator * f1.numerator;
        denominator = this.denominator * f1.denominator;
        return new FractionImpl(numerator, denominator);
    }

    /**
     * @inheritDoc
     */
    @Override
    public Fraction divide(Fraction f) {
        FractionImpl f1 = (FractionImpl) f;
        numerator = this.numerator * f1.denominator;
        denominator = this.denominator * f1.numerator;
        return new FractionImpl(numerator, denominator);
    }

    /**
     * @inheritDoc
     */
    @Override
    public Fraction abs() {
        if (this.numerator<0) {
            int numerator = this.numerator * -1;
            return new FractionImpl(numerator, this.denominator);
        }
        else {
            return this;
        }
    }

    /**
     * @inheritDoc
     */
    @Override
    public Fraction negate() {
        int numerator = this.numerator*-1;
        return new FractionImpl(numerator, this.denominator);
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
        if (!(obj instanceof FractionImpl)) {
            return false;
        }
        FractionImpl f1 = (FractionImpl) obj;
        return this.numerator==f1.numerator && this.denominator==f1.denominator;
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
        int numerator = this.denominator;
        int denominator = this.numerator;
        return new FractionImpl(numerator, denominator);
    }

    /**
     * @inheritDoc
     */
    @Override
    public int compareTo(Fraction o) {
        FractionImpl f1 = (FractionImpl) o;
        int num1 = this.numerator * f1.denominator;
        int num2 = f1.numerator * this.denominator;
        if (num1>num2) {
            return 1;
        }
        else if (num2>num1) {
            return -1;
        }
        else {
            return 0;
        }
    }

    /**
     * @inheritDoc
     */
    @Override
    public String toString() {
        if (this.denominator==1) {
            return "" + this.numerator;
        }
        else {
            return String.format("%d/%d", this.numerator, this.denominator);
        }
    }

    // TODO verify that this solution works for negative numbers (i.e. just calulating GCD for their abs values)
    public static int greatestCommonDenominator(int i, int j) {
        if (i<0) i*=-1;
        if (j<0) j*=-1;
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