package contest;

import java.util.Scanner;

public class OptimizedG {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int m = scanner.nextInt();
        String[][] orders = new String[m][2];
        scanner.nextLine();
        for (int i = 0; i < m; i++) {
            orders[i] = scanner.nextLine().split(" ");
        }
        scanner.close();
        /*Arrays.sort(orders, Comparator.comparing(s -> s[0]));

        HashMap<Integer, String> availableAt = new HashMap<>();

        int usedCouriers = 0;

        for (int orderId = 0; orderId < m; orderId++) {
            int availableCourier = -1;
            for (int courierId = 0; courierId < m; courierId++) {
                if (availableAt.getOrDefault(courierId, "00:00:00").compareTo(orders[orderId][0]) <= 0) {
                    availableCourier = courierId;
                    break;
                }
            }
            if (availableAt.get(availableCourier) == null) {
                usedCouriers++;
            }

//            System.out.println("availableAt = " + Arrays.toString(availableAt));
            availableAt.put(availableCourier, orders[orderId][1]);
        }

        System.out.println(usedCouriers);*/
    }
}
