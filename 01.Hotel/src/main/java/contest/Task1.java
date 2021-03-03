package contest;

import java.util.LinkedList;
import java.util.Scanner;

public class Task1 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int k = scanner.nextInt();
        int result = 0;
        LinkedList<Integer> increases = new LinkedList<>();
        for (int i = 0; i < n; i++) {
            int x = scanner.nextInt();
            int y = 1;
            while (x != 0) {
                increases.add((9 - x % 10) * y);
                y *= 10;
                x /= 10;
            }
        }
        increases.sort(Integer::compareTo);
        if (k > increases.size()) {
            k = increases.size();
        }
        for (int i = 0; i < k; i++) {
            result += increases.get(increases.size() - 1 - i);
        }
        System.out.println(result);
    }
}
