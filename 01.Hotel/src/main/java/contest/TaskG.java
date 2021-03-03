package contest;

import java.util.Arrays;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Scanner;

public class TaskG {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int m = scanner.nextInt();
        String[] orders = new String[m];
        scanner.nextLine();
        for (int i = 0; i < m; i++) {
            orders[i] = scanner.nextLine();
        }
        scanner.close();
        Arrays.sort(orders, Comparator.comparing(s -> s.split(" ")[0]));

        HashMap<Integer, String> availableAt = new HashMap<>();

        int usedCouriers = 0;

        for (int orderId = 0; orderId < m; orderId++) {
            int availableCourier = -1;
            for (int courierId = 0; courierId < m; courierId++) {
                if (availableAt.getOrDefault(courierId, "00:00:00").compareTo(orders[orderId].split(" ")[0]) <= 0) {
                    availableCourier = courierId;
                    break;
                }
            }
            if (availableAt.get(availableCourier) == null) {
                usedCouriers++;
            }

            availableAt.put(availableCourier, orders[orderId].split(" ")[1]);
        }

        System.out.println(usedCouriers);
    }
}
