package CalcLogic;

public interface Scalar {
    Scalar add(Scalar s);// Addition operation with another Scalar

    Scalar mul(Scalar s); //Multiplication operation with another Scalar
    Scalar add(Integer i) ; // Addition operation with an Integer

    Scalar add(Rational r); // Addition operation with a Rational number

    Scalar mul(Integer i) ; // Multiplication operation with an Integer

    Scalar mul(Rational r); // Multiplication operation with a Rational number

    Scalar neg() ; // Negation operation

    Scalar power(int exponent); //  Exponentiation operation

    int sign(); // Sign determination operation




}
