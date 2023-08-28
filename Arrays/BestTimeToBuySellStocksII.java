package Arrays;
/*
You have been given stock values/ prices for n number of days. Every i-th day signifies the price of a stock on that day.
Your task is to find the maximum profit which you can make by buying and selling the stocks

Sample input 1:
1
7
1 2 3 4 5 6 7
Output:
6
Explanation:
We can make the maximum profit by buying the stock on the first day and selling it on the last day.

Sample input 2:
1
7
7 6 5 4 3 2 1
Output:
0
Explanation:
We can make the maximum profit by not buying the stock.
 */
public class BestTimeToBuySellStocksII {
    public static long getMaximumProfit (int n, long[] values) {
        long profit = 0;
        for(int i=1;i<n;i++){
            if(values[i] > values[i-1]){
                profit += (values[i] - values[i-1]);
            }
        }
        return profit;
    }
}
