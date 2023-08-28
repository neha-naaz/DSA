package Arrays;

/*
TOPIC - KADANE'S ALGORITHM

Given an array A[] consisting of 0’s and 1’s. A flip operation is one in which you turn 1 into 0 and a 0 into 1.
You have to do at most one “Flip” operation of any subarray. Formally, select a range (l, r) in the array A[],
such that (0 ≤ l ≤ r < n) holds and flip the elements in this range to get the maximum ones in the final array.
You can possibly make zero operations to get the answer.
Example 1:
Input:
N = 5
A[] = {1, 0, 0, 1, 0}
Output:
4
Explanation:
We can perform a flip operation in the range [1,2]
After flip operation array is : [ 1 1 1 1 0 ]
Count of one after fliping is : 4
[Note: the subarray marked in bold is the flipped subarray]
Example 2:
Input:
N = 7
A[] = {1, 0, 0, 1, 0, 0, 1}
Output:
6
Explanation:
We can perform a flip operation in the range [1,5]
After flip operation array is : [ 1 1 1 0 1 1 1]
Count of one after fliping is : 6
[Note: the subarray marked in bold is the flipped subarray]
Your Task:
You don't need to read input or print anything. Your task is to complete the function maxOnes() which takes the array
A[] and its size N as inputs and returns the maximum number of 1's you can have in the array after atmost one flip operation.
Expected Time Complexity: O(N)
Expected Auxiliary Space: O(1)
 */

import java.util.*;

public class FlipBits {
    public static int flipBits(int[] arr,int n) {
		/* Here the approach is to find subsequence
		 containing most number of zeroes and flip
		 that subsequence*/

        int zeros = 0, ones = 0, max_zeros = 0;
        for(int i=0;i<n;i++){

            if(arr[i] == 1){ ones++; }

            if(zeros < 0){ zeros = 0; }

            if(arr[i] == 0){ zeros++; }
            else{ zeros--; }

            max_zeros = Math.max(zeros, max_zeros);
        }
        return max_zeros+ones;
    }

    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] arr = new int[n];
        for(int i=0;i<n;i++){
            arr[i] = sc.nextInt(0);
        }
        System.out.println(flipBits(arr, n));
    }

}
