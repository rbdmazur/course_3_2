public class Functions {
    public static double start = -1;
    public static double end = 5;
    public static int size = 17;
    public static double h = 0.1;
    public double[] xArray = new double[size];
    public Functions() {
        for (int i = 0; i < size; i++) {
            xArray[i] = start + i * h;
        }
    }

    public double[] function1() {
        double[] result = new double[size];
        for (int i = 0; i < size; i++) {
            double value = xArray[i] * 5 - 3;
            result[i] = Math.sin(value);
        }

        return result;
    }

    public double[] function2() {
        double[] result = new double[size];
        for (int i = 0; i < size; i++) {
            double value = xArray[i] * 2 - 1;
            result[i] = Math.abs(value);
        }

        return result;
    }

    public static double function1(double x) {
        double value = x * 5 - 3;
        return Math.sin(value);
    }

    public static double function2(double x) {
        double value = x * 2 - 1;
        return Math.abs(value);
    }
}
