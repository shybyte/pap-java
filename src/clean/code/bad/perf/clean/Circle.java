package clean.code.bad.perf.clean;

public class Circle implements Shape {
    double radius = 0.0;

    public Circle(double radius) {
        this.radius = radius;
    }

    @Override
    public double area() {
        return this.radius * Math.PI;
    }
}