package Arrays;
/*
TOPIC - PREFIX SUM AND SUFFIX SUM

You have been given an array of integers ARR of size N. You have to return array such that arr[i] is equal to product of all the elements except it's self

Sample input 1:
2
3
1 2 3
3
5 2 2
Output:
6 3 2
4 10 10
Explanation:
Test case 1 : Given array = {1, 2, 3]
 Required array = [2 * 3, 1 * 3, 1 * 2] = [6, 3, 2]
 Test case 2 : Given array = {5, 2, 2]
 Required array = [2 * 2, 5 * 2, 5 * 2] = [4, 10, 10]

Sample input 2:
2
1
100
2
1 2
Output:
1
2 1
 */

import java.util.*;

public class productOfArrayExceptSelf {
    static int mod = (int)(1e9+7);

    public static int[] getProductArrayExceptSelf(int[] arr) {

        //Your code goes here
        if (arr.length==0) {
            return new int[]{};
        }
        int[] res = new int[arr.length];
        res[0]=1;
        for (int i=1;i<arr.length;i++) {
            res[i] = (int)(((long)res[i-1]*arr[i-1])%mod);
        }
        int val = (arr[arr.length-1])%mod;
        for (int i=arr.length-2;i>=0;i--) {
            res[i] = (int)(((long)res[i]*val)%mod);
            val = (int)(((long)val*arr[i])%mod);
        }
        return res;
    }
    public static int[] productExceptSelf(int[] nums) {
        int n = nums.length, prod = 1;
        int[] prefix = new int[n];
        int[] suffix = new int[n];

        prefix[0] = 1;
        for(int i=1;i<n;i++) {
            prod *= nums[i-1];
            prefix[i] = prod;
        }

        prod = 1;
        suffix[n-1] = 1;
        for(int i=n-2;i>=0;i--) {
            prod *= nums[i+1];
            suffix[i] = prod;
        }

        int[] result = new int[n];
        for(int i=0;i<n;i++) {
            result[i] = prefix[i]*suffix[i];
        }

        return result;
    }

    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] arr = new int[n];
        for(int i=0;i<n;i++){
            arr[i] = sc.nextInt();
        }

        System.out.println(Arrays.toString(productExceptSelf(arr)));
    }
}
