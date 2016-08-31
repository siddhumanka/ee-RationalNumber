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
    @org.junit.Before
    public void setUp() throws Exception {
        rationalNumber1  = new Rational(2l,4l);
        rationalNumber2  = new Rational(1l,2l);
    }

    @org.junit.Test
    public void getNumerator() throws Exception {
        assertEquals(rationalNumber1.getNumerator(),0l);
    }

    @org.junit.Test
    public void getDenominator() throws Exception {
        assertEquals(rationalNumber1.getDenominator(),1l);
    }

    @org.junit.Test
    public void intValue() throws Exception {
        assertEquals(rationalNumber2.intValue(),0);
    }

    @org.junit.Test
    public void longValue() throws Exception {
        assertEquals(rationalNumber2.longValue(),0l);
    }

    @org.junit.Test
    public void floatValue() throws Exception {
        assertEquals(rationalNumber2.doubleValue(),0d);
    }

    @org.junit.Test
    public void doubleValue() throws Exception {
        assertEquals(rationalNumber2.floatValue(),0f);

    }

    @org.junit.Test
    public void compareTo() throws Exception {
        assertEquals(rationalNumber1.compareTo(rationalNumber2),-1);
    }

    @org.junit.Test
    public void add() throws Exception {
        Rational tempRational = rationalNumber1.add(rationalNumber2);
        assertEquals(tempRational.getNumerator(),22);
        assertEquals(tempRational.getDenominator(),15);
    }

    @org.junit.Test
    public void subtract() throws Exception {
        Rational tempRational = rationalNumber1.subtract(rationalNumber2);
        assertEquals(tempRational.getNumerator(),-2);
        assertEquals(tempRational.getDenominator(),15);
    }

    @org.junit.Test
    public void multiply() throws Exception {
        Rational tempRational = rationalNumber1.multiply(rationalNumber2);
        assertEquals(tempRational.getNumerator(),1);
        assertEquals(tempRational.getDenominator(),4);
    }

    @org.junit.Test
    public void divide() throws Exception {
        Rational tempRational = rationalNumber1.divide(rationalNumber2);
        assertEquals(tempRational.getNumerator(),10);
        assertEquals(tempRational.getDenominator(),12);
    }

    @org.junit.Test
    public void isToStringWorking() throws Exception {
        assertEquals(rationalNumber1.toString(),"1/2");
    }


    @Test
    public void testGcd() throws InvocationTargetException, IllegalAccessException {
        Class<Rational> classRational = Rational.class;

     Annotation [] annotation = classRational.getDeclaredAnnotations();
        for (Annotation annotationIterator : annotation ){
            if(annotationIterator.annotationType() == TestMe.class){

            }
        }
        //classRational.

        Method []  methods = classRational.getDeclaredMethods();

        List<Method> list = new ArrayList<>();

        Method methodToTest = null;
        for(Method method : methods){
            if(method.isAnnotationPresent(TestMe.class)){
                methodToTest = method;
            }
        }
        //gcdMethod.setAccessible(true);
//        Object object1 = new Long(4l);
//        Object object2  = new Long(8l);
//        long gcd = (long) gcdMethod.invoke(object1,object2);
        methodToTest.setAccessible(true);
        Rational tempRational = (Rational) methodToTest.invoke(rationalNumber1);

        assertEquals(tempRational.toString(),"1/2");
    }
}