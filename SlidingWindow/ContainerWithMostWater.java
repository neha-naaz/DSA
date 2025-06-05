package TwoPinters;
/*
You are given an integer array heights where heights[i] represents the height of the
i
t
h
i
th
  bar.

You may choose any two bars to form a container. Return the maximum amount of water a container can store.

Example 1:



Input: height = [1,7,2,5,4,7,3,6]

Output: 36
Example 2:

Input: height = [2,2,2]

Output: 4
Constraints:

2 <= height.length <= 1000
0 <= height[i] <= 1000
 */

import java.util.Scanner;
public class ContainerWithMostWater {
    // Optimized Approach - Two pointers
    // T: O(n) S: O(1)
    int maxArea(int[] heights) {
        int maxArea = 0, n = heights.length;
        // pointers at start and end of the array
        int st = 0, end = n-1;
        while(st < end) {
            // calculate area for curr position of pointers
            int area = (end - st)*Math.min(heights[st], heights[end]);
            // update maxArea
            maxArea = Math.max(maxArea, area);
            // Keep the tall bar
            if(heights[st] > heights[end]) {
                end--;
            } else {
                st++;
            }
        }
        return maxArea;
    }
}

class ExecuteContainerWithMostWater {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] arr = new int[n];
        for(int i=0;i<n;i++) {
            arr[i] = sc.nextInt();
        }

        ContainerWithMostWater solObj = new ContainerWithMostWater();
        System.out.println(solObj.maxArea(arr));
    }
}
