public class Solutions {
    static Functions functions = new Functions();
    double[][] yArray = new double[2][Functions.size];

    //Divided differences function1
    double[] dividedDiffFunc1 = new double[17];

    //Divided difference function2
    double[] dividedDiffFunc2 = new double[17];

    public Solutions() {
        yArray[0] = functions.function1();
        yArray[1] = functions.function2();
        for (int i = 1; i < 17; i++) {
            dividedDiffFunc1[i] = countDividedDiff(0, i);
        }
        for (int i = 1; i < 17; i++) {
            dividedDiffFunc2[i] = countDividedDiff(1, i);
        }
    }

    public double solution1Func1(double x, int n) {
        double result = yArray[0][0];
        double sum = 0;
        for (int k = 1; k <= n; k++) {
            double d = 1;
            for (int i = 0; i < k; i++) {
                d *= x - functions.xArray[i];
            }
            sum += dividedDiffFunc1[k] * d;
        }
        return result + sum;
    }
    public double solution1Func2(double x, int n) {
        double result = yArray[1][0];
        double sum = 0;
        for (int k = 1; k <= n; k++) {
            double d = 1;
            for (int i = 0; i < k; i++) {
                d *= x - functions.xArray[i];
            }
            sum += dividedDiffFunc2[k] * d;
        }
        return result + sum;
    }

    private double countDividedDiff(int num, int k) {
        double result = 0;
        for (int i = 0; i <= k; i++) {
            double s = yArray[num][i];
            double d = 1;
            for (int j = 0; j <= k; j++) {
                if (i != j) {
                    d *= functions.xArray[i] - functions.xArray[j];
                }
            }
            result += s / d;
        }
        return result;
    }
}
