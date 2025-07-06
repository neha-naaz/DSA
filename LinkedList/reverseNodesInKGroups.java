/*
You are given the head of a singly linked list head and a positive integer k.
You must reverse the first k nodes in the linked list, and then reverse the next k nodes, and so on. 
If there are fewer than k nodes left, leave the nodes as they are.

Return the modified list after reversing the nodes in each group of k.

You are only allowed to modify the nodes' next pointers, not the values of the nodes.

Example 1:
Input: head = [1,2,3,4,5,6], k = 3

Output: [3,2,1,6,5,4]

Example 2:
Input: head = [1,2,3,4,5], k = 3

Output: [3,2,1,4,5]

Constraints:
The length of the linked list is n.
1 <= k <= n <= 100
0 <= Node.val <= 100

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

class reverseNodesInKGroups {
    public ListNode reverseKGroup(ListNode head, int k) {
        ListNode dummy = new ListNode(0, head);
        ListNode groupPrev = dummy;

        while(true) {
            ListNode kth = getKth(groupPrev, k);
            if(kth == null)break;
            ListNode groupNxt = kth.next;

            ListNode curr = groupPrev.next;
            ListNode prev = kth.next;
            while(curr != groupNxt) {
                ListNode tmp = curr.next;
                curr.next = prev;
                prev = curr;
                curr = tmp;
            }

            ListNode originalStart = groupPrev.next;
            groupPrev.next = kth;
            groupPrev = originalStart;
        }
        return dummy.next;
    }

    private ListNode getKth(ListNode curr, int k) {
        while(curr != null && k > 0) {
            curr = curr.next;
            k--;
        }
        return curr;
    }
}
