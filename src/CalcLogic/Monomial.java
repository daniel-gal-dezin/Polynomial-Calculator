package CalcLogic;

import java.util.Objects;

public class Monomial {
    private int exponent; // Exponent of the monomial
    private Scalar coefficient; // Coefficient of the monomial

    // Constructor to initialize the exponent and coefficient of the monomial
    public Monomial(int exponent, Scalar coefficient) {
        this.exponent = exponent;
        this.coefficient = coefficient;
    }

    // Method to add two monomials
    public Monomial add(Monomial m) {
        if (m.exponent != this.exponent) // Check if exponents are not equal
            return null; // If exponents are not equal, return null
        return new Monomial(this.exponent, this.coefficient.add(m.getCoefficient())); // Otherwise, add coefficients and create a new monomial
    }

    // Method to multiply two monomials
    public Monomial mul(Monomial m) {
        int exp = this.exponent + m.exponent; // Multiply exponents to get the new exponent
        Scalar temp = this.coefficient.mul(m.getCoefficient()); // Multiply coefficients to get the new coefficient
        return new Monomial(exp, temp); // Create a new monomial with the new exponent and coefficient
    }

    // Method to evaluate the monomial with a given scalar value
    public Scalar evaluate(Scalar s) {
        Scalar ans = this.coefficient.mul(s.power(this.exponent)); // Raise the scalar value to the exponent and multiply with the coefficient
        return ans; // Return the result
    }

    // Method to calculate the derivative of the monomial
    public Monomial derivative() {
        if (this.exponent == 0) // If exponent is 0, return null as derivative is not defined
            return null;

        Integer exp = new Integer(this.exponent); // Convert exponent to integer for calculations
        Scalar coef = this.coefficient.mul(exp); // Multiply coefficient with exponent to get the new coefficient
        return new Monomial(this.exponent - 1, coef); // Create a new monomial with the new exponent and coefficient
    }

    // Method to get the sign of the monomial's coefficient
    public int sign() {
        return this.coefficient.sign(); // Call the sign() method on the coefficient and return the result
    }

    // Method to convert the monomial to a string representation
    public String toString() {
        if(this.coefficient.toString().equals("0")) // If coefficient is 0, return "0"
            return "0";
        if(this.coefficient.toString().equals("1") && this.exponent==1) // If coefficient is 1 and exponent is 1, return "x"
            return "x";
        if(this.exponent == 0) // If exponent is 0, return the coefficient as string
            return this.coefficient.toString();
        if(this.exponent == 1) // If exponent is 1, return the coefficient followed by "x"
            return this.coefficient.toString() + "x";

        return this.coefficient.toString() + "x^" + this.exponent; // Otherwise, return coefficient followed by "x" raised to the exponent
    }

    // Getters and setters for exponent and coefficient
    public int getExponent() {
        return exponent;
    }

    public void setExponent(int exponent) {
        this.exponent = exponent;
    }

    public Scalar getCoefficient() {
        return coefficient;
    }

    public void setCoefficient(Scalar coefficient) {
        this.coefficient = coefficient;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Monomial monomial)) return false;
        Monomial other = (Monomial) o;
        return other.getExponent()==this.exponent && other.getCoefficient()==this.coefficient;
    }


}

