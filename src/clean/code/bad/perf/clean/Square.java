package clean.code.bad.perf.clean;

public class Square implements Shape {
    double side = 0.0;

    public Square(double side) {
        this.side = side;
    }

    @Override
    public double area() {
        return this.side * this.side;
    }
}