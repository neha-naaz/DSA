package Sorting;
/*
You are given an array consisting of N positive integers, and your task is to sort the array in decreasing order of
count of set bits in the binary representation of the integers present in the array.
In other words, you have to modify the array such that an integer with more number of set bits should appear before the
integer which has lesser number of set bits in its binary representation.
The number of set bits is nothing but the number of 1s present in the binary representation of the integer. For example,
the number of set bits in 5(0101) is equal to 2.

Sample Input 1 :
1
3
2 4 8
Sample Output 1 :
2 4 8
Explanation For Sample Input 1 :
The binary representation of 2,4 and 8 will be {10, 100, 1000}, respectively. The count of set bits is one for all the
three numbers so the sorted order will be {2, 4, 8}.
Sample Input 2 :
1
3
4 3 8
Sample Output 2 :
3 4 8
Explanation For Sample Input 2 :
The binary representation of 3,4 and 8 will be {11, 100, 1000}, respectively. The count of set bits for 3,4, and 8 is
2,1 and 1 respectively. So the sorted order will be {3, 4, 8}.

 */

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
public class SortAccToCountOfSetBits {
    private static int countSetBits(int n){
        int count = 0;

        while(n > 0){
            count += n & 1;
            n >>= 1;
        }

        return count;
    }
    public static void sortSetBitsCount(ArrayList<Integer> arr, int size) {
        int n = arr.size();
        Map<Integer, ArrayList<Integer>> hm = new HashMap<>();

        for(int i=0;i<n;i++){
            int set_bits = countSetBits(arr.get(i));
            if(hm.containsKey(set_bits)){
                ArrayList<Integer> a = hm.get(set_bits);
                a.add(arr.get(i));
                hm.put(set_bits, a);
            }else{
                ArrayList<Integer> nums = new ArrayList<>();
                nums.add(arr.get(i));
                hm.put(set_bits, nums);
            }
        }

        arr.clear();

        // Max number of set bits possible assuming to be 32
        for(int i=32;i>=0;i--){
            if(hm.containsKey(i)){
                for(Integer val: hm.get(i))arr.add(val);
            }
        }
    }
}
