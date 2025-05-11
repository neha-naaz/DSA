package LinkedList;
/*
ou are given two non-empty linked lists, l1 and l2, where each represents a non-negative integer.

The digits are stored in reverse order, e.g. the number 123 is represented as 3 -> 2 -> 1 -> in the linked list.

Each of the nodes contains a single digit. You may assume the two numbers do not contain any leading zero, except the number 0 itself.

Return the sum of the two numbers as a linked list.

Example 1:



Input: l1 = [1,2,3], l2 = [4,5,6]

Output: [5,7,9]

Explanation: 321 + 654 = 975.
Example 2:

Input: l1 = [9], l2 = [9]

Output: [8,1]
Constraints:

1 <= l1.length, l2.length <= 100.
0 <= Node.val <= 9

 */
public class AddTwoNumbers {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        int carry = 0;
        ListNode h1 = l1, h2 = l2;
        ListNode dummy = new ListNode(0);
        ListNode result = dummy;
        while(h1 != null && h2 != null) {
            int sum = h1.val + h2.val + carry;
            System.out.println(sum);
            if(sum > 9) {
                carry = 1;
                sum = sum%10;
            } else {
                carry = 0;
            }

            dummy.next = new ListNode(sum);
            dummy = dummy.next;
            System.out.println(dummy.val);
            h1 = h1.next;
            h2 = h2.next;
        }

        addRemaining(h1, carry, dummy);
        addRemaining(h2, carry, dummy);

        if(carry == 1) {
            dummy.next = new ListNode(1);
        }

        return result.next;
    }

    private void addRemaining(ListNode h2, int carry, ListNode dummy) {
        while(h2 != null) {
            int sum = h2.val+carry;
            if(sum > 9) {
                carry = 1;
                sum = sum%10;
            } else carry = 0;
            dummy.next = new ListNode(sum);
            dummy = dummy.next;
            h2 = h2.next;
        }
    }

    public ListNode addTwoNumbers1(ListNode list1, ListNode list2) {
        ListNode dummy = new ListNode(-1);
        ListNode result = dummy;
        int carry = 0, currData = 0;

        while(list1!=null && list2!=null) {
            currData = list1.val + list2.val + carry;
            carry = currData / 10;
            currData %= 10;
            list1.val = currData;
            dummy.next = list1;
            dummy = dummy.next;
            list1 = list1.next;
            list2 = list2.next;
        }

        while(list1!=null){
            currData = list1.val + carry;
            carry = currData / 10;
            currData %= 10;
            list1.val = currData;
            dummy.next = list1;
            dummy = dummy.next;
            list1 = list1.next;
        }

        while(list2!=null){
            currData = list2.val + carry;
            carry = currData / 10;
            currData %= 10;
            list2.val = currData;
            dummy.next = list2;
            dummy = dummy.next;
            list2 = list2.next;
        }

        if(carry > 0){
            dummy.next = new ListNode(1);
            dummy = dummy.next;
        }

        dummy.next = null;
        return result.next;
    }
}
