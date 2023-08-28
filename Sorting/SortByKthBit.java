package Sorting;
/*
You are given an array/list ‘ARR’ of ‘N’ positive integers and an integer ‘K’. Your task is to group all the array
elements with ‘K-th’ bit (rightmost bit is ‘1st’ bit) equal to 0 followed by all the elements with ‘K-th’ bit equal to 1.

Sample Output 1:
4 2 3 1
5 1 2 6 7
Explanation For Sample Input 1:
In example 1, the original ‘ARR’ is {4,3,2,1} and ‘K’ = 1. After modification, the ‘ARR’ should be {4,2,3,1} because {4,2} will come first as their 1st bit is 0 and {3,1} will come after that as their 1st bit is 1.

In example 2, the original ‘ARR’ is {2,5,1,6,7} and ‘K’ = 2. After modification the ‘ARR’ should be {5,1,2,6,7} because
{5,1} will come first as their 2nd bit is 0 and {2,6,7} will come after that as their 2nd bit is 1.
Sample Input 2:
2
5 1
3 6 2 1 4
5 3
7 6 2 9 3
Sample Output 2:
6 2 4 3 1
2 9 3 7 6
Explanation For Sample Input 2:
In example 1, the original ‘ARR’ is {3,6,2,1,4} and ‘K’ = 1. After modification the ‘ARR’ should be {6,2,4,3,1} because
{6,2,4} will come first as their 1st bit is 0 and {3,1} will come after that as their 1st bit is 1.

In example 2, the original ‘ARR’ is {7,6,2,9,3} and ‘K’ = 3. After modification the ‘ARR’ should be {2,9,3,7,6} because
{2,9,3} will come first as their 3rd bit is 0 and {7,6} will come after that as their 3rd bit is 1.
 */
public class SortByKthBit {
    public static int[] sortArrayByKBit(int n, int k, int arr[]) {
        if(n == 1)return arr;

        // Array to store result
        int[] result1 = new int[n];
        int[] result2 = new int[n];
        int one = 0, two = 0;

        for(int i=0;i<n;i++){
            int num = arr[i];
            // shifting num by k-1 time so kth bit comes at the end
            int shifted_num = num >> (k-1);


            // If the last bit is set num would be odd else even
            if(shifted_num % 2 == 0){
                result1[one++] = arr[i];
            }
            else{
                result2[two++] = arr[i];
            }
        }

        for(int i=one, j=0;i<n && j<two;i++,j++){
            result1[i] = result2[j];
        }

        return result1;
    }

}
