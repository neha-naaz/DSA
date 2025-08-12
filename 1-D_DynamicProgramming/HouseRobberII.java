/*
You are given an integer array nums where nums[i] represents the amount of money the ith house has. 
The houses are arranged in a circle, i.e. the first house and the last house are neighbors.
You are planning to rob money from the houses, but you cannot rob two adjacent houses because the 
security system will automatically alert the police if two adjacent houses were both broken into.
Return the maximum amount of money you can rob without alerting the police.

Example 1:
Input: nums = [3,4,3]
Output: 4
Explanation: You cannot rob nums[0] + nums[2] = 6 because nums[0] and nums[2] are adjacent houses. The maximum you can rob is nums[1] = 4.

Example 2:
Input: nums = [2,9,8,3,6]
Output: 15
Explanation: You cannot rob nums[0] + nums[2] + nums[4] = 16 because nums[0] and nums[4] are adjacent houses. The maximum you can rob is nums[1] + nums[4] = 15.

Constraints:
1 <= nums.length <= 100
0 <= nums[i] <= 100
*/

class HouseRobberII {
  // Intuition: to avoid robbing from first n last, consider houses from first to last second house and second to last house. take the max of both
    public int rob(int[] nums) {
        int n = nums.length;
        if (n == 1) return nums[0];
        if (n == 2) return Math.max(nums[0], nums[1]);
        int[] dp1 = new int[nums.length-1];
        int[] dp2 = new int[nums.length-1];

        dp1[0] = nums[0];
        dp1[1] = Math.max(nums[0], nums[1]);
        for(int i=2;i<n-1;i++) {
            dp1[i] = Math.max(dp1[i-1], nums[i]+dp1[i-2]);
        }

        dp2[0] = nums[1];
        dp2[1] = Math.max(nums[1], nums[2]);
        for(int i=2;i<n-1;i++) {
            dp2[i] = Math.max(dp2[i-1], nums[i+1]+dp2[i-2]);
        }
        return Math.max(dp1[n-2], dp2[n-2]);
    }
}
