package Arrays;
/*
You are given an array consisting of an integers and a non negative integer K consider an operation on the array as
replacing every element of the array with max element of the array you need to return the updated I given that the
operation is performed on the array exactly K number of times.

Sample input 1:
1
4 2
20 15 10 5
Output:
15 10 5 0
Explanation:
The given array’s 0-based indexing is as follows:

In the first operation, maximum = 20.

20    15    10    5
↓      ↓    ↓     ↓
0      5    10    15

These will be the array values, after one operation.

In the second operation,  maximum = 15.

0      5     10    15
↓      ↓      ↓     ↓
15     10     5     0

Now the array to be returned is {15, 10, 5, 0}.

Sample input 2:
1
4 3
0 0 9 18
Output:
18 18 9 0
 */
import java.util.*;
public class ArrAfterKOperations {
    public static ArrayList<Integer> printArrayAfterKOperations(ArrayList<Integer> arr, int n, int k) {
        ArrayList<Integer> result = new ArrayList<>();

        if(k == 0)return arr;

        // if k is even replace every ele with min - ele
        if(k % 2 != 0){
            int max = Collections.max(arr);
            for(int i=0;i<n;i++){
                arr.set(i, Math.abs(max - arr.get(i)));
            }
        // for odd replace with max - ele
        }else{
            int min = Collections.min(arr);
            for(int i=0;i<n;i++){
                arr.set(i, Math.abs(min - arr.get(i)));
            }
        }
        return arr;
    }
}
