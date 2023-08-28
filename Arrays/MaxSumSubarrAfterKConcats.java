package Arrays;
/*
You have been given a vector/list 'ARR' consisting of ‘N’ integers. You are also given a positive integer ‘K’.
Let’s define a vector/list 'CONCAT' of size 'N * K' formed by concatenating 'ARR' ‘K’ times. For example, if 'ARR' = [0, -1, 2] and 'K' = 3, then 'CONCAT' is given by [0, -1, 2, 0, -1, 2, 0, -1, 2].
Your task is to find the maximum possible sum of any non-empty subarray (contagious) of 'CONCAT'.

Sample Input 1 :
2
2 3
1 3
3 2
1 -2 1
Sample Output 1 :
12
2
Sample Output 1 Explanation:
For the first test case, vector 'CONCAT' is obtained by concatenating vector [1, 3] three times.
'CONCAT' = [1, 3, 1, 3, 1, 3]

The subarray with a maximum sum of 12 is [1, 3, 1, 3, 1, 3].


For the second test case, vector 'CONCAT' is obtained by concatenating vector [1, -2, 1] two times.
'CONCAT' = [1, -2, 1, 1, -2, 1]

The subarray with a maximum sum of 2 is [1, 1].
Sample Input 2 :
1
2 3
-2 1
Sample Output 2 :
1
 */

import java.util.*;
/*
    Time Complexity: O(N)
    Space Complexity: O(1)

    where 'N' is the size of vector/list 'ARR'.
*/
public class MaxSumSubarrAfterKConcats {

    public static long kadane(ArrayList <Integer> arr, int n, int k)
    {
        long maxSum = Long.MIN_VALUE;
        long curSum = 0;

        for (int i = 0; i < n * k; i++)
        {
            curSum += arr.get(i % n);
            maxSum = Math.max(maxSum, curSum);
            if (curSum < 0)
            {
                curSum = 0;
            }
        }

        return maxSum;
    }

    public static long maxSubSumKConcat(ArrayList<Integer> arr, int n, int k) {
        long maxSubSum;

        if (k == 1)
        {
            maxSubSum = kadane(arr, n, k);

            return maxSubSum;
        }

        int arrSum = 0;

        for (int i = 0; i < n; i++)
        {
            arrSum += arr.get(i);
        }

        if (arrSum <= 0)
        {
            // Finding the maximum subarray sum for k = 2.
            maxSubSum = kadane(arr, n, 2);
        }
        else
        {
            // Finding the maximum subarray sum for k = 2.
            maxSubSum = kadane(arr, n, 2);
            maxSubSum += (long)(k - 2) * (long)arrSum;
        }

        return maxSubSum;
    }
}
