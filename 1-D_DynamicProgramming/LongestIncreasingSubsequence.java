/*
Given an integer array nums, return the length of the longest strictly increasing subsequence.
A subsequence is a sequence that can be derived from the given sequence by deleting some or no 
elements without changing the relative order of the remaining characters.
For example, "cat" is a subsequence of "crabt".

Example 1:
Input: nums = [9,1,4,2,3,3,7]
Output: 4
Explanation: The longest increasing subsequence is [1,2,3,7], which has a length of 4.

Example 2:
Input: nums = [0,3,1,3,2,3]
Output: 4

Constraints:
1 <= nums.length <= 1000
-1000 <= nums[i] <= 1000
*/

class LongestIncreasingSubsequence {
    public int lengthOfLIS(int[] nums) {
        int[] dp = new int[nums.length];
        Arrays.fill(dp, 1);
        for (int i=0;i<nums.length;i++) {
            for (int j=0;j<i;j++) {
                if (nums[j] < nums[i]) {
                    dp[i] = Math.max(dp[i], dp[j]+1); 
                }
            }
        }
        return Arrays.stream(dp).max().getAsInt();
    }

    public int bruteForceApproach(int[] nums) {
        return dfs(nums, 0, -1);
    }

    private int dfs(int[] nums, int ind, int prev) {
        if (ind == nums.length) return 0;

        int lis = dfs(nums, ind+1, prev);

        if (prev == -1 || nums[ind] > nums[prev]) {
          lis += Math.max(lis, 1+dfs(nums, ind+1, ind));
        }

        return lis;
    }
}
