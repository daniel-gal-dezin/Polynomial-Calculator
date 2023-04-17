package CalcLogic;

import java.util.Iterator;
import java.util.LinkedList;

public class Polynomial {

    private LinkedList<Monomial> monomials;

    public Polynomial(){
        this.monomials = new LinkedList<Monomial>();
    }

    static Polynomial build(String input){// Static method to build a Polynomial object from a string input
        Polynomial p = new Polynomial();
        boolean rat = false;
        String[] coefs = input.split(" ");
        for(int i = 0; i < coefs.length; i++){
            if(!coefs[i].equals("0")) {
                for (int j = 0; j < coefs[i].length(); j++) {
                    if (coefs[i].charAt(j) == '/') {
                        rat = true;
                        int numer = java.lang.Integer.parseInt(coefs[i].substring(0, j));
                        int demor = java.lang.Integer.parseInt(coefs[i].substring(j + 1, coefs[i].length()));
                        p.getMonomials().add(new Monomial(i, new Rational(numer, demor)));
                    }
                }
                if (!rat)
                    p.getMonomials().add(new Monomial(i, new Integer(java.lang.Integer.parseInt(coefs[i]))));
            }
        }
        return p;
    }
    // Method to add two Polynomials
    public Polynomial add(Polynomial p){
        Polynomial result = new Polynomial();
        Iterator<Monomial> iter1 = this.monomials.iterator();
        Iterator<Monomial> iter2 = p.getMonomials().iterator();
        int tookFrom = 0;
        Monomial mon1 = new Monomial(0,new Integer(0));
        Monomial mon2 = new Monomial(0,new Integer(0));
        while (iter1.hasNext() & iter2.hasNext()){
            if(tookFrom == 0){
                mon1 = iter1.next();
                mon2 = iter2.next();
            }
            else if(tookFrom == 1)
                mon1 = iter1.next();
            else
                mon2 = iter2.next();

            if(mon1.getExponent() == mon2.getExponent()) {
                result.getMonomials().add(mon1.add(mon2));
                tookFrom = 0;
            }
            else {
                if(mon1.getExponent() < mon2.getExponent()){
                    result.getMonomials().add(mon1);
                    tookFrom = 1;
                }
                else {
                    result.getMonomials().add(mon2);
                    tookFrom = 2;
                }
            }
        }

        while (iter1.hasNext())
            result.getMonomials().add(iter1.next());

        while (iter2.hasNext())
            result.getMonomials().add(iter2.next());

        return result;
    }

    public Polynomial mul(Polynomial p){// Method to multiply two Polynomials
        Polynomial result = new Polynomial();
        Iterator<Monomial> iter1 = this.monomials.iterator();
        while (iter1.hasNext()){
            Monomial currentM = iter1.next();
            Iterator<Monomial> iter2 = p.getMonomials().iterator();
            Polynomial temp = new Polynomial();
            while (iter2.hasNext())
                temp.getMonomials().add(currentM.mul(iter2.next()));

            result = result.add(temp);
        }

        return result;
    }

    public Scalar evaluate(Scalar s){// Method to evaluate the Polynomial at a given Scalar value
        Scalar result = new Integer(0);
        Iterator<Monomial> iter = this.monomials.iterator();
        while (iter.hasNext()){
            result = result.add(iter.next().evaluate(s));
        }
        return result;
    }

    public Polynomial derivative(){//method to get the derivative value of the value given
        Polynomial result = new Polynomial();
        Iterator<Monomial> iter = this.monomials.iterator();
        while (iter.hasNext()){
            Monomial current = iter.next();
            if (current.derivative() != null)
                result.getMonomials().add(current.derivative());
        }
        return result;
    }

    public String toString(){
        Iterator<Monomial> iter1 = this.monomials.iterator();
        String s1 = "";
        while (iter1.hasNext()){
            s1 = s1 + iter1.next().toString() + " ";
        }
        return s1.substring(0,s1.length() - 1);
    }

    //getters and setters methods.
    public LinkedList<Monomial> getMonomials() {
        return monomials;
    }

    public void setMonomials(LinkedList<Monomial> monomials) {
        this.monomials = monomials;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Polynomial)) return false;
        Polynomial other = (Polynomial) o;

        // Check if the number of monomials in both polynomials are the same
        if (this.monomials.size() != other.monomials.size()) return false;

        // Check if each monomial in both polynomials are equal
        Iterator<Monomial> iter1 = this.monomials.iterator();
        Iterator<Monomial> iter2 = other.monomials.iterator();
        while (iter1.hasNext() && iter2.hasNext()) {
            Monomial mon1 = iter1.next();
            Monomial mon2 = iter2.next();
            if (!mon1.equals(mon2)) return false;
        }

        return true;
    }
}
