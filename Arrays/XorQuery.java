package Arrays;

/*
Assume you initially have an Empty array say ARR. You need to return the updated array provided that some 'Q' queries
were performed on this array the queries are of two types
1. 1 'VAL', for this type of query you need to insert the integer 'VAL' to the end of the array.
2. 2 'VAL' for this type of query you need to take the bitwise xor of all the elements of the array with 'VAL' i.e each
element of the array arr will be updated as arr[i] = arr[i] ^ 'VAL'

Sample input 1:
2
2
1 3
2 2
3
1 2
2 3
2 1
Output:
1
0
Explanation:
For the first test case:
After the first query, 3 will be pushed into the array, so the array will be {3}, then after processing the second
query the array will be changed to {3^2} i.e. {1}. So the output array will be {1}.

For the second test case:
After the first query, 2 will be pushed into the array, so the array will be {2}, then after processing the second
query the array will be changed to {2^3} i.e. {1}, further the array is modified as {1^1} i.e {0}, after processing
the third query. So the output array will be {0}.

Sample input 2:
2
3
1 2
1 3
2 4
3
1 4
1 5
2 1
Output:
6 7
5 4
Explanation:
For the first test case:
After the first query, 2 will be pushed into the array, so the array will be {2}. Then after processing the second
query 3 will be pushed into the array, so the array will be {2, 3}. Then after processing the third query the array
will be changed to {2^4, 3^4} i.e. {6, 7}. So the output array will be {6, 7}.

For the second test case:
After the first query, 4 will be pushed into the array, so the array will be {4}. Then after processing the second
query 5 will be pushed into the array, so the array will be {4, 5}. Then after processing the third query the array
will be changed to {4^1, 5^1} i.e. {5, 4}. So the output array will be {5, 4}.
 */
import java.util.*;
public class XorQuery {
    public static ArrayList<Integer> findXorQuery(ArrayList<ArrayList<Integer>> queries) {
        // Write your code here
        ArrayList<Integer> res = new ArrayList<>();
        int xor = 0;
        for(int i=0;i<queries.size();i++){
            if(queries.get(i).get(0)==1){
                res.add(queries.get(i).get(1)^xor);
            }
            else{
                xor = xor ^ queries.get(i).get(1);
            }
        }
        for(int j=0;j<res.size();j++){
            res.set(j, res.get(j) ^ xor);
        }
        return res;
    }
}
