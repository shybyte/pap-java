package clean.code.bad.perf.clean;

public class Triangle implements Shape {
    double base = 0.0;
    double height = 0.0;

    public Triangle(double base, double height) {
        this.base = base;
        this.height = height;
    }

    @Override
    public double area() {
        return 0.5 * this.base * this.height;
    }
}