package LinkedLists;
/*
You are given the heads of two sorted linked lists list1 and list2.
Merge the two lists into one sorted linked list and return the head of the new sorted linked list.
The new list should be made up of nodes from list1 and list2.

Example 1:
Input: list1 = [1,2,4], list2 = [1,3,5]
Output: [1,1,2,3,4,5]

Example 2:
Input: list1 = [], list2 = [1,2]
Output: [1,2]

Example 3:
Input: list1 = [], list2 = []
Output: []

Constraints:
0 <= The length of the each list <= 100.
-100 <= Node.val <= 100
 */
import java.util.*;
public class MergeTwoSortedLL {
    public ListNode mergeTwoLists(ListNode list1, ListNode list2) {
        if(list1 == null)return list2;
        if(list2 == null)return list1;
        if(list1.val > list2.val) {
            ListNode temp = list1;
            list1 = list2;
            list2 = temp;
        }
        ListNode head1 = list1, head2 = list2;
        ListNode result = new ListNode(head1.val);
        head1 = head1.next;
        ListNode curr = result;
        while(head1 != null && head2 != null) {
            if(head1.val < head2.val) {
                ListNode newN = new ListNode(head1.val);
                curr.next = newN;
                curr = curr.next;
                head1 = head1.next;
            } else {
                ListNode newN = new ListNode(head2.val);
                curr.next = newN;
                curr = curr.next;
                head2 = head2.next;
            }
        }
        // if eles remaining in any one of the lists
        if(head1 != null) {
            curr.next = head1;
        }

        if(head2 != null) {
            curr.next = head2;
        }

        return result;
    }
}


