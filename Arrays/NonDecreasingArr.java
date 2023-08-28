package Arrays;
/*
You have been given an array of integers of size N. Write a solution to check if it could become a non decreasing by modifying atmost 1 element we define an array has not decreasing if arr[i] <= arr[i] holds for every i such that 0 <= i

Sample input 1:
2
3
8 4 6
3
8 4 2
Output:
true
false
Explanation:
For Test Case 1 we can have a possible non-decreasing array : 2 4 6
Where only the element at index 0 has been modified.

For Test Case 2 there is no possible way to make the array non-decreasing by modifying at most 1 element.

Sample input 2:
2
6
-2 7 -1 0 1 2
5
-10 10 0 10 3
Output:
true
false
Explanation:
For Test Case 1 we can have a possible non-decreasing array : -2 -2 -1 0 1 2
Where only the element at index 1 has been modified

For Test Case 2 there is no possible way to make the array non-decreasing by modifying at most 1 element.
 */
public class NonDecreasingArr {
    public static boolean isPossible(int[] arr, int n) {
        int count = 0;
        for (int i = 1; i < arr.length && count <= 1; i++) {
            if (arr[i-1] > arr[i]) {
                count++;
                if (i-2 < 0 || arr[i-2] <= arr[i]) {
                    arr[i-1] = arr[i];
                } else {
                    arr[i] = arr[i-1];
                }
            }
        }
        return count <= 1;
    }
}
