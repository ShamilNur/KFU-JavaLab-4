package contest;

import java.util.Scanner;

public class Task3 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int k = -1;
        int l = -1;
        for (int i = 0; i < n; i++) {
            int a = scanner.nextInt();
            if ((a + i + 1) % 2 != 0) {
                if (k == -1 || l == -1) {
                    if (k == -1) {
                        k = i + 1;
                    } else {
                        l = i + 1;
                    }
                } else {
                    k = -1;
                    l = -1;
                    break;
                }
            }
        }
        System.out.println(k + " " + l);
    }
}