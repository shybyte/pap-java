package clean.code.bad.perf.soa;

import java.util.Arrays;

public class AreaSumSoa {
    static int N = 1_000_000;

    static double[] FACTOR = new double[]{1.0, 1.0, 0.5, Math.PI};


    static double sumArrayForLoopIndex(ShapeArray array) {
        double sum = 0;
        byte[] shapeType = array.shapeType;
        double[] widthHeight = array.widthHeight;
        for (int i = 0; i < N; i++) {
            sum += FACTOR[shapeType[i]] * widthHeight[i * 2] * widthHeight[i * 2 + 1];
        }
        return sum;
    }


    public static void main(String[] args) {
        ShapeArray array = new ShapeArray(N);

        double minTime = Double.MAX_VALUE;
        for (int i = 0; i < 20; i++) {
            long startTime = System.nanoTime();

            double sum = sumArrayForLoopIndex(array);

            double neededTime = (System.nanoTime() - startTime) / 1_000_000.0;
            minTime = Math.min(neededTime, minTime);
            System.out.println("sum  = " + sum + ". Needed time ms = " + neededTime);
        }

        System.out.println("minTime: " + minTime);
        System.out.println("minTime  = " + minTime);
    }
}