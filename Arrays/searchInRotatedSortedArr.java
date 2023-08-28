package Arrays;
/*
TOPIC - BINARY SEARCH

Given a sorted and rotated array arr[] of size N and a key, the task is to find the key in the array.
Note: Find the element in O(logN) time and assume that all the elements are distinct.

Example:
Input  : arr[] = {5, 6, 7, 8, 9, 10, 1, 2, 3}, key = 3
Output : Found at index 8

Input  : arr[] = {5, 6, 7, 8, 9, 10, 1, 2, 3}, key = 30
Output : Not found

Input : arr[] = {30, 40, 50, 10, 20}, key = 10
Output : Found at index 3
 */
import java.util.*;
public class searchInRotatedSortedArr {
    public static int search(int arr[], int key) {
        int low = 0, high = arr.length-1;
        while(low<=high){
            int mid = low + (high-low)/2;
            if(arr[mid] == key) return mid;
                // checks if left part of mid-element is sorted or not
            else if(arr[low] <= arr[mid]){
                if(arr[low] <= key && arr[mid] > key) high = mid-1;
                else low = mid+1;
            }
            // now checking the right part is sorted or not
            else{
                if(arr[mid]<key && arr[high] >= key) low=mid+1;
                else high= mid - 1;
            }
        }
        return -1;
    }

    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int key = sc.nextInt();
        int[] arr = new int[n];
        for(int i=0;i<n;i++){
            arr[i] = sc.nextInt();
        }
        System.out.println(search(arr, key));
    }
}