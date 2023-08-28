package Arrays;
/*
You are given an array a are of N distinct integers you are ask his to find the product P with the highest count C of
quadruples which follow p*q = r*s where p,q,r,s are elements of the array with different indexes

Sample input 1:
2
6
2 6 3 4 1 12
6
4 1 7 2 6 5
Output:
12 3
0
Explanation:
In test case 1, there are a total of 3 quadruples for product 12 in the given array as given below:

2 6 and 3 4, (p = 2, q = 6, r = 3 and s = 4).
2 6 and 1 12, (p = 2, q = 6, r = 1 and s = 12).
3 4 and 1 12, (p = 3, q = 4, r = 1 and s = 12).

Thus, product('P') = 12, Count('C') = 3. No other value has 3 or more Quadruples.

In test case 2, every pair of elements forms a different value on multiplying, and thus no Quadruple is formed by the
given set of elements of the array. Hence 0 Quadruples formed.

Sample input 2:
1
8
7 2 10 1 8 3 9 4
5
4 2 1 8 2
Output:
8 1
8 3
Explanation:
In test case 1, there is only one quadruple in the given array i.e (p = 2, q = 4, r = 8 and s = 1). Thus,
Product('P') = 8 and Count('C') = 1. No other Quadruple is possible.

In test case 2, there are a total of 3 quadruples for product 8 in the given array as given below:

1 8 and 2i 4, (p = 1, q = 8, r = 2i and s = 4).
1 8 and 2ii 4, (p = 1, q = 8, r = 2ii and s = 4).
2i 4 and 2ii 4, (p = 2i, q = 4, r = 2ii and s = 4).

Here, 2i and 2ii denote the two different occurrences of 2 in the array.

Thus, Product('P') = 8, Count('C') = 3. No other value has 3 or more Quadruples.
 */
import java.util.*;
public class maxProductCount {
    public static long[] helper(int[] arr, int n) {
        Map<Long, Integer> hm = new HashMap<>();

        // Find all pairs, store their product and frequencies
        for(int i=0;i<n;i++){
            for(int j=i+1;j<n;j++){
                long prod = (long) arr[i]*arr[j];
                hm.put(prod, hm.getOrDefault(prod, 0)+1);
            }
        }

        long max_product = 0;
        int max_frequency = 0;

        // Find product max frequency
        for(Long key: hm.keySet()){
            if(hm.get(key) > max_frequency){
                max_product = key;
                max_frequency = hm.get(key);
            }
            else if(hm.get(key) == max_frequency){
                max_product = max_product>key?key:max_product;
            }
        }

        // Count number of quadraples
        long no_of_quads = ((long) max_frequency * (max_frequency-1)) / 2;
        return new long[]{max_product, no_of_quads};
    }
}
