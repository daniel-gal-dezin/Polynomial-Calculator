package CalcLogic;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class InetgerTest {
    private Integer num;
    private Integer num1;

    @BeforeEach
    void setUp() {
        num = new Integer(3);
        num1 = new Integer(4);
    }

    @Test
    void add(){
        assertEquals("20",num.add(new Integer(17)).toString());
        assertEquals("-15",num.add(new Integer(-18)).toString());
        assertEquals("13/2",num.add(new Rational(7,2)).toString());
    }


    @Test
    void testToString() {
        assertEquals("3", num.toString());
    }

    @Test
    void mul() {
        assertEquals("9",num.mul(new Integer(3)).toString());
        assertEquals("-3/2",num.mul(new Rational(-1, 2)).toString());
    }

    @Test
    void neg() {
        assertEquals("-3",num.neg().toString());
    }

    @Test
    void power() {
        assertEquals("9",num.power(2).toString());
        assertEquals("1",new Integer(-2).power(0).toString());
    }

    @Test
    void sign() {
        assertEquals(1, num.sign());
        assertEquals(-1, num.neg().sign());
    }

    @Test
    void testEquals() {
        assertEquals(true,num.equals(num));
        assertEquals(false,num.equals(num1));
    }
}