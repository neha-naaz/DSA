/*
You are given an array of k linked lists lists, where each list is sorted in ascending order.

Return the sorted linked list that is the result of merging all of the individual linked lists.

Example 1:
Input: lists = [[1,2,4],[1,3,5],[3,6]]

Output: [1,1,2,3,3,4,5,6]

Example 2:
Input: lists = []

Output: []
Example 3:

Input: lists = [[]]

Output: []

Constraints:
0 <= lists.length <= 1000
0 <= lists[i].length <= 100
-1000 <= lists[i][j] <= 1000
*/

/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */

class MergeKSortedLinkedLists {
    public ListNode mergeKLists(ListNode[] lists) {
        if (lists.length == 0) {
            return null;
        }
        if (lists.length == 1) {
            return lists[0];
        }

        ListNode dummy = new ListNode(0);
        mergeTwoLists(dummy, lists, lists, 1);

        return dummy.next;
    }

    private void mergeTwoLists(ListNode dummy, ListNode[] lists, ListNode h1, int ind2) {
        if (ind2 >= lists.length) {
            return;
        }

        ListNode curr = dummy;
        ListNode h2 = lists[ind2];
        while(h1 != null && h2 != null) {
            if (h1.val <= h2.val) {
                curr.next = h1;
                h1 = h1.next;
            } else {
                curr.next = h2;
                h2 = h2.next;
            }
            curr = curr.next;
        }
        if(h1 != null) {
            curr.next = h1;
        }
        if(h2 != null) {
            curr.next = h2;
        }
        mergeTwoLists(dummy, lists, dummy.next, ind2+1);
    }
}
