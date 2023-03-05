package clean.code.bad.perf.switchy;

public class Shape {
    ShapeType shapeType;
    double width;
    double height;

    public Shape(ShapeType shapeType, double width, double height) {
        this.shapeType = shapeType;
        this.width = width;
        this.height = height;
    }
}
