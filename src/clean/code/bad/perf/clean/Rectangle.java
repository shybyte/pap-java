package clean.code.bad.perf.clean;

public class Rectangle implements Shape {
    double width = 0.0;
    double height = 0.0;

    public Rectangle(double width, double height) {
        this.width = width;
        this.height = height;
    }

    @Override
    public double area() {
        return this.width * this.height;
    }
}