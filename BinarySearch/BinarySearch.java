package BinarySearch;

import Stack.DailyTemperatures;
import java.util.Arrays;
import java.util.Scanner;

public class BinarySearch {
    public int search(int[] nums, int target) {
        int st = 0, end = nums.length-1;
        while(st <= end) {
            int mid = st + (end-st)/2;
            if(nums[mid] == target)return mid;
            else if(nums[mid] < target) {
                st = mid+1;
            } else {
                end = mid-1;
            }
        }
        return -1;
    }
}

class ExecuteBinarySearch {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] arr = new int[n];
        for(int i=0;i<n;i++) {
            arr[i] = sc.nextInt();
        }
        int t = sc.nextInt();

        BinarySearch solObj = new BinarySearch();
        System.out.println(solObj.search(arr, t));
    }
}
