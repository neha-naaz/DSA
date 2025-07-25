package Arrays;

/*
MEDIUM

Given an integer array nums and an integer k, return the k most frequent elements within the array.
The test cases are generated such that the answer is always unique.
You may return the output in any order.

Example 1:
Input: nums = [1,2,2,3,3,3], k = 2
Output: [2,3]

Example 2:
Input: nums = [7,7], k = 1
Output: [7]

Constraints:
1 <= nums.length <= 10^4.
-1000 <= nums[i] <= 1000
1 <= k <= number of distinct elements in nums.
 */

import java.util.*;

public class topKFrequentElements {
    private static int[] topKFrequent(int[] nums, int k) {
        // Frequency map of elements
        Map<Integer, Integer> map = new HashMap<>();
        for(int i=0;i<nums.length;i++) {
            map.put(nums[i], map.getOrDefault(nums[i], 0)+1);
        }

        // Array of lists
        List<Integer>[] bucket = new List[nums.length+1];
        for(int i=0;i<bucket.length;i++) {
            bucket[i] = new ArrayList<>();
        }

        // freq mapped to elements
        for(Map.Entry<Integer, Integer> entry: map.entrySet()) {
            bucket[entry.getValue()].add(entry.getKey());
        }

        int n = nums.length;
        int index = 0;
        int[] res = new int[k];
        for (int i = bucket.length - 1; i > 0 && index < k; i--) {
            for (int num : bucket[i]) {
                res[index++] = num;
                if (index == k) {
                    return res;
                }
            }
        }

        return res;
    }

    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] arr = new int[n];
        for(int i=0;i<n;i++){
            arr[i] = sc.nextInt();
        }

        int k = sc.nextInt();

        System.out.println(Arrays.toString(topKFrequent(arr, k)));
    }
}
