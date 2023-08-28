package Arrays;
/*
TOPIC - SEARCHING, SORTING

Given an sorted array A of size N. Find number of elements which are less than or equal to Array B.
Problem Constraints
1 <= N <= 106
1 <= A[i], B[i] <= 109

Input Format
First agument is an integer array A of size N.
Second argument is an integer array B of size M.

Output Format
Return an integer denoting the number of elements which are less than or equal to A[i] in B.

Example Input
Input 1:
5
5 4 3 2 1
2
3 4
Output 1:
2 2 1 0 0

Explaination:
For the first index, A[0] = 5
Both the elements of Array B are less than 5. Therefore the answer for the first index is 2.

For the second index, A[1] = 4
In array B, one element is smaller than 4 and one element is equal to 4. Therefore the answer for the second index is also 2.

For the third index, A[2] = 3
In array B only one element is equal to 3. Therefore the answer for the third index is 1.

For the fourth index, A[3] = 2
Both the elements of Array B are greater than 2. Therefore the answer for the fourth index is 0.

For the fifth index, A[4] = 1
Both the elements of Array B are greater than 1. Therefore the answer for the last index is 0.

Hence, the final answer is [2, 2, 1, 0, 0] in this case.

Input 2:
1
4
-2 1 3 0
4
-1 0 2 1
Output 2:
 0 3 4 2
 */
import java.util.*;
public class countSmallerOrEqual {
    public static List<Integer> countSmallerOrEqualInTwoArr(int[] a, int[] b, int n, int m) {
        // Write your code here!
        Arrays.sort(b);
        List<Integer> res = new ArrayList<>();
        for(int i=0;i<a.length;i++){
            int ind = Arrays.binarySearch(b, a[i]);
            // System.out.println(ind);
            if(ind < 0)res.add((ind*-1)-1);
            else{
                ind++;
                while(ind < b.length && b[ind] == a[i])ind++;
                res.add(ind);
            }
        }
        return res;
    }
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] arr1 = new int[n];
        for(int i=0;i<n;i++){
            arr1[i] = sc.nextInt();
        }
        int m = sc.nextInt();
        int[] arr2 = new int[m];
        for(int i=0;i<n;i++){
            arr2[i] = sc.nextInt();
        }
        System.out.println(countSmallerOrEqualInTwoArr(arr1, arr2, n, m));
    }

}
