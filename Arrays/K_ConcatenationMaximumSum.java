package Arrays;

import java.util.*;

/*
TOPIC - KADANE'S ALGORITHM

Given an integer array arr and an integer k, modify the array by repeating it k times.
For example, if arr = [1, 2] and k = 3 then the modified array will be [1, 2, 1, 2, 1, 2].
Return the maximum sub-array sum in the modified array. Note that the length of the sub-array can be 0 and its sum in
that case is 0. As the answer can be very large, return the answer modulo 109 + 7.
Example 1:
Input: arr = [1,2], k = 3
Output: 9
Example 2:
Input: arr = [1,-2,1], k = 5
Output: 2
Example 3:
Input: arr = [-1,-2], k = 7
Output: 0
Constraints:
1 <= arr.length <= 105
1 <= k <= 105
-104 <= arr[i] <= 104
 */

class K_ConcatenationMaximumSum {
    public static int kConcatenationMaxSum(int[] arr, int k) {
		/* Max sub-array sum gets bigger as k grows. with each new array, max_subarray_sum will increase by array_sum
		return (max_subarray_sum when k=2) + array_sum*(k-2) */

        // calculate sum of all elements of array
        long array_sum = 0, max_subarray_sum = 0;
        int n = arr.length;
        for(int i=0;i<arr.length;i++)array_sum += arr[i];

        if(k == 1){
            return kadane(arr);
        }

        // generate arr two times
        int[] arr2 = new int[arr.length*2];
        for(int i=-1;i<arr.length*2-1;i++)arr2[i+1] = arr[(i+1) % n];

        // calculate max sum subarray
        long curr_sum = 0;
        for(int i=0;i<arr2.length;i++){
            curr_sum = Math.max(curr_sum+(long)arr2[i], (long)arr2[i]);
            max_subarray_sum = Math.max(curr_sum, max_subarray_sum);
        }
        array_sum = array_sum > 0 ? array_sum*(k-2):0;
        return (int) ((max_subarray_sum + array_sum) % 1000000007);
    }

    private static int kadane(int[] arr){
        long max_sum = Integer.MIN_VALUE, curr_sum = 0;
        for(int i=0;i<arr.length;i++){
            if(curr_sum < 0)curr_sum = 0;
            curr_sum += arr[i];
            max_sum = Math.max(curr_sum, max_sum);
        }
        if(max_sum < 0)return 0;
        return (int)(max_sum % 1000000007);
    }

    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int k = sc.nextInt();
        int[] arr = new int[n];
        for(int i=0;i<n;i++){
            arr[i] = sc.nextInt();
        }
        System.out.println(kConcatenationMaxSum(arr, k));
    }
}
