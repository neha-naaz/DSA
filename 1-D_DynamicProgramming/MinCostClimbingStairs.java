/*
You are given an array of integers cost where cost[i] is the cost of taking a step from the ith floor of a staircase. 
After paying the cost, you can step to either the (i + 1)th floor or the (i + 2)th floor.
You may choose to start at the index 0 or the index 1 floor.
Return the minimum cost to reach the top of the staircase, i.e. just past the last index in cost.

Example 1:
Input: cost = [1,2,3]
Output: 2
Explanation: We can start at index = 1 and pay the cost of cost[1] = 2 and take two steps to reach the top. The total cost is 2.

Example 2:
Input: cost = [1,2,1,2,1,1,1]
Output: 4
Explanation: Start at index = 0.
Pay the cost of cost[0] = 1 and take two steps to reach index = 2.
Pay the cost of cost[2] = 1 and take two steps to reach index = 4.
Pay the cost of cost[4] = 1 and take two steps to reach index = 6.
Pay the cost of cost[6] = 1 and take one step to reach the top.
The total cost is 4.

Constraints:
2 <= cost.length <= 100
0 <= cost[i] <= 100
*/

class Solution {
    public int minCostClimbingStairs1D_DP(int[] cost) {
        int[] dp = new int[cost.length+1];
        for(int i=2;i<=cost.length;i++) {
            dp[i] = Math.min(cost[i-1]+dp[i-1], cost[i-2]+dp[i-2]);
        }
        return dp[cost.length];
    }
    public int minCostClimbingStairs_Recursive(int[] cost) {
        return Math.min(recursive(0, cost), recursive(1, cost));
    }
    private int recursive(int i, int[] cost) {
      if (i >= cost.length) return 0;
      return cost[i] + Math.min(dfs(i+1, cost), dfs(i+2, cost));
    }
    public int minCostClimbingStairs1D_DP(int[] cost) {
        int[] dp = new int[cost.length+1];
        memoized(dp, 0, cost);
    }
}
