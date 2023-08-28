package Arrays;
/*
You are given an array of an integer and two integers K and M.
You need to return true if the given array can be divided into pairs such that the sum of every pair gives remainder M
when divided by K. Otherwise you need to return false

Sample input 1:
1
4
2 1 5 7
9 3
Output:
True
Explanation:
Pairs will be {2,1} and {5,7} whose sums are 3 and 12 which will give remainder 3 when divided by 9.

Sample input 2:
1
5
6 6 3 0 0
9 3
Output:
False
Explanation:
As pairs would be {6, 6} and {3, 0}, but second 0 will not be able to make pair with any of the elements, thus it is not
possible to make valid pairs.
 */
import java.util.*;
public class validPairs {
    public static boolean isValidPair(int[] arr, int n, int k, int m)
    {
        if (n % 2 != 0) {
            return false;
        }
        Map<Integer, Integer> hm = new HashMap<>();
        for (int i = 0; i < n; i++) {
            int remainder = arr[i] % k;
            hm.put(remainder, hm.getOrDefault(remainder, 0) + 1);
        }
        for (int i = 0; i < n; i++) {
            int value = (m - arr[i] % k + k) % k;
            if (hm.containsKey(value)) {
                int frequency = hm.get(value);
                if (frequency > 0) {
                    hm.put(value, frequency - 1);
                } else {
                    return false;
                }
            }else {
                return false;
            }
        }
        return true;
    }
}
