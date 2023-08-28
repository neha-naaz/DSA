package Sorting;
/*
A binary array is an array consisting of only 0s and 1s.
You are given a binary array "arr" of size ‘N’. Your task is to sort the given array and return this array after sorting

Sample Input 1 :
2
3
0 1 0
4
0 0 0 1
Sample Output 1 :
0 0 1
0 0 0 1
Explanation Of Sample Input 1 :
Test case 1:
The sorted array is 0 0 1

Test case 2:
The array is already sorted.
Sample Input 2 :
2
1
0
2
1 0
Sample Output 2 :
0
0 1
Explanation Of Sample Input 2 :
Test case 1:
The array is already sorted

Test case 2:
The sorted array is 0 1.
 */

import java.util.ArrayList;
import java.util.Collections;
public class SortingBinaryArr {
    public static ArrayList<Integer> sortBinaryArray(ArrayList<Integer> arr, int n) {
        int i = 0;
        int j = n - 1;

        while(i<j){
            if(arr.get(i) == 0){
                i++;
            }
            else if(arr.get(i) == 1 && arr.get(j) == 0){
                Collections.swap(arr,i,j);
                i++;
                j--;
            }
            else{
                j--;
            }
        }

        return arr;
    }
}
