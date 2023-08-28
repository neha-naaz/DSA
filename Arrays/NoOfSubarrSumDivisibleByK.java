package Arrays;

/*
TOPIC - PRE-FIX-SUM AND SUFFIX SUM

Given an array ARR and an integer K, your task is to find all the count of all sebares who sum is divisible by the given Integer k.

Sample input 1:
2
3 2
2 3 1
4 1
1 2 3 4
Output:
3
10
Explanation:
Test Case 1:

Given ‘ARR’ is { 2, 3,1 } and ‘K’ is ‘2’.
All the sub-array with sum is divided by ‘K’ are -
{ 2 }  because the sum is 2 and sum 2 is divisible by 2
{ 3, 1 } because the sum is 3 + 1 = 4 and sum 4 is divisible by 2.
{ 2, 3, 1 } because the sum is 2 + 3 + 1 = 6 and sum 6 is divisible by 2.

Hence there is a total of three subarrays that has sum divisible by 2.


Test Case 2:

Given ‘ARR’ is { 1, 2, 3, 4 } and ‘K’ is ‘1’.
Given ‘K’ is 1 that’s why each and every sub-arrays sum will be divisible by ‘1’ and with the size of ‘4’ array total number of subarray possible is ‘( 4*5 /2 ) = 20/2 = 10’.
All possible subarray -
{ 1 }, { 2 }, { 3 }, { 4 }, { 1, 2 }, { 2, 3 }, { 3, 4 }, { 1, 2, 3 }, { 2, 3, 4 }, { 1, 2, 3, 4 } and all subarray sum is divisible by ‘1’.
Hence there are overall 10 subarrays that has sum divisible by ‘1’.

Sample input 2:
2
4 3
1 4 5 2
3 2
1 1 2
Output:
2
3
 */

import java.util.*;
public class NoOfSubarrSumDivisibleByK {
    public static int subArrayCount(ArrayList < Integer > arr, int k) {
        // Write your code here.
        Map<Integer, Integer> map = new HashMap();
        map.put(0, 1);
        int sum = 0, count = 0;
        for(int num: arr){
            sum = (sum+num)%k;
            if(sum < 0)sum += k;
            count += map.getOrDefault(sum, 0);
            map.put(sum, map.getOrDefault(sum, 0)+1);
        }
        return count;
    }
}
