package CalcLogic;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class MonomialTest {
    private Monomial mon0;
    private Monomial mon1;
    private Monomial mon2;
    private Monomial mon3;
    private Monomial mon4;

    private Monomial mon5;
    private Monomial mon6;

    @BeforeEach
    void setUp() {
        mon0 = new Monomial(2,new Integer(2));
        mon1 = new Monomial(2,new Integer(5));
        mon2 = new Monomial(1,new Integer(1));
        mon3 = new Monomial(6,new Integer(0));
        mon4 = new Monomial(7,new Integer(6));
        mon5 = new Monomial(0, new Integer(5));
        mon6 = new Monomial(1,new Integer(5));


    }

    @Test
    void add() {
        assertEquals("7x^2",mon0.add(mon1).toString());
        assertEquals("4x^2",mon1.add(new Monomial(2,new Integer(-1))).toString());
    }

    @Test
    void mul() {
        assertEquals("10x^4",mon0.mul(mon1).toString());
        assertEquals("0",mon3.mul(mon4).toString());
        assertEquals("12x^9",mon0.mul(mon4).toString());
    }

    @Test
    void evaluate() {
        assertEquals("5",mon5.evaluate(new Integer(500)).toString());
        assertEquals("72",mon0.evaluate(new Integer(6)).toString());
    }

    @Test
    void derivative() {
        assertEquals("4x",mon0.derivative().toString());
        assertEquals("0",mon3.derivative().toString());
        assertEquals("1",mon2.derivative().toString());
    }

    @Test
    void sign() {
        assertEquals(1,mon0.sign());
        assertEquals(0,mon3.sign());
    }

    @Test
    void testToString() {
        assertEquals("2x^2",mon0.toString());
        assertEquals("x",mon2.toString());
        assertEquals("0",mon3.toString());
        assertEquals("5x",mon6.toString());
    }

    @Test
    void testEquals() {
        assertEquals(true,mon0.equals(mon0));
        assertEquals(false,mon0.equals(mon1));
    }
}