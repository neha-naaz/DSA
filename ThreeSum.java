package TwoPinters;
/*
Given an integer array nums, return all the triplets [nums[i], nums[j], nums[k]] where nums[i] + nums[j] + nums[k] == 0, and the indices i, j and k are all distinct.

The output should not contain any duplicate triplets. You may return the output and the triplets in any order.

Example 1:

Input: nums = [-1,0,1,2,-1,-4]

Output: [[-1,-1,2],[-1,0,1]]
Explanation:
nums[0] + nums[1] + nums[2] = (-1) + 0 + 1 = 0.
nums[1] + nums[2] + nums[4] = 0 + 1 + (-1) = 0.
nums[0] + nums[3] + nums[4] = (-1) + 2 + (-1) = 0.
The distinct triplets are [-1,0,1] and [-1,-1,2].

Example 2:

Input: nums = [0,1,1]

Output: []
Explanation: The only possible triplet does not sum up to 0.

Example 3:

Input: nums = [0,0,0]

Output: [[0,0,0]]
Explanation: The only possible triplet sums up to 0.

Constraints:

3 <= nums.length <= 1000
-10^5 <= nums[i] <= 10^5
 */

import java.util.*;
class ThreeSum {
    // T: O(n^2) S: O(1)
    // Two pointer
    public List<List<Integer>> threeSum(int[] nums) {
        Arrays.sort(nums);
        List<List<Integer>> result = new ArrayList<>();
        int n = nums.length;
        for(int i=0;i<n;i++) {
            // since wr're sorting the array and target sum is zero for negative number corresponding pairs
            // that sum up to zero are already found
            if (nums[i] > 0) break;

            // avoid formation of duplicate triplets
            if(i>0 && nums[i] == nums[i-1])continue;

            int j = i+1, k = n-1;
            while(j < k) {
                // if triplet found
                if(nums[j]+nums[k] == -nums[i]) {
                    List<Integer> l = new ArrayList<>();
                    l.add(nums[i]);
                    l.add(nums[j]);
                    l.add(nums[k]);
                    result.add(l);
                    j++;
                    k--;
                    // skip duplicates
                    while(j<k && nums[j]==nums[j-1])j++;
                } else if(nums[j]+nums[k] > -nums[i]) {
                    k--;
                } else {
                    j++;
                }
            }
        }
        return result;
    }
}

class ExecuteThreeSum {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] arr = new int[n];
        for(int i=0;i<n;i++) {
            arr[i] = sc.nextInt();
        }

        ThreeSum solObj = new ThreeSum();
        System.out.println(solObj.threeSum(arr));
    }
}
