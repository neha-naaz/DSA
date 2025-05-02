package SlidingWindow;
/*
You are given an array of integers nums and an integer k. There is a sliding window of size k that starts at the left edge of the array. The window slides one position to the right until it reaches the right edge of the array.

Return a list that contains the maximum element in the window at each step.

Example 1:

Input: nums = [1,2,1,0,4,2,6], k = 3

Output: [2,2,4,4,6]

Explanation:
Window position            Max
---------------           -----
[1  2  1] 0  4  2  6        2
 1 [2  1  0] 4  2  6        2
 1  2 [1  0  4] 2  6        4
 1  2  1 [0  4  2] 6        4
 1  2  1  0 [4  2  6]       6
Constraints:

1 <= nums.length <= 1000
-1000 <= nums[i] <= 1000
1 <= k <= nums.length
 */
import java.util.*;

public class SlidingWindowMaximum {
    public int[] maxSlidingWindow(int[] nums, int k) {
        Deque<Integer> q = new LinkedList<>();
        int n = nums.length;
        int[] output = new int[n-k+1];

        int l = 0, r = 0;
        while(r < n){
            while(!q.isEmpty() && nums[q.getLast()] < nums[r]) {
                q.removeLast();
            }
            q.addLast(r);

            if(l > q.getFirst())q.removeFirst();

            if(r+1 >= k){
                output[l] = nums[q.getFirst()];
                l++;
            }
            r++;
        }
        return output;
    }
}

class ExecuteSlidingWindow {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] arr = new int[n];
        int k = sc.nextInt();
        for(int i=0;i<n;i++) {
            arr[i] = sc.nextInt();
        }

        SlidingWindowMaximum solObj = new SlidingWindowMaximum();
        System.out.println(Arrays.toString(solObj.maxSlidingWindow(arr, k)));
    }
}
