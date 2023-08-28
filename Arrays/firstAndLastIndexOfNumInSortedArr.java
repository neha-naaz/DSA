package Arrays;
/*
You are given a non-decreasing array consisting of an integers and an integer x. You need to find the first and last position of X in the array
Sample Input - 1:
5
-10 -5 -5 -5 2
-5
output:
1 3
Explaination for output 1:
The given array’s 0-based indexing is as follows:
-10    -5    -5    -5     2
 ↓      ↓     ↓     ↓     ↓
 0      1     2     3     4

So, the first occurrence of -5 is at index 1, and the last occurrence of -5 is at index 3.

Sample Input 2:
4
1 2 3 4
-1
output:
-1 -1
Explaination for output 2:
The given array 'arr' is:[1, 2, 3, 4] and 'x' = -1.
In this case 'x' is not present in the array.
Hence, we return {-1,-1}.

constraints:
 1 <= n <= 10^4
-10^9 <= arr[i] <= 10^9
-10^9 <= x <= 10^9
 Time Limit: 1sec

Expected Time Complexity:
Try to solve the problem in O(log(N)) time complexity.
 */
import java.util.*;
public class firstAndLastIndexOfNumInSortedArr {
    private static int binarySearch(int[] arr, int x, int low, int high){
        while(low <= high){
            int mid = low + (high - low)/2;
            if(arr[mid] == x){
                if(mid == 0 || mid == high || arr[mid-1]!=x)return mid;
                else{ high = mid-1; }
            }
            else if(arr[mid] < x)low = mid+1;
            else{ high = mid-1; }
        }
        return -1;
    }
    public static int[] searchRange(int []arr, int x) {
        // Write your code here.
        int ind1 = binarySearch(arr, x, 0, arr.length-1);
        int ind2 =ind1+1;
        while(ind2 < arr.length && arr[ind2] == x)ind2++;
        return new int[]{ind1, ind2-1};
    }

    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int key = sc.nextInt();
        int[] arr = new int[n];
        for(int i=0;i<n;i++){
            arr[i] = sc.nextInt();
        }
        System.out.println(Arrays.toString(searchRange(arr, key)));
    }

}
