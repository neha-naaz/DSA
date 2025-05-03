package Stack;
/*
There are n cars traveling to the same destination on a one-lane highway.

You are given two arrays of integers position and speed, both of length n.

position[i] is the position of the ith car (in miles)
speed[i] is the speed of the ith car (in miles per hour)
The destination is at position target miles.

A car can not pass another car ahead of it. It can only catch up to another car and then drive at the same speed as the car ahead of it.

A car fleet is a non-empty set of cars driving at the same position and same speed. A single car is also considered a car fleet.

If a car catches up to a car fleet the moment the fleet reaches the destination, then the car is considered to be part of the fleet.

Return the number of different car fleets that will arrive at the destination.

Example 1:

Input: target = 10, position = [1,4], speed = [3,2]

Output: 1
Explanation: The cars starting at 1 (speed 3) and 4 (speed 2) become a fleet, meeting each other at 10, the destination.

Example 2:

Input: target = 10, position = [4,1,0,7], speed = [2,2,1,1]

Output: 3
Explanation: The cars starting at 4 and 7 become a fleet at position 10. The cars starting at 1 and 0 never catch up to the car ahead of them. Thus, there are 3 car fleets that will arrive at the destination.

Constraints:

n == position.length == speed.length.
1 <= n <= 1000
0 < target <= 1000
0 < speed[i] <= 100
0 <= position[i] < target
All the values of position are unique.
 */
import java.util.*;
public class CarFleet {
    // Intuition: the car behind can make car fleet with car ahead of it.
    // if the car behind takes time less than or equal to car ahead to reach destination its a car fleet
    // after car fleet the speed of the cars is car ahead of it
    public int carFleet(int target, int[] position, int[] speed) {
        int n = speed.length;
        // New pair arr to store and car and speed and sort it
        int[][] pair = new int[n][2];
        for(int i=0;i<n;i++) {
            pair[i][0] = position[i];
            pair[i][1] = speed[i];
        }
        Arrays.sort(pair, (a, b) -> Integer.compare(b[0], a[0]));

        // Stack to maintain no of fleets. it stores the time
        Stack<Double> st = new Stack<>();
        for(int[] p: pair) {
            st.push((double)(target - p[0])/p[1]);

            //check if curr car can have carfleet with car ahead.
            // if so pop as cars in fleet have speed of car ahead it.
            if(st.size()>=2 && st.peek()<=st.get(st.size() - 2)) {
                st.pop();
            }
        }
        return st.size();
    }
}

class ExecuteCarFleet {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        int n = sc.nextInt();
        int[] pos = new int[n];
        for(int i=0;i<n;i++) {
            pos[i] = sc.nextInt();
        }

        int[] speed = new int[n];
        for(int i=0;i<n;i++) {
            speed[i] = sc.nextInt();
        }

        CarFleet solObj = new CarFleet();
        System.out.println(solObj.carFleet(t, pos, speed));
    }
}
