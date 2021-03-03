package contest;

import java.util.Scanner;

public class TaskI {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int pointsA = 0;
        int pointsB = 0;
        for (int i = 0; i < n; i++) {
            int t = scanner.nextInt();
            int d = scanner.nextInt();
            if (t == 1) {
                if (d == -1) {
                    pointsA += 1;
                } else if (d <= 6) {
                    pointsA += 2;
                } else {
                    pointsA += 3;
                }
            } else {
                if (d == -1) {
                    pointsB += 1;
                } else if (d <= 6) {
                    pointsB += 2;
                } else {
                    pointsB += 3;
                }
            }
        }
        scanner.close();
        System.out.println(pointsA + ":" + pointsB);
    }
}
