package contest;

import java.util.Scanner;

public class Task5 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        double[] x = new double[n];
        double[] y = new double[n];

        for (int i = 0; i < n; i++) {
            x[i] = scanner.nextInt();
            y[i] = scanner.nextInt();
        }
        double xc = 0;
        double P = 0;
        for (int i = 0; i < n; i++) {
            double l = length(x[i], y[i], x[(i + 1) % n], y[(i + 1) % n]);
            xc += l * (x[i] + x[(i + 1) % n]) / 2;
            P += l;
        }
        xc /= P;
        System.out.printf("%.6f", xc);
    }

    private static double length(double x1, double y1, double x2, double y2) {
        return Math.sqrt((x1 - x2) * (x1 - x2) + (y1 - y2) * (y1 - y2));
    }
}