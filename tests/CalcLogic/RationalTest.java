package CalcLogic;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class RationalTest {
    private  Rational rat0;
    private  Rational rat1;
    private  Rational rat2;
    private  Rational rat3;
    private  Rational rat4;
    private Rational rat5;


    @BeforeEach
    void setUp() {
        rat0 = new Rational(3,2);
        rat1 = new Rational(1,3);
        rat2 = new Rational(4,-8);
        rat3 = new Rational(120,37);
        rat4 = new Rational(900,2);
        rat5 = new Rational(-1,2);

    }

    @Test
    void testToString() {
        assertEquals("3/2",rat0.toString());
        assertEquals("1/3",rat1.toString());
        assertEquals("-1/2",rat2.toString());
        assertEquals("120/37",rat3.toString());
        assertEquals("450",rat4.toString());
    }

    @Test
    void add() {
        assertEquals("11/6",rat0.add(rat1).toString());
        assertEquals("0",rat2.add(rat2.neg()).toString());
        assertEquals("2/3",rat1.add(rat1).toString());
        assertEquals("500",rat4.add(new Integer(50)).toString());
        assertEquals("351/74",rat3.add(rat0).toString());
    }

    @Test
    void reduce() {
        Rational temp = rat4.reduce();
        assertEquals(450, temp.getNumerator());
        assertEquals(1, temp.getDeminator());
    }

    @Test
    void mul() {
        assertEquals("1/2",rat0.mul(rat1).toString());
        assertEquals("-225",rat4.mul(rat2).toString());

    }

    @Test
    void neg() {
        assertEquals("225",rat4.mul(rat2).neg().toString());
    }

    @Test
    void power() {

        assertEquals("27/8",rat0.power(3).toString());
        assertEquals("1/4",rat5.power(2).toString());
        assertEquals("-1/8",rat5.power(3).toString());
    }

    @Test
    void sign() {
        assertEquals(1, rat0.sign());
    }

    @Test
    void testEquals() {
        assertEquals(true,rat0.equals(rat0));
        assertEquals(false,rat0.equals(rat1));
    }
}