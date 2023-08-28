package Arrays;
/*
You are given an integer of Array/list of length N. You are supposed to return to if it is possible to construct at least one non degenerate triangle using values of Array/list as sides of the triangle, otherwise, return false

Sample input - 1:
2
5
4 2 1 3 2
5
5 2 7 3 15
Sample Output - 1:
YES
YES
Explanation Of Sample Input 1:
In the first test case, if we choose the sides as { 2,3,4} or {2,2,1} or {2,2,3} then it is possible to form a non-degenerate triangle.

In the second test case, if we choose sides as {5,3,7}, then it is possible to form a non-degenerate triangle.

Sample input - 2:
2
5
12 3 7 4 28
4
7 12 9 20
Sample Output - 2:
NO
YES
*/
import java.util.*;
public class formAtriangle {
    private static void merge(ArrayList<Integer> res, int low, int mid, int high){
        int n1 = (mid-low)+1, n2 = high - mid;
        int[] leftArr = new int[n1];
        int[] rightArr = new int[n2];
        for(int i=0;i<n1;i++)leftArr[i] = res.get(low+i);
        for(int i=0;i<n2;i++)rightArr[i] = res.get(mid+1+i);
        int left = 0, right = 0, k = low;
        while(left < n1 && right < n2){
            if(leftArr[left] <= rightArr[right]){
                res.set(k++, leftArr[left++]);
            }
            else{
                res.set(k++, rightArr[right++]);
            }
        }
        while(left < n1)res.set(k++, leftArr[left++]);
        while(right < n2)res.set(k++, rightArr[right++]);
    }
    private static void mergeSort(ArrayList<Integer> arr, int low, int high){
        if(low < high){
            int mid = low + (high - low)/2;
            mergeSort(arr, low, mid);
            mergeSort(arr, mid+1, high);
            merge(arr, low, mid, high);
        }
    }
    public static boolean possibleToMakeTriangle(ArrayList<Integer> arr){
        // Write your code here.
        mergeSort(arr, 0, arr.size()-1);
        int sum_of_two = arr.get(0) + arr.get(1);
        for(int i=2;i<arr.size();i++){
            sum_of_two = arr.get(i-2) + arr.get(i-1);
            if(sum_of_two > arr.get(i)){
                return true;
            }
        }
        return false;
    }
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        ArrayList<Integer> arr = new ArrayList<>();
        int n = sc.nextInt();
        for(int i=0;i<n;i++){
            int val = sc.nextInt();
            arr.add(val);
        }
        System.out.println(possibleToMakeTriangle(arr));
    }
}
