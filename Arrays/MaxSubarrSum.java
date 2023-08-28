package Arrays;
/*
You are given an array 'arr' of length 'n', consisting of integers.
A subarray is a contiguous segment of an array. In other words, a subarray can be formed by removing 0 or more integers
from the beginning and 0 or more integers from the end of an array.
Find the sum of the subarray (including empty subarray) having maximum sum among all subarrays.
The sum of an empty subarray is 0.

Sample Input 1 :
9
1 2 7 -4 3 2 -10 9 1


Sample Output 1 :
11


Explanation For Sample 1 :
The subarray yielding the maximum sum is [1, 2, 7, -4, 3, 2].


Sample Input 2 :
6
10 20 -30 40 -50 60


Sample Input 2 :
60


Sample Input 3 :
3
-3 -5 -6


Sample Input 3 :
0


Expected Time Complexity :
The expected time complexity is O(n).
 */
public class MaxSubarrSum {
    private static long crossSum(int[] arr, int low, int high, int mid) {
        if (low == high) {
            return arr[low];
        }

        long leftSubsum = 0;
        long currSum = 0;

        // maximum subarray sum by including elements on left of mid.
        for (int i = mid; i > low - 1; --i) {
            currSum += arr[i];
            leftSubsum = Math.max(leftSubsum, currSum);
        }

        long rightSubsum = 0;
        currSum = 0;

        // maximum subarray sum by include elements on right of mid.
        for (int i = mid + 1; i < high + 1; ++i) {
            currSum += arr[i];
            rightSubsum = Math.max(rightSubsum, currSum);
        }

        return leftSubsum + rightSubsum;
    }

    private static long maxSubarraySumHelper(int[] arr, int low, int high) {
        // if there is only one element.
        if (low == high) {
            return arr[low];
        }

        int mid = (low + high) / 2;

        // left maximum subarray sum
        long leftSum = maxSubarraySumHelper(arr, low, mid);

        // right maximum subarray sum
        long rightSum = maxSubarraySumHelper(arr, mid + 1, high);

        // Maximum subarray sum such that the subarray crosses the midpoint.
        long crossS = crossSum(arr, low, high, mid);

        return Math.max(Math.max(leftSum, rightSum), crossS);
    }


    public static long maxSubarraySum(int[] arr, int n) {
        return maxSubarraySumHelper(arr, 0, n - 1);
    }
}
