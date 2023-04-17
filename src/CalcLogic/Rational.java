package CalcLogic;

import java.util.Objects;

public class Rational implements Scalar {
    private int numerator;// Private field to store the numerator of the rational number
    private int deminator;// Private field to store the denominator of the rational number

    public Rational(int num, int dem){ //Constructor to create a Rational object with numerator and denominator
        if(dem==0)
            throw new IllegalArgumentException("deminator cannot be zero");

        //If one side is negative, make sure to make the numerator negative
        //(we'll use it later in toString)
        if((num < 0 | dem < 0) & (num >= 0 | dem >= 0) ){
            if(dem < 0){
                num = -1 * num;
                dem = -1 * dem;
            }
        }
        else if(dem < 0 & num < 0){
            num = -1 * num;
            dem = -1 * dem;
        }
        this.numerator = num;
        this.deminator = dem;

    }
    // Method to add two Scalars
    public Scalar add(Scalar s){
        return s.add(this);
    }

    public Scalar mul(Scalar s){ // Method to multiply two Scalars
        return s.mul(this);
    }
    // Add an Integer to this Rational number
    public Scalar add(Integer i){
        return  new Rational(this.numerator + i.getNumber() * this.deminator,
                this.deminator);
    }
    // Add a Rational number to this Rational number
    public Scalar add(Rational r){
        return  new Rational(this.numerator * r.getDeminator() + this.deminator * r.getNumerator(),
                        this.deminator * r.getDeminator());
    }
    @Override// Override method to multiply this Rational number with an Integer
    public Scalar mul(Integer i) {
        return  new Rational(i.getNumber() * this.numerator, this.deminator);
    }

    // Method to multiply this Rational number with another Rational number
    public Scalar mul(Rational r){
        return new Rational(this.numerator * r.getNumerator(), this.deminator * r.getDeminator());
    }


    // Override method to calculate the power of this Rational number
    @Override
    public Scalar neg() {// Override method to negate this Rational number
        return new Rational(this.numerator * -1, this.deminator);
    }

    @Override
    public Scalar power(int exponent) {// Override method to calculate the power of this Rational number
        int a = 1;
        int b = 1;
        int i = 0;

        while(i < exponent){
            a *= this.numerator;
            b *= this.deminator;
            i++;
        }

        return new Rational(a,b).reduce();
    }

    @Override
    public int sign() {// Override method to determine the sign of this Rational number
        if(this.numerator==0)
            return 0;
        else if(this.numerator>1)
            return 1;
        return  -1;

    }




    public Rational reduce() {// Method to reduce this Rational number to its simplest form
        int a = this.numerator;
        int b = this.deminator;

        for (int i = 2; i <= Math.abs(a) & i <= b; i++) {
            while (a % i == 0 & b % i == 0) {
                a = a / i;
                b = b / i;
            }
        }
        return new Rational(a,b);
    }




    public String toString(){//public method to override to string
        if(this.deminator == 1)
            return  "" + this.numerator;
        else if (this.numerator == 0)
            return "0";
        Rational temp = this.reduce();
        if(temp.getDeminator() == 1)
            return "" + temp.getNumerator();

        return temp.getNumerator() + "/" +temp.getDeminator();

    }

    public void setNumerator(int numerator) {
        this.numerator = numerator;
    }

    public void setDeminator(int deminator) {
        this.deminator = deminator;
    }

    public int getNumerator() {
        return numerator;
    }

    public int getDeminator() {return deminator;}

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Rational rational)) return false;
        return ((Rational) o).getNumerator() == this.numerator && ((Rational) o).getDeminator() == this.deminator;
    }


}