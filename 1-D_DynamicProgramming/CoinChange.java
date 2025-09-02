/*
You are given an integer array coins representing coins of different denominations (e.g. 1 dollar, 5 dollars, etc) and an integer amount representing a target amount of money.
Return the fewest number of coins that you need to make up the exact target amount. If it is impossible to make up the amount, return -1.
You may assume that you have an unlimited number of each coin.

Example 1:
Input: coins = [1,5,10], amount = 12
Output: 3
Explanation: 12 = 10 + 1 + 1. Note that we do not have to use every kind coin available.

Example 2:
Input: coins = [2], amount = 3
Output: -1
Explanation: The amount of 3 cannot be made up with coins of 2.

Example 3:
Input: coins = [1], amount = 0
Output: 0
Explanation: Choosing 0 coins is a valid way to make up 0.

Constraints:
1 <= coins.length <= 10
1 <= coins[i] <= 2^31 - 1
0 <= amount <= 10000
*/

class CoinChange {
    /* 
        To make amount a, pick a coin c.
        Then you must have already made a - c.
        The total coins = coins for (a - c) + 1 (the coin c itself).
        Take the minimum over all coins.
    */
    public int coinChange(int[] coins, int amount) {
        if (amount == 0) return 0;
        int[] dp = new int[amount+1];
        Arrays.fill(dp, Integer.MAX_VALUE);
        // for amount 0 min coins reqd is 0
        dp[0] = 0;
        for (int i=1;i<=amount;i++) {
            for (int c: coins) {
                if (i-c >= 0 && dp[i-c] != Integer.MAX_VALUE) {
                    dp[i] = Math.min(dp[i], dp[i-c]+1);
                }
            }
        }
        if (dp[amount] == Integer.MAX_VALUE) return -1;
        else return dp[amount];
    }
}
