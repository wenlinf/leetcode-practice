/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
class Solution {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        int sum = 0;
        int carry = 0;
        ListNode dummy = new ListNode(0);
        ListNode head = dummy;
        while (l1 != null || l2 != null) {
            sum = l1.val + l2.val + carry;
            if (sum >= 10) {
                carry = 1;
                sum %= 10;
            } else {
                carry = 0;
            }
            dummy.next = new ListNode(sum);
            dummy = dummy.next;
            if (l1.next == null && l2.next == null) break;
            l1 = l1.next == null ? new ListNode(0) : l1.next;
            l2 = l2.next == null ? new ListNode(0) : l2.next;
        }
        if (carry == 1) dummy.next = new ListNode(carry);
        return head.next;
    }
}


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
class Solution {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode curr1 = l1;
        ListNode curr2 = l2;
        boolean carry = false;
        ListNode dummy = new ListNode(0);
        ListNode curr = dummy;
        while (curr1 != null || curr2 != null) {
            int digit1 = curr1 == null ? 0 : curr1.val;
            int digit2 = curr2 == null ? 0 : curr2.val;
            int sum = digit1 + digit2;
            if (carry) {
                sum += 1;
            }
            if (sum >= 10) {
                carry = true;
            } else {
                carry = false;
            }
            if (carry) {
                curr.next = new ListNode(sum % 10);
            } else {
                curr.next = new ListNode(sum);
            }
            curr = curr.next;
            if (curr1 != null) {
                curr1 = curr1.next;
            }
            if (curr2 != null) {
                curr2 = curr2.next;
            }
        }
        if (carry) {
            curr.next = new ListNode(1);
        }
        return dummy.next;
    }
}
