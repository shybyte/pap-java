package clean.code.bad.perf.switchy;

import java.util.Arrays;

public class AreaSumSwitch {
    static int N = 1_000_000;

    static Shape[] createArray() {
        Shape[] array = new Shape[N];

        for (int i = 0; i < array.length; i++) {
            array[i] = switch (i%4) {
                case 0 -> new Shape(ShapeType.Square, 1.234, 1.234);
                case 1 -> new Shape(ShapeType.Rectangle, 1.234, 2.234);
                case 2 -> new Shape(ShapeType.Triangle, 1.234, 2.234);
                case 3 -> new Shape(ShapeType.Circle, 1.234, 1.234);
                default -> throw  new RuntimeException("Unknown shape");
            };
        }

        return array;
    }

    static double area(Shape shape) {
        return switch (shape.shapeType) {
            case Square, Rectangle -> shape.width* shape.height;
            case Triangle -> 0.5 * shape.width* shape.height;
            case Circle -> Math.PI * shape.width* shape.height;
        };
    }

    static double sumArrayForLoopIndex(Shape[] array) {
        double sum = 0;
        for (int i = 0; i < array.length; i++) {
            sum += area(array[i]);
        }
        return sum;
    }

    static double sumArrayForEachLoop(Shape[] array) {
        double sum = 0;
        for (Shape shape: array) {
            sum += area(shape);
        }
        return sum;
    }

    static double sumArrayStream(Shape[] array) {
        return Arrays.stream(array).mapToDouble(it -> area(it)).sum();
    }

    static double sumArrayForLoopIndex5(Shape[] array) {
        double sum0 = 0;
        double sum1 = 0;
        double sum2 = 0;
        double sum3 = 0;
        double sum4 = 0;
        for (int i = 0; i < array.length; i += 5) {
            sum0 += area(array[i]);
            sum1 += area(array[i + 1]);
            sum2 += area(array[i + 2]);
            sum3 += area(array[i + 3]);
            sum4 += area(array[i + 4]);
        }
        return sum0 + sum1 + sum2 + sum3 + sum4;
    }

    static double sumArrayForLoop(double[] array) {
        double sum = 0;
        for (double x : array) {
            sum += x;
        }
        return sum;
    }

    public static void main(String[] args) {
        Shape[] array = createArray();

        double minTime = Double.MAX_VALUE;
        for (int i = 0; i < 10; i++) {
            long startTime = System.nanoTime();

            double sum = sumArrayForEachLoop(array);

            double neededTime = (System.nanoTime() - startTime) / 1_000_000.0;
            minTime = Math.min(neededTime, minTime);
            System.out.println("sum  = " + sum + ". Needed time ms = " + neededTime);
        }

        System.out.println("minTime: " + minTime);
        System.out.println("minTime  = " + minTime);
    }
}