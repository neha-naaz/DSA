package Sorting;
/*
You have been given an array 'ARR' of 'N' distinct elements.
Your task is to find the minimum no. of swaps required to sort the array.

Sample Input 1:
2
4
4 3 2 1
5
1 5 4 3 2
Sample Output 1:
2
2
Explanation Of Sample Input 1:
For the first test case, swap index 0 with 3 i.e. 4 -> 1 and 1 with 2 i.e. 3 -> 2 to form the sorted array {1, 2, 3, 4}.

For the second test case, swap index 1 with 4 i.e. 5 -> 2 and 2 with 3 i.e. 4 -> 3 to form the sorted array {1, 2, 3, 4, 5}.
Sample Input 2:
2
4
1 2 3 4
6
3 5 2 4 6 8
Sample Output 2:
0
3
 */

import java.util.Arrays;
import java.util.HashMap;
public class MinSwapsReqdToSortArr {
    public static int minSwaps(int[] arr) {
        int ans = 0;
        int N = arr.length;
        int[] temp = Arrays.copyOfRange(arr, 0, N);

        // Hashmap which stores the indexes of the input array
        HashMap<Integer, Integer> h
                = new HashMap<Integer, Integer>();

        Arrays.sort(temp);
        for (int i = 0; i < N; i++) {
            h.put(arr[i], i);
        }
        for (int i = 0; i < N; i++) {

            // This is checking whether the current element is at the right place or not
            if (arr[i] != temp[i]) {
                ans++;
                int init = arr[i];

                // If not, swap this element with the index of the element which should come here
                swap(arr, i, h.get(temp[i]));

                // Update the indexes in the hashmap accordingly
                h.put(init, h.get(temp[i]));
                h.put(temp[i], i);
            }
        }
        return ans;
    }

    private static void swap(int[] arr, int i, int j){
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
}
