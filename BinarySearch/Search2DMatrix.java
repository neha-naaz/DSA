package BinarySearch;

import java.util.Scanner;

/*
You are given an m x n 2-D integer array matrix and an integer target.
Each row in matrix is sorted in non-decreasing order.
The first integer of every row is greater than the last integer of the previous row.
Return true if target exists within matrix or false otherwise.
Can you write a solution that runs in O(log(m * n)) time?

Example 1:
Input: matrix = [[1,2,4,8],[10,11,12,13],[14,20,30,40]], target = 10
Output: true

Example 2:
Input: matrix = [[1,2,4,8],[10,11,12,13],[14,20,30,40]], target = 15
Output: false


Constraints:
m == matrix.length
n == matrix[i].length
1 <= m, n <= 100
-10000 <= matrix[i][j], target <= 10000
 */
public class Search2DMatrix {
    // T : O(m * log(n))
    public boolean searchMatrix(int[][] matrix, int target) {
        int m = matrix.length, n = matrix[0].length;
        for(int i=0;i<m;i++) {
            if(binarySearch1(matrix[i], target))return true;
        }
        return false;
    }
    //intuition is we would perform a binary search just to find the row in which the target potentially
    // might be there and then for the corresponding row we'd perform another binary search to find the target
    // T: O(logm) + O(logn) = O(logm * logn)
    public class Solution {
        public boolean searchMatrix(int[][] matrix, int target) {
            int ROWS = matrix.length;
            int COLS = matrix[0].length;

            int top = 0, bot = ROWS - 1;
            while (top <= bot) {
                int row = (top + bot) / 2;
                if (target > matrix[row][COLS - 1]) {
                    top = row + 1;
                } else if (target < matrix[row][0]) {
                    bot = row - 1;
                } else {
                    break;
                }
            }

            if (!(top <= bot)) {
                return false;
            }
            int row = (top + bot) / 2;
            int l = 0, r = COLS - 1;
            while (l <= r) {
                int m = (l + r) / 2;
                if (target > matrix[row][m]) {
                    l = m + 1;
                } else if (target < matrix[row][m]) {
                    r = m - 1;
                } else {
                    return true;
                }
            }
            return false;
        }
    }

    // binary search one pass
    // consider all the m*n elements as a single array where we have an array with m*n elements. we would have
    // indices from 0 to m*n - 1 and we would calculate the corresponding index for the element in the matrix
    private boolean binarySearch1(int[] matrix, int t) {
        int low = 0, high = matrix.length - 1;
        while(low <= high) {
            int mid = (low+high)/2;
            if(matrix[mid] == t)return true;
            else if(matrix[mid] < t)low = mid+1;
            else high = mid-1;
        }
        return false;
    }
}

class ExecuteSearch2DMatrix {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int m = sc.nextInt();
        int n = sc.nextInt();
        int[][] arr = new int[m][n];
        for(int i=0;i<m;i++) {
            for(int j=0;j<n;j++) {
                arr[i][j] = sc.nextInt();
            }
        }
        int t = sc.nextInt();

        Search2DMatrix solObj = new Search2DMatrix();
        System.out.println(solObj.searchMatrix(arr, t));
    }
}
