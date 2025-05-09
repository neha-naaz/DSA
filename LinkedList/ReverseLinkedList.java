package LinkedLists;
/*
Given the beginning of a singly linked list head, reverse the list, and return the new beginning of the list.

Example 1:

Input: head = [0,1,2,3]

Output: [3,2,1,0]
Example 2:

Input: head = []

Output: []
Constraints:

0 <= The length of the list <= 1000.
-1000 <= Node.val <= 1000
 */
class ListNode {
    int val;
    ListNode next;
    ListNode(int value) {
        val = value;
    }
}
public class ReverseLinkedList {
    public ListNode reverseList(ListNode head) {
        if(head == null || head.next == null)return head;
        // reversed variable doesnt changes in recursive calls
        // stores the last node so can return as head
        ListNode reversed = reverseList(head.next);
        // reversing logic
        head.next.next = head;
        head.next = null;
        return reversed;
    }
}
