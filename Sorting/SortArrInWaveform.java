package Sorting;
/*
You have been given an unsorted array ‘ARR’.
Your task is to sort the array in such a way that the array looks like a wave array

Sample Input 1:
2
5
2 3 1 4 2
6
4 3 2 5 4 1
Sample Output 1:
2 1 3 2 4
4 3 5 2 4 1
Explanation Of Sample Input 1:
Test Case 1:
For given 'ARR' = { 2, 3, 1, 4, 2 } one possible sorted wave form array is { 2, 1, 3, 2, 4 }

2>1 and 1<3
3>2 and 2<4
4>2
And it follows the condition of wave array form.

Some other possible sorted array in wave form -
3 1 2 2 4
4 1 2 2 3
4 2 3 1 2


Test case 2:

For given 'ARR' = { 4, 3, 2, 5, 4, 1 } one possible sorted wave form array is { 4, 3, 5, 2, 4, 1 }

4>3 and 3<5
5>3 and 2<4
4>2 and 1<4
And it follows the condition of wave array form.

Some other possible sorted array in wave form -
4 2 3 1 5 4
4 2 3 4 5 1
3 2 4 1 5 4
Sample Input 2:
2
3
3 2 1
9
3 2 1 3 2 1 3 2 1
Sample Output 2:
2 1 3
3 1 2 1 3 2 2 1 3
 */
public class SortArrInWaveform {
    private static void swap(int arr[], int a, int b)
    {
        int temp = arr[a];
        arr[a] = arr[b];
        arr[b] = temp;
    }

    public static int[] waveFormArray(int[] arr, int n) {
        // Traverse all even elements
        for(int i = 0; i < n; i+=2){
            //swap odd and even positions
            if(i > 0 && arr[i - 1] > arr[i]){
                swap(arr, i, i-1);
            }
            if(i < n-1 && arr[i + 1] > arr[i]){
                swap(arr, i, i+1);
            }
        }

        return arr;
    }
}
