package LinkedList;
/*
You are given an array of integers nums containing n + 1 integers. Each integer in nums is in the range [1, n] inclusive.
Every integer appears exactly once, except for one integer which appears two or more times. Return the integer that appears more than once.

Example 1:
Input: nums = [1,2,3,2,2]
Output: 2

Example 2:
Input: nums = [1,2,3,4,4]
Output: 4
Follow-up: Can you solve the problem without modifying the array nums and using O(1) and O(1) extra space?

Constraints:
1 <= n <= 10000
nums.length == n + 1
1 <= nums[i] <= n
 */

// Approach: Not intuitive at all. Consider a graph with 0 to n nodes. the values in the array are pointers.
// arr[0] = 1 (edge from 0 to 1), arr[2] = 1 (edge from 2 to 1) so on
// this will have a cycle. Task is to find the starting point of the cycle(our duplicate number)
// first find the intersection of slow and fast
// start another slow from beigining, and move these both. The meeting point is the result
// why? The distance from the begining to starting of cycle is same as distance from intersectiont o starting
public class FindDuplicateNumber {
    public int findDuplicate(int[] nums) {
        int slow = 0, fast = 0;
        while (true) {
            slow = nums[slow];
            fast = nums[nums[fast]];
            if (slow == fast) {
                break;
            }
        }

        int slow2 = 0;
        while (true) {
            slow = nums[slow];
            slow2 = nums[slow2];
            if (slow == slow2) {
                return slow;
            }
        }
    }
}
