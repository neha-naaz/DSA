package Sorting;
/*
Given two arrays ‘ARR’ and ‘BRR’ of size ‘N’ and ‘M’ respectively. Your task is to sort the elements of ‘ARR’ in such a
way that the relative order among the elements will be the same as those are in ‘BRR’. For the elements not present in
‘BRR’, append them in the last in sorted order.

Sample Input 1:
2
6 3
9 5 8 4 6 5
8 4 5
4 4
1 8 1 6
1 9 6 7
Sample Output 1:
8 4 5 5 6 9
1 1 6 8
Explanation:
For test case 1:
As 8 comes first in BRR, so we first add all occurrences of 8 in ARR, in our resultant array RES. Now, RES={8} and ARR={9,5,4,6,5}.
After 8, 4 comes in BRR, so we add all occurrences of 4 that are in ARR, in the RES array. Now, RES={8,4} and ARR={9,5,6,5}.
After 4, 5 comes in BRR, so we add all occurrences of 5 that are in ARR, in the RES array. Now, RES={8,4,5,5} and ARR={9,6}.
Now, after processing all the elements of BRR, we will add the remaining elements of ARR in sorted order, in our RES array.
So the final RES is {8,4,5,5,6,9}.

For test case 2:
As 1 comes first in BRR, so we first add all occurrences of 1 in ARR, in our resultant array RES. Now, RES={1,1} and ARR={8,6}.
After 1, 9 comes in BRR, so we add all occurrences of 9 that are in ARR, in the RES array, but 9 is not present in ARR,
so RES remains the same. Now, RES={1,1} and ARR={8,6}.
After 9, 6 comes in BRR, so we add all occurrences of 6 that are in ARR, in the RES array. Now, RES={1,1,6} and ARR={8}.
After 9, 7 comes in BRR, so we add all occurrences of 7 in ARR, in our RES, but 7 is not present in ARR, so RES remains
the same. Now, RES={1,1,6} and ARR={8}.
Now, after processing all the elements of BRR, we will add the remaining elements of ARR in sorted order, in our RES array.
So the final RES is {1,1,6,8}.
Sample Input 2:
2
3 5
7 5 8
8 4 5 6 3
4 2
9 2 2 4
5 2
Sample Output 2:
8 5 7
2 2 4 9

 */

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;
public class RelativeSorting {
    public static List<Integer> relativeSorting(List<Integer> arr, List<Integer> brr, int n, int m) {
        TreeMap<Integer,Integer> tm=new TreeMap<>();

        // Storing elements and there frequency
        for(int i:arr){
            tm.put(i,tm.getOrDefault(i,0)+1);
        }

        List<Integer> list=new ArrayList<>();

        // Traversing the brr to check which numbers have to come at first and adding them and after that removing them from array
        for(int i:brr){
            if(tm.containsKey(i)){
                int count=tm.get(i);
                while(count>0){
                    list.add(i);
                    count--;
                }
                tm.remove(i);
            }
        }

        // If size of treemap is 0 return list as we added all elements
        if(tm.size()==0) return list;


        // If any elements are left iterate the treemap and add them as treemap stores elements in sorted order we will be getting answer in sort order
        for(Map.Entry<Integer, Integer> i:tm.entrySet()) {
            int count = i.getValue();
            while(count>0){
                list.add(i.getKey());
                count--;
            }
        }
        return list;
    }
}
