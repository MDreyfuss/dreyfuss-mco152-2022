public class QuadraticEquation {

    private double a;
    private double b;
    private double c;

    public QuadraticEquation(double a, double b, double c) {
        this.a = a;
        this.b = b;
        this.c = c;
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

    public double[] getX()
    {
       return new double[]{(-b + Math.sqrt(b * b - 4 * a * c))/( 2 * a),
                (-b - Math.sqrt(b * b - 4 * a * c)) / (2 * a)};
    }

}
