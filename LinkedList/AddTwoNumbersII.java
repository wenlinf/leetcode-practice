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
        ListNode reverse1 = reverse(l1);
        ListNode reverse2 = reverse(l2);
        int carry = 0;
        ListNode dummy = new ListNode(0);
        ListNode curr = dummy;
        while (reverse1 != null || reverse2 != null) {
            int digit1 = reverse1 == null ? 0 : reverse1.val;
            int digit2 = reverse2 == null ? 0 : reverse2.val;
            int newDigit = (digit1 + digit2 + carry) % 10;
            carry = (digit1 + digit2 + carry) / 10;
            curr.next = new ListNode(newDigit);
            if (reverse1 != null) reverse1 = reverse1.next;
            if (reverse2 != null) reverse2 = reverse2.next;
            curr = curr.next;
        }
        if (carry == 1) {
            curr.next = new ListNode(1);
        }
        return reverse(dummy.next);
    }
    
    private ListNode reverse(ListNode head) {
        if (head == null || head.next == null) return head;
        ListNode newHead = reverse(head.next);
        head.next.next = head;
        head.next = null;
        return newHead;
    }
}
