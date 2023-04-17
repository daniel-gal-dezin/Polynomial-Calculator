package CalcLogic;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Iterator;

import static org.junit.jupiter.api.Assertions.*;

class PolynomialTest {
    Polynomial p;
    Polynomial p2;
    Polynomial p3;
    @BeforeEach
    void setUp() {
        p = Polynomial.build("0 0 2 3 -7/6");
        p2 = Polynomial.build("6 2 1 129/442 238/32 -220/110");
        p3 = Polynomial.build("1 2 3");
    }

    @Test
    void build() {

        assertEquals("2x^2 3x^3 -7/6x^4", p.toString());
        assertEquals("6 2x 1x^2 129/442x^3 119/16x^4 -2x^5", p2.toString());
        assertEquals("1 2x 3x^2", p3.toString());
    }

    @Test
    void add() {
        assertEquals("6 2x 3x^2 1455/442x^3 301/48x^4 -2x^5", p.add(p2).toString()); //calculated by hand
    }

    @Test
    void mul() {
        assertEquals("2x^2 7x^3 65/6x^4 20/3x^5 -7/2x^6", p.mul(p3).toString()); //calculated by hand
    }

    @Test
    void evaluate() {
        assertEquals("23/6", p.evaluate(new Integer(1)).toString());
        assertEquals("34", p3.evaluate(new Integer(3)).toString());
    }

    @Test
    void derivative(){
        assertEquals("4x 9x^2 -14/3x^3", p.derivative().toString());
        assertEquals("2 6x", p3.derivative().toString());
    }


    @Test
    void testEquals() {
        assertEquals(true,p.equals(p));
        assertEquals(false,p.equals(p2));
    }
}

