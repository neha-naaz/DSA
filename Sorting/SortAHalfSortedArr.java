package Sorting;
/*
You are given an arbitrary array of integers of size ‘N’ which consists of two partitions sorted in non-decreasing order.
You need to sort the entire array in ascending order. In other words, given an array of integers in which elements are
divided into two partitions such that both the partitions are individually sorted, you need to sort the entire array

Sample Input 1:
1
5
1 5 2 3 6
Sample Output 1:
1 2 3 5 6
Explanation For Sample Input 1:
The given array can be broken into two sorted partitions as P1={1, 5} and P2={2, 3, 6}. After sorting the entire array in ascending order, we get {1, 2,3, 5, 6}.
Sample Input 2:
1
7
2 3 8 1 7 10 15
Sample Output 2:
1 2 3 7 8 10 15
 */

import java.util.ArrayList;
public class SortAHalfSortedArr {
    public static void sortHalfSorted(ArrayList<Integer> arr) {
        // Write your code here.
        int partition_ind = 1;
        int ind = 0, n = arr.size();

        while(partition_ind < n && arr.get(partition_ind-1) <= arr.get(partition_ind)){
            partition_ind++;
        }

        if(partition_ind == n)return;

        int[] result = new int[n];

        sort(result, arr, partition_ind, 0, 0, partition_ind, n);

        arr.clear();

        for(int num: result){
            arr.add(num);
        }

    }

    private static void sort(int[] result, ArrayList<Integer> arr, int partition_ind,
            int res_ind, int ind1, int ind2, int n){
        while(res_ind < n && ind1 < partition_ind && arr.get(ind1) <= arr.get(ind2)){
            result[res_ind++] = arr.get(ind1++);
        }

        while(res_ind < n && ind2 < n && arr.get(ind2) <= arr.get(ind1)){
            result[res_ind++] = arr.get(ind2++);
        }

        while(res_ind < n && ind1 >= partition_ind && ind2 < n){
            result[res_ind++] = arr.get(ind2++);
        }

        while(res_ind < n && ind2 >= n && ind1 < partition_ind){
            result[res_ind++] = arr.get(ind1++);
        }

        if(ind1 < partition_ind && ind2 < n){
            sort(result, arr, partition_ind, res_ind, ind1, ind2, n);
        }
    }
}
