package Arrays;

import java.util.Arrays;
import java.util.Scanner;

/*
TOPIC - BINARY SEARCH

Given a sorted array of distinct integers and a target value, return the index if the target is found. If not, return
the index where it would be if it were inserted in order.
You must write an algorithm with O(log n) runtime complexity.

Example 1:
Input: nums = [1,3,5,6], target = 5
Output: 2

Example 2:
Input: nums = [1,3,5,6], target = 2
Output: 1
Example 3:

Input: nums = [1,3,5,6], target = 7
Output: 4


Constraints:

1 <= nums.length <= 104
-104 <= nums[i] <= 104
nums contains distinct values sorted in ascending order.
-104 <= target <= 104
 */
public class searchInsertPosition {
    public static int searchInsert(int [] arr, int target){
        int low=0, high=arr.length-1, mid=0;
        while(low <= high)
        {
            mid = (low+high)/2;
            if(arr[mid] == target){
                return mid;
            }
            else if(arr[mid] < target){
                low = mid+1;
            }
            else if(arr[mid] > target){
                high = mid - 1;
            }
        }
        if(arr[mid] > target)
        {
            return mid;
        }
        else
        {
            return mid+1;
        }
    }
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int key = sc.nextInt();
        int[] arr = new int[n];
        for(int i=0;i<n;i++){
            arr[i] = sc.nextInt();
        }
        System.out.println(searchInsert(arr, key));
    }
}
