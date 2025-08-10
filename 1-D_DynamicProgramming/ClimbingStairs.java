/*
You are given an integer n representing the number of steps to reach the top of a staircase. You can climb with either 1 or 2 steps at a time.
Return the number of distinct ways to climb to the top of the staircase.

Example 1:
Input: n = 2
Output: 2
Explanation:
1 + 1 = 2
2 = 2

Example 2:
Input: n = 3
Output: 3
Explanation:
1 + 1 + 1 = 3
1 + 2 = 3
2 + 1 = 3

Constraints:
1 <= n <= 30
*/

class Solution {
    int[] dp;
    public int climbStairs(int n) {
        dp = new int[n+1];
        // return recursive(n);
        // return memoized(n);
        return oneDp(n);
    }

    private int recursive(int n) {
        // if you have one step
        if (n == 1) return 1;
        // if you have two steps
        if (n == 2) return 2;

        int result = recursive(n-1)+recursive(n-2);
        return result;
    }

    private int memoized(int n) {
        if (n == 1) return 1;
        if (n == 2) return 2;
        if (dp[n] != 0) return dp[n];

        dp[n] = memoized(n-1) + memoized(n-2);
        return dp[n];
    }

    private int oneDp(int n) {
        if (n <= 1) return 1;
        dp[1] = 1;
        dp[2] = 2;
        for (int i=3;i<=n;i++) {
            dp[i] = dp[i-1] + dp[i-2];
        }

        return dp[n];
    }
}
