package contest;

/**
 * @author Shamil Nurkaev @nshamil
 * 11-903
 * Homework
 */

public class Task {
    public static void main(String[] args) {
//# read input:
//# read number of orders to deliver from first row of the input into m
//# read start and finish timestamps from each next row in input
//# and store them in an m*2 array called orders
//# orders[i][0] - start of order i, orders[i][1] - finish of order i
//# it is known that for each order i that: orders[i][0] < orders[i][1]
//
//1.  available_at - [0..m-1] array of timestamps, initialized with 00:00:00
//2.  sort orders in increasing order of start timestamps
//3.
//4.  used_couriers = 0  // count of couriers delivering at least one order
//5.
//6.  for order_id from 0 to m - 1:
//7.    available_courier = -1
//8.
//9.    for courier_id from 0 to m - 1:
//10.      if available_at[courier_id] <= orders[order_id][0]:
//11.        available_courier = courier_id  // save available courier found
//12.       break
//13.
//14.   if available_at[available_courier] == ’00:00:00’:
//15.     used_couriers += 1 // assign order to a new courier
//16.
//17.   available_at[available_courier] = orders[order_id][0] // update time of availability
//18.
//19. return used_couriers
    }
}
