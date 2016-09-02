/**
 *
 * @author Sid
 * @version 0.1
 * @see java.lang.Comparable
 * Created by user-2 on 31/8/16.
 */
public class Rational extends Number implements Comparable<Rational> {
    private long numerator;
    private long denominator;

    public Rational(){
        this.numerator = 10L;
        this.denominator = -12L;
    }

    public Rational(long numerator, long denominator) {
        this.numerator = numerator;
        if(denominator==0) throw  new IllegalArgumentException("denominator should not be zero");
        this.denominator = denominator;
    }

    public long getNumerator() {
        return numerator;
    }

    public long getDenominator() {
        return denominator;
    }

    @Override
    public int intValue() {
        return (int)this.numerator/(int)this.denominator;
    }

    @Override
    public long longValue() {
        return  this.numerator/this.denominator;
    }

    @Override
    public float floatValue() {
        return (float)this.numerator/(float)this.denominator;
    }

    @Override
    public double doubleValue() {
        return (double)this.numerator/(double)this.denominator;
    }

    @Override
    public int compareTo(Rational o) {
        if(o==null){
            throw  new NullPointerException("Null object");
        }
        if(!(o instanceof  Rational)){
            throw new IllegalArgumentException("Invaild argument type");
        }
        if(this.doubleValue()>o.doubleValue()){
            return 1;
        }
        else {
            if (this.doubleValue()<o.doubleValue()){
                return -1;
            }
            else
            {
                return 0;
            }
        }
    }

    @Override
    public String toString() {
        this.reduceToSimplestForm();
        if(this.denominator==1) {
            return Long.toString(this.numerator);
        }else
            return this.numerator + "/" + this.denominator;

    }

    public Rational add(Rational secondRational){
        Rational additionResult = new Rational(1l,1l);
        additionResult.numerator = ((this.numerator * secondRational.denominator) + (this.denominator*secondRational.numerator));
        additionResult.denominator = this.denominator * secondRational.denominator;
        additionResult.reduceToSimplestForm();
        return additionResult;
    }

    public Rational subtract(Rational secondRational){
        Rational subtractionResult = new Rational(1l,1l);
        subtractionResult.numerator = ((this.numerator * secondRational.denominator) - (this.denominator*secondRational.numerator));
        subtractionResult.denominator = this.denominator * secondRational.denominator;
        subtractionResult.reduceToSimplestForm();
        return subtractionResult;
    }

    public Rational multiply(Rational secondRational){
        Rational multiplicationResult = new Rational(1l,1l);
        multiplicationResult.numerator = this.numerator * secondRational.numerator ;
        multiplicationResult.denominator = this.denominator * secondRational.denominator;
        multiplicationResult.reduceToSimplestForm();
        return  multiplicationResult;
    }

    public Rational divide(Rational secondRational){
        Rational divisionResult = new Rational(1l,1l);
        divisionResult.numerator = this.numerator * secondRational.denominator;
        divisionResult.denominator = this.denominator * secondRational.numerator;
        divisionResult.reduceToSimplestForm();
        return divisionResult;
    }


    /**  Calculates gcd of two rational numbers
    *
    * @param numerator : first number
     *@param denominator : second number
    * @return long
    */
    @TestMe
    private  long gcd (long numerator , long denominator){
        if(denominator == 0){
            return numerator;
        }
        return gcd(denominator, numerator%denominator);
    }

    /**  Reduce rational number to simplest form
     *
     */
    @TestMe
    private void reduceToSimplestForm(){
        long gcd = gcd(this.numerator,this.denominator);
        this.numerator = this.numerator/gcd;
        this.denominator = this.denominator/gcd;
    }

}
