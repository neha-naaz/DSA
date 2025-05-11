package LinkedList;
/*
You are given the beginning of a linked list head, and an integer n.

Remove the nth node from the end of the list and return the beginning of the list.

Example 1:

Input: head = [1,2,3,4], n = 2

Output: [1,2,4]
Example 2:

Input: head = [5], n = 1

Output: []
Example 3:

Input: head = [1,2], n = 2

Output: [2]
Constraints:

The number of nodes in the list is sz.
1 <= sz <= 30
0 <= Node.val <= 100
1 <= n <= sz

 */
public class RemoveNthFromEnd {
    public ListNode removeNthFromEnd(ListNode head, int n) {
        // Find length
        int len = 0;
        ListNode curr = head;
        while(curr != null) {
            len += 1;
            curr = curr.next;
        }

        //pos from starting len - posFromEnd + 1
        n = (len - n + 1);
        if(n == 1)return head.next;

        int k = 0;
        curr = head;
        while(curr != null) {
            k++;

            if(k+1 == n) {
                curr.next = curr.next.next;
                break;
            }
            curr = curr.next;
        }
        return head;
    }
}
