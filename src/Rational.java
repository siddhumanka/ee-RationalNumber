/**
 * Created by user-2 on 31/8/16.
 */
public class Rational extends Number implements Comparable<Rational> {
    private long numerator;
    private long denominator;

    public Rational(){
        this.numerator = 0l;
        this.denominator = 1l;
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
            throw  new NullPointerException("null object");
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
        return this.numerator +"/"+ this.denominator;
    }

    public Rational add(Rational secondRational){
        Rational tempRational = new Rational(1l,1l);
        tempRational.numerator = this.numerator * secondRational.denominator + this.denominator*secondRational.numerator;
        tempRational.denominator = this.denominator * secondRational.denominator;

        return  tempRational.makeSimplest();
    }

    public Rational subtract(Rational secondRational){
        Rational tempRational = new Rational(1l,1l);
        tempRational.numerator = this.numerator * secondRational.denominator - this.denominator*secondRational.numerator;
        tempRational.denominator = this.denominator * secondRational.denominator;
        return  tempRational.makeSimplest();
    }

    public Rational multiply(Rational secondRational){
        Rational tempRational = new Rational(1l,1l);
        tempRational.numerator = this.numerator * secondRational.numerator ;
        tempRational.denominator = this.denominator * secondRational.denominator;
        return  tempRational.makeSimplest();
    }

    public Rational divide(Rational secondRational){
        Rational tempRational = new Rational(1l,1l);
        tempRational.numerator = this.numerator * secondRational.denominator;
        tempRational.denominator = this.denominator * secondRational.numerator;
        return  tempRational.makeSimplest();
    }

    @TestMe
    private  long gcd (long firstNumber , long secondNumber){
        if(secondNumber == 0){
            return firstNumber;
        }
        return gcd(secondNumber, firstNumber%secondNumber);
    }


    @TestMe
    private Rational makeSimplest(){
        long gcd =gcd(this.numerator,this.denominator);

        if(gcd == 1l){
            return this;
        }
        else{
            return new Rational(this.numerator/gcd,this.denominator/gcd);
        }
    }

 /*   @TestMe
    private long lcm(long firstNumber, long secondNumber){
        return firstNumber * (secondNumber / gcd(firstNumber, secondNumber));
    }*/


}