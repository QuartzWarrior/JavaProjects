class Polynomial {
    private double degree;
    private int numTerms;

    public Polynomial(double d, int n) {
        degree = d > 0 ? d : 0;
        numTerms = n;
    }

    public double getDegree() {
        return degree;
    }

    public int getNumTerms() {
        return numTerms;
    }

    public String toString() {
        return "Degree: " + degree + "\nNumber of terms: " + numTerms;
    }

    public boolean equals(Polynomial p) {
        if (degree == p.getDegree() && numTerms == p.getNumTerms()) {
            return true;
        } else {
            return false;

        }
    }

}

class Trinomial extends Polynomial {
    private double leadingCoefficient;
    private double middleCoefficient;
    private double lastCoefficient;

    public Trinomial(double d, double a, double b, double c) {
        super(d, 3);
        leadingCoefficient = a;
        middleCoefficient = b;
        lastCoefficient = c;
    }

    public double getLeadingCoefficient() {
        return leadingCoefficient;
    }

    public double getMiddleCoefficient() {
        return middleCoefficient;
    }

    public double getLastCoefficient() {
        return lastCoefficient;
    }

    public String toString() {
        return super.toString() + "\nLeading coefficient: " + leadingCoefficient + "\nMiddle coefficient: "
                + middleCoefficient + "\nLast coefficient: " + lastCoefficient;
    }

    public boolean equals(Trinomial t) {
        if (super.getDegree() == t.getDegree() && super.getNumTerms() == t.getNumTerms()
                && leadingCoefficient == t.getLeadingCoefficient() && middleCoefficient == t.getMiddleCoefficient()
                && lastCoefficient == t.getLastCoefficient()) {
            return true;
        } else {
            return false;
        }
    }

}

class Quadratic extends Trinomial {
    private double discriminant;

    public Quadratic(double a, double b, double c) {
        super(2, a, b, c);
        discriminant = Math.pow(b, 2) - 4 * a * c;
    }

    public double getDiscriminant() {
        return discriminant;
    }

    public String toString() {
        return super.toString() + "\nDiscriminant: " + discriminant;
    }

    public boolean equals(Quadratic q) {
        if (super.getDegree() == q.getDegree() && super.getNumTerms() == q.getNumTerms()
                && super.getLeadingCoefficient() == q.getLeadingCoefficient()
                && super.getMiddleCoefficient() == q.getMiddleCoefficient()
                && super.getLastCoefficient() == q.getLastCoefficient() && discriminant == q.getDiscriminant()) {
            return true;
        } else {
            return false;
        }
    }

    public boolean hasRealSolutions() {
        if (discriminant >= 0) {
            return true;
        } else {
            return false;
        }
    }

    public double firstZero() {
        if (hasRealSolutions()) {
            return (-super.getMiddleCoefficient() + Math.sqrt(discriminant)) / (2 * super.getLeadingCoefficient());
        } else {
            return 0;
        }
    }

    public double secondZero() {
        if (hasRealSolutions()) {
            return (-super.getMiddleCoefficient() - Math.sqrt(discriminant)) / (2 * super.getLeadingCoefficient());
        } else {
            return 0;
        }
    }

    public boolean isPerfectSquare() {
        if (discriminant >= 0) {
            if (Math.sqrt(discriminant) % 1 == 0) {
                return true;
            } else {
                return false;
            }
        } else {
            return false;
        }
    }
}