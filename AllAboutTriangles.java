public class AllAboutTriangles {
    private double a;
    private double b;
    private double c;

    public AllAboutTriangles() {
        a = 3;
        b = 4;
        c = 5;
    }

    public AllAboutTriangles(double first, double second, double third) {
        a = first;
        b = second;
        c = third;
    }

    public double getA() {
        return a;
    }

    public double getB() {
        return b;
    }

    public double getC() {
        return c;
    }

    public void setA(double first) {
        a = first;
    }

    public void setB(double second) {
        b = second;
    }

    public void setC(double third) {
        c = third;
    }

    public boolean isTriangle() {
        return (a + b > c) && (a + c > b) && (b + c > a);
    }

    public boolean isRightTriangle() {
        return (Math.abs(Math.pow(a, 2) + Math.pow(b, 2) - Math.pow(c, 2)) <= 0.1) ||
                (Math.abs(Math.pow(a, 2) + Math.pow(c, 2) - Math.pow(b, 2)) <= 0.1) ||
                (Math.abs(Math.pow(b, 2) + Math.pow(c, 2) - Math.pow(a, 2)) <= 0.1);
    }

    public double perimeter() {
        return a + b + c;
    }

    public double area() {
        double p = perimeter() / 2;
        return Math.sqrt(p * (p - a) * (p - b) * (p - c));
    }

    public void displayTriangle() {
        System.out.println("Smallest Side: " + Math.min(Math.min(a, b), c));
        System.out.println("Medium Side: " + Math.min(Math.max(a, b), c));
        System.out.println("Largest Side: " + Math.max(Math.max(a, b), c));
    }
}
