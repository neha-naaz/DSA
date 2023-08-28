package Arrays;
/*
TOPIC - KADANE'S ALGORITHM

    Given a 2D matrix M of dimensions RxC. Find the maximum sum sub-matrix in it.
    Example 1:
    Input:
    R=4
    C=5
    M=[[1,2,-1,-4,-20],
    [-8,-3,4,2,1],
    [3,8,10,1,3],
    [-4,-1,1,7,-6]]
    Output:
    29
    Explanation:
    The matrix is as follows and the
    blue rectangle denotes the maximum sum
    rectangle.
    Thumbnail
    Example 2:
    Input:
    R=2
    C=2
    M=[[-1,-2],[-3,-4]]
    Output:
    -1
    Explanation:
    Taking only the first cell is the
    optimal choice.
    Your Task:
    You don't need to read input or print anything. Your task is to complete the function MaxSumRectangle() which takes
    the number R, C, and the 2D matrix M as input parameters and returns the maximum sum sub-matrix.
    Expected Time Complexity:O(R*R*C)
    Expected Auxillary Space:O(R*C)
    Constraints:
    1<=R,C<=500
    -1000<=M[i][j]<=1000
 */

import java.util.*;

public class MaxSumRectangle {
    public static int maxSumRectangle(int[][] arr, int n, int m)
    {
        // Write your code here.
        int[] temp = new int[n];
        int max_sum = Integer.MIN_VALUE;
        for(int c1 = 0;c1 < m;c1++){
            Arrays.fill(temp, 0);
            for(int c2 = c1;c2 < m;c2++){
                for(int i=0;i<n;i++){
                    temp[i] += arr[i][c2];
                }
                int currMaxSum = kadane(temp);
                max_sum = Math.max(currMaxSum, max_sum);
            }
        }
        return max_sum;
    }
    private static int kadane(int[] arr){
        int max_sum = Integer.MIN_VALUE, curr_sum = 0;
        for(int i=0;i<arr.length;i++){
            curr_sum += arr[i];
            max_sum = Math.max(max_sum, curr_sum);
            if(curr_sum < 0)curr_sum = 0;
        }
        return max_sum;
    }
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        int[][] arr = new int[n][m];
        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                arr[i][j] = sc.nextInt();
            }
        }
        System.out.println(maxSumRectangle(arr, n, m));
    }
}
