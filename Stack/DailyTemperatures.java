package Stack;
/*
You are given an array of integers temperatures where temperatures[i] represents the daily temperatures on the ith day.

Return an array result where result[i] is the number of days after the ith day before a warmer temperature appears on a future day. If there is no day in the future where a warmer temperature will appear for the ith day, set result[i] to 0 instead.

Example 1:

Input: temperatures = [30,38,30,36,35,40,28]

Output: [1,4,1,2,1,0,0]
Example 2:

Input: temperatures = [22,21,20]

Output: [0,0,0]
Constraints:

1 <= temperatures.length <= 1000.
1 <= temperatures[i] <= 100
 */
import java.util.*;
public class DailyTemperatures {
    public int[] dailyTemperatures(int[] temp) {
        Stack<int[]> stack = new Stack<>();
        int[]res = new int[temp.length];
        for(int i=0;i<temp.length;i++) {
            while(!stack.isEmpty() && (temp[i] > stack.peek()[0])) {
                int[] t = stack.pop();
                res[t[1]] = i - t[1];
            }
            stack.push(new int[]{temp[i], i});
        }
        return res;
    }
}

class ExecuteDailyTemperatures {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] arr = new int[n];
        for(int i=0;i<n;i++) {
            arr[i] = sc.nextInt();
        }

        DailyTemperatures solObj = new DailyTemperatures();
        System.out.println(Arrays.toString(solObj.dailyTemperatures(arr)));
    }
}
