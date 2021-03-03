package contest;

import java.math.BigInteger;
import java.util.Scanner;

public class TaskJ {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String s = scanner.next();
        scanner.close();
        int len = s.length();
        for (int i = 0; i < len - 2; i++) {
            for (int j = i + 1, k = len - 1; j < k; k--) {
                String a = s.substring(0, j);
                String b = s.substring(j, k);
                String c = s.substring(k, len);
                if (new BigInteger(a).add(new BigInteger(b)).equals(new BigInteger(c))) {
                    System.out.println(a + "+" + b + "=" + c);
                    System.exit(0);
                }
            }
        }
    }
}

