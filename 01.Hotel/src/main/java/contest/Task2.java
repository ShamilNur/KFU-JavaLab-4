package contest;

import java.util.Scanner;

public class Task2 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        long l = scanner.nextLong();
        long r = scanner.nextLong();
        int lenL = String.valueOf(l).length();
        int lenR = String.valueOf(r).length();
        long onesL = 1;
        long onesR = 1;
        for (int i = 1; i < lenL; i++) {
            onesL = onesL * 10 + 1;
        }
        for (int i = 1; i < lenR; i++) {
            onesR = onesR * 10 + 1;
        }
        int count = 0;
        if (lenL < lenR) {
            count += (lenR - lenL - 1) * 9;
            count += (r / onesR);
            count += (9 - l / onesL);
            if (l % onesL == 0) {
                count++;
            }
        } else if (lenL == lenR) {
            count += (r / onesR - l / onesL);
            if (l % onesL == 0) {
                count++;
            }
        }
        System.out.println(count);
    }
}