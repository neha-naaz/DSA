/*
Given an integer array nums, return true if you can partition the array into two subsets such that the sum of the elements in both subsets 
is equal or false otherwise.

Example 1:
Input: nums = [1,5,11,5]
Output: true
Explanation: The array can be partitioned as [1, 5, 5] and [11].

Example 2:
Input: nums = [1,2,3,5]
Output: false
Explanation: The array cannot be partitioned into equal sum subsets.
 
Constraints:
1 <= nums.length <= 200
1 <= nums[i] <= 100
*/

class PartitionEqualSubsetSum {
    // Time complexity: O(n * target)
    // Space Complexity: O(n)
    public boolean canPartition(int[] nums) {
        int arrSum = 0;
        for (int num: nums) arrSum += num;
        if (arrSum %2 != 0) return false;
        int targetSum = arrSum / 2;
        boolean dp[] = new boolean[targetSum + 1];
        dp[0] = true;
        for (int num: nums) {
            System.out.println();
            for (int cs = targetSum; cs >= num; cs--) {
                dp[cs] = dp[cs] || dp[cs - num];
            }
        }
        return dp[targetSum];
    }

    public boolean canPartitionRecursion(int[] nums) {
        int arrSum = 0;
        for (int num: nums) arrSum += num;
        if (arrSum %2 != 0) return false;
        int targetSum = arrSum / 2;
        return dfs(nums, 0, targetSum);
    }

    private boolean dfs(int[] nums, int i) {
        if (i == nums.length) return target == 0;

        if (target < 0 ) return false;

        return dfs(nums, i+1, target) || dfs(nums, i+1, target - nums[i]);
        
    }
}
