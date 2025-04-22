package Arrays;
/*
You are given and unsorted array of an integer your task is to return the length of the longest consecutive sequence
the consecutive sequence is in the form [num, num+1, num+2, num+3, ...] where num is the starting integer of the
sequence and l + 1 is the length of the sequence

Sample input 1:
1
5
33 20 34 30 35
Output:
3
Explanation:
The longest consecutive sequence is [33, 34, 35].

Sample input2:
1
7
1 9 3 10 4 20 2
Output:
4
Explanation:
The consecutive sequence is in the form ['NUM', 'NUM' + 1, 'NUM' + 2,...,'NUM' + 'L']. So in the given array,
the longest consecutive sequence is [1,2,3,4] where 'NUM' = 1 and 'L' = 3. And the length of the sequence will be
'L' + 1 = 4.
 */
import java.util.*;
public class LongestConsecutiveSequence {
    public static int lengthOfLongestConsecutiveSequence(int[] num, int N) {
        int res = 0;
        HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();
        for (int n : num) {
            if (!map.containsKey(n)) {
                int left = (map.containsKey(n - 1)) ? map.get(n - 1) : 0;
                int right = (map.containsKey(n + 1)) ? map.get(n + 1) : 0;
                // sum: length of the sequence n is in
                int sum = left + right + 1;
                map.put(n, sum);

                // keep track of the max length
                res = Math.max(res, sum);

                // extend the length to the boundary(s)
                // of the sequence
                // will do nothing if n has no neighbors
                map.put(n - left, sum);
                map.put(n + right, sum);
            }
        }
        return res;
    }

    public static int longestConsecutive(int[] nums) {
        // add nums to set for O(1) lookup
        Set<Integer> set = new HashSet<>();
        for(int num: nums) set.add(num);

        int ind = 0, res = 0;
        while(ind < nums.length) {
            // if the curr num is the start of the sequence
            if(!set.contains(nums[ind]-1)){
                int len = 1;
                int start = nums[ind];
                // calc len of the sequence
                while(set.contains(++start)) {
                    len++;
                }
                res = Math.max(res, len);
            }
            ind++;
        }

        return res;
    }

    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] arr = new int[n];
        for(int i=0;i<n;i++){
            arr[i] = sc.nextInt();
        }

        System.out.println(longestConsecutive(arr));
    }
}
