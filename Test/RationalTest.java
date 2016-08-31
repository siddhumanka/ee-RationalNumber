import org.junit.Before;
import org.junit.Test;
import org.junit.internal.MethodSorter;

import java.lang.annotation.Annotation;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.*;

/**
 * Created by user-2 on 31/8/16.
 */
public class RationalTest {
    Rational rationalNumber1;
    Rational rationalNumber2;

    Class<Rational> classRational = Rational.class;
    Method[] methods = classRational.getDeclaredMethods();
    List<Method> list = new ArrayList<>();
    Method gcdMethod = null, reductionMethod = null;

    @Before
    public void setUp() throws Exception {
        rationalNumber1 = new Rational(2l, 4l);
        rationalNumber2 = new Rational(1l, 2l);

        for (Method method : methods) {
            if (method.isAnnotationPresent(TestMe.class)) {
                list.add(method);
            }
        }

        for (Method method : list) {
            if (method.getName().equalsIgnoreCase("gcd")) {
                gcdMethod = method;
            }
            if (method.getName().equalsIgnoreCase("reducetosimplestform")) {
                reductionMethod = method;
            }
        }
    }

    @Test
    public void itShoulReturnNumeratorOfARationalNumber() throws Exception {
        assertEquals(rationalNumber1.getNumerator(), 0l);
    }

    @Test
    public void itShouldReturnDenominatorOfARationalNumber() throws Exception {
        assertEquals(rationalNumber1.getDenominator(), 1l);
    }

    @Test
    public void itShouldConvertRationalNumberToInt() throws Exception {
        assertEquals(rationalNumber2.intValue(), 0);
    }

    @org.junit.Test
    public void itShouldConvertRationalNumberToLong() throws Exception {
        assertEquals(rationalNumber2.longValue(), 0l);
    }

    @Test
    public void itShouldConvertRationalNumberToDouble() throws Exception {
        assertEquals(rationalNumber2.doubleValue(), 0d);
    }

    @Test
    public void itShouldConvertRationalNumberToFloat() throws Exception {
        assertEquals(rationalNumber2.floatValue(), 0f);

    }

    @Test
    public void itShouldCompareTwoRationalNumbers() throws Exception {
        assertEquals(rationalNumber1.compareTo(rationalNumber2), -1);
    }

    @Test
    public void itShouldAddTwoRationalNumbers() throws Exception {
        Rational tempRational = rationalNumber1.add(rationalNumber2);
        assertEquals(tempRational.getNumerator(), 22);
        assertEquals(tempRational.getDenominator(), 15);
    }

    @Test
    public void itShouldSubtractTwoRationalNumbers() throws Exception {
        Rational tempRational = rationalNumber1.subtract(rationalNumber2);
        assertEquals(tempRational.getNumerator(), -2);
        assertEquals(tempRational.getDenominator(), 15);
    }

    @Test
    public void itShouldMultiplyTwoRationalNumbers() throws Exception {
        Rational tempRational = rationalNumber1.multiply(rationalNumber2);
        assertEquals(tempRational.getNumerator(), 1);
        assertEquals(tempRational.getDenominator(), 4);
    }

    @Test
    public void itShouldDivideTwoRationalNumbers() throws Exception {
        Rational tempRational = rationalNumber1.divide(rationalNumber2);
        assertEquals(tempRational.getNumerator(), 10);
        assertEquals(tempRational.getDenominator(), 12);
    }

    @Test
    public void itShouldValidateToString() throws Exception {
        assertEquals(rationalNumber1.toString(), "1/2");
    }

    @Test
    public void itShouldReduceRationalNumberToSimplestForm() throws InvocationTargetException, IllegalAccessException {
        reductionMethod.setAccessible(true);
        reductionMethod.invoke(rationalNumber1);
        assertEquals(rationalNumber1.toString(), "1/2");
    }
    @Test
    public void itShouldProduceRightGCD() throws InvocationTargetException, IllegalAccessException {
        gcdMethod.setAccessible(true);
        long gcd = (long) gcdMethod.invoke(rationalNumber1, 4l, 8l);
        assertEquals(gcd, 4l);
    }

}