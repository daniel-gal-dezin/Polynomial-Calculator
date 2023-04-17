package CalcLogic;

import java.util.Objects;

public class Integer implements Scalar {


    private int number; // Private field to store the integer value

    public Integer(int num) { // Constructor to initialize the Integer object with an integer value
        this.number = num;
    }

    public Scalar add(Scalar s) { // Method to add a Scalar object to the Integer object
        return s.add(this);
    }

    public Scalar mul(Scalar s) { // Method to multiply a Scalar object with the Integer object
        return s.mul(this);
    }

    @Override
    public Scalar add(Rational r) { // Implementation of the add() method from the Scalar interface for Rational objects
        return new Rational(this.number * r.getDeminator() + r.getNumerator(), r.getDeminator());
        // Returns a new Rational object with the sum of the integer value multiplied by the denominator of the Rational object,
        // and the numerator of the Rational object. The denominator remains unchanged.
    }

    @Override
    public Scalar add(Integer i) { // Implementation of the add() method from the Scalar interface for Integer objects
        return new Integer(this.number + i.getNumber());
        // Returns a new Integer object with the sum of the integer value of the current object and the integer value of the provided Integer object.
    }

    @Override
    public Scalar mul(Rational r) { // Implementation of the mul() method from the Scalar interface for Rational objects
        return new Rational(this.number * r.getNumerator(), r.getDeminator());
        // Returns a new Rational object with the product of the integer value multiplied by the numerator of the Rational object,
        // and the denominator of the Rational object. The numerator remains unchanged.
    }

    public Scalar mul(Integer i) { // Implementation of the mul() method for Integer objects
        return new Integer(this.number * i.getNumber());
        // Returns a new Integer object with the product of the integer value of the current object and the integer value of the provided Integer object.
    }

    @Override
    public Scalar neg() { // Implementation of the neg() method from the Scalar interface
        return new Integer(-1 * this.number);
        // Returns a new Integer object with the negation of the integer value of the current object.
    }

    @Override
    public Scalar power(int exponent) { // Implementation of the power() method from the Scalar interface
        if (exponent == 0) {
            return new Integer(1);
        }
        int x = 1;
        for (int i = 0; i < exponent; i++) { // Performs exponentiation using a loop
            x *= this.number;
        }
        return new Integer(x); // Returns a new Integer object with the result of exponentiation.
    }

    @Override
    public int sign() { // Implementation of the sign() method from the Scalar interface
        if (this.number == 0)
            return 0;
        else if (this.number > 1)
            return 1;
        return -1;
        // Returns -1 if the integer value is less than 1, 0 if it is equal to 0, and 1 if it is greater than 1.
    }

    @Override
    public String toString() { // Override of the toString() method to provide a string representation of the object
        return "" + this.number;
        // Returns the integer value as a string.
    }

    public int getNumber() { // Getter method for the integer value
        return number;
    }

    public void setNumber(int number) { // Setter method for the integer value
        this.number = number;


    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Integer integer)) return false;
        return ((Integer) o).getNumber() == number;
    }


}