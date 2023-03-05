package clean.code.bad.perf.soa;

public class ShapeArray {
    byte[] shapeType;
    double[] widthHeight;

    public ShapeArray(int size) {
        this.shapeType = new byte[size];
        this.widthHeight = new double[size * 2];

        for (int i = 0; i < size; i++) {
            shapeType[i] = (byte) (i % 4);
            widthHeight[i * 2 + 0] = 1.123;
            widthHeight[i * 2 + 1] = 2.345;
        }
    }
}
