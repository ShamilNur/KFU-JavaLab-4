package contest;

import java.util.Scanner;

public class Task6 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int l = scanner.nextInt();
        int r = scanner.nextInt();
        int p = scanner.nextInt();
        long result = 0;
        for (int x = l; x <= r; x++) {
            result += modularInverse(x, p);
            result %= p;
        }
        System.out.println(result);
    }

    private static long modularInverse(int x, int p) {
        long result = 1L;
        long n = p - 2;
        while (n > 0) {
            if ((n & 1) == 1) {
                result *= x % p;
            }
            x *= x % p;
            n >>= 1;
        }
        return result;
    }
}
