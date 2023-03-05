import java.util.Arrays;

interface Shape {
    double area();
}

class Square implements Shape {
    double side = 0.0;

    public Square(double side) {
        this.side = side;
    }

    @Override
    public double area() {
        return 0;
    }
}


public class Main {
    static int COMPLETE_N = 100_000_000;
    static int N = 100_000;
    static int N2 = COMPLETE_N / N;

    static double[] createArray() {
        double[] array = new double[N];

        double sum = 0;
        for (int i = 0; i < array.length; i++) {
            array[i] = i;
        }
        return array;
    }

    static double sumArrayForLoopIndex(double[] array) {
        double sum = 0;
        for (int i = 0; i < array.length; i++) {
            sum += array[i];
        }
        return sum;
    }

    static double sumArrayStream(double[] array) {
        return Arrays.stream(array).sum();
    }

    static double sumArrayForLoopIndex5(double[] array) {
        double sum0 = 0;
        double sum1 = 0;
        double sum2 = 0;
        double sum3 = 0;
        double sum4 = 0;
        for (int i = 0; i < array.length; i += 5) {
            sum0 += array[i];
            sum1 += array[i + 1];
            sum2 += array[i + 2];
            sum3 += array[i + 3];
            sum4 += array[i + 4];
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
        double[] array = createArray();
        double sumArray = sumArrayForLoopIndex(array);
        System.out.println("sum = " + sumArray);
        System.out.println("Hello world!");

        long minTime = Long.MAX_VALUE;
        for (int i = 0; i < 10; i++) {
            long startTime = System.currentTimeMillis();

            double completeSum = 0;
            for (int j = 0; j < N2; j++) {
                completeSum += sumArrayForLoopIndex5(array);
            }

            long neededTime = System.currentTimeMillis() - startTime;
            minTime = Math.min(neededTime, minTime);
            System.out.println("completeSum  = " + completeSum + ". Needed time ms = " + neededTime);
        }

        System.out.println("minTime: " + minTime);
        System.out.println("minTime  = " + minTime);
        System.out.println("ops per microsecond " + COMPLETE_N / (minTime * 1000));

    }
}