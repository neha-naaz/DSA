package Arrays;

/*
You are given an integer array arr of size and an integer as you are ask is to return the list of all pair of elements
such that each sum of elements of each pair equal s.
Each pair should be sorted the first value should be less than or equal to the second value
Return the list of pair sorted in non-decreasing order of their first value in case if two pairs have the same first
value the pair with the smaller second when you should come first

Sample input 1:
5 5
1 2 3 4 5
Output:
1 4
2 3
Explanation:
Here, 1 + 4 = 5
      2 + 3 = 5
Hence the output will be, (1,4) , (2,3).

Sample input 2:
5 0
2 -3 3 3 -2
Output:
-3 3
-3 3
-2 2

 */

import java.util.*;
public class pairSum {
    public static List<int[]> findPairSum(int[] arr, int s) {
        // Write your code here.
        HashMap<Integer,Integer> h=new HashMap<>();
        List<int[]> res=new ArrayList<>();
        for (int k : arr) {
            if (h.containsKey(s - k)) {
                int[] temp = new int[2];
                temp[0] = Math.min(k, s - k);
                temp[1] = Math.max(k, s - k);
                int count = h.get(s - k);
                for (int j = 0; j < count; j++) {
                    res.add(temp);
                }
            }
            h.put(k, h.getOrDefault(k, 0) + 1);
        }
        res.sort((x, y) -> x[0] - y[0]);
        return res;
    }
}
