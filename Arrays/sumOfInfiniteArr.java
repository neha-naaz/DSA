package Arrays;
/*
TOPIC - PREFIX SUM

Sample Input 1 :
1
3
1 2 3
2
1 3
1 5
Sample Output 1 :
6 9
For the first test case, the given array A is [1,2,3] therefore the infinite array “B” will be
[1,2,3,1,2,3,1,2,3,.......]. So the answer for the given first query is 6 because the sum of
the sub-array from index 1 to 3 of infinite array “B” i.e. (B[1]+B[2]+B[3]) is 6.
For the given second query is 9 because the sum of the sub-array from index 1 to 5 of array “B” .ie
(B[1]+B[2]+B[3]+B[4]+B[5]) is 9.

Sample Input 2 :
1
4
5 2 6 9
3
1 5
10 13
7 11
Sample Output 2 :
27 22 28
 */
import java.util.*;
public class sumOfInfiniteArr {
    static int mod = (int) 1e9 + 7;
    public static long sum (long prefix[], long length, long index) {
        long cnt = (index / length) % mod;
        long res = (cnt * prefix[(int) length]) % mod;
        res = (res + prefix[(int) (index % length)]) % mod;
        return res;
    }

    public static List<Integer> sumInRanges(int[] arr, int n, List<List<Long>> queries, int q) {
        List<Integer> ans = new ArrayList<>();
        long prefix[] = new long[n + 1];
        for (int i = 1; i < prefix.length; i++)
            prefix[i] = (arr[i-1] + prefix[i-1]) % mod;
        for (List<Long> range: queries) {
            long l = range.get(0);
            long r = range.get(1);
            long rsum = sum(prefix, n, r);
            long lsum = sum(prefix, n, l-1);
            int res = (int)(rsum - lsum + mod) % mod;
            ans.add(res);
        }
        return ans;
    }
}
