package clean.code.bad.perf.clean;

import java.util.Arrays;

public class AreaSumClean {
    static int N = 1_000_000;

    static Shape[] createArray() {
        Shape[] array = new Shape[N];

        for (int i = 0; i < array.length; i++) {
            array[i] = switch (i%4) {
                case 0 -> new Square(1.234);
                case 1 -> new Rectangle(1.234,2.345);
                case 2 -> new Triangle(1.234, 2.345);
                case 3 -> new Circle(1.234);
                default -> throw  new RuntimeException("Unknown shape");
            };
        }

        return array;
    }

    static double sumArrayForLoopIndex(Shape[] array) {
        double sum = 0;
        for (int i = 0; i < array.length; i++) {
            sum += array[i].area();
        }
        return sum;
    }

    static double sumArrayForEachLoop(Shape[] array) {
        double sum = 0;
        for (Shape shape: array) {
            sum += shape.area();
        }
        return sum;
    }

    static double sumArrayStream(Shape[] array) {
        return Arrays.stream(array).mapToDouble(it -> it.area()).sum();
    }

    static double sumArrayForLoopIndex5(Shape[] array) {
        double sum0 = 0;
        double sum1 = 0;
        double sum2 = 0;
        double sum3 = 0;
        double sum4 = 0;
        for (int i = 0; i < array.length; i += 5) {
            sum0 += array[i].area();
            sum1 += array[i + 1].area();
            sum2 += array[i + 2].area();
            sum3 += array[i + 3].area();
            sum4 += array[i + 4].area();
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