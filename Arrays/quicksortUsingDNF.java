package Arrays;
/*
TOPIC - DUTCH NATIONAL FLAG ALGORITHM, SORTING, QUICK SORT

You are given an array/list of integers. Sort them by applying quick sort but by using Dutch National Flag Algorithm
 */
import java.util.*;
public class quicksortUsingDNF {
    private static void swap(ArrayList<Integer> arr, int i, int j){
        int temp = arr.get(i);
        arr.set(i, arr.get(j));
        arr.set(j, temp);
    }
    private static void sort(ArrayList<Integer> arr, int left, int right){
        if(left < right){
            int low = left, high = right, mid = left, pivot = arr.get(low);
            while(mid <= high){
                if(arr.get(mid) < pivot){
                    swap(arr, low, mid);
                    low++;
                    mid++;
                }
                else if(arr.get(mid) > pivot){
                    swap(arr, mid, high);
                    high--;
                }
                else{
                    mid++;
                }
            }
            sort(arr, left, low-1);
            sort(arr, high+1, right);
        }
    }
    public static ArrayList<Integer> quickSortUsingDutchNationalFlag(ArrayList<Integer> arr) {
        int left = 0, right = arr.size()-1;
        sort(arr, left, right);
        return arr;
    }

    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int n =sc.nextInt();
        ArrayList<Integer> arr = new ArrayList<>();
        for(int i=0;i<n;i++){
            int val = sc.nextInt();
            arr.add(val);
        }
        System.out.println(quickSortUsingDutchNationalFlag(arr));
    }
}
