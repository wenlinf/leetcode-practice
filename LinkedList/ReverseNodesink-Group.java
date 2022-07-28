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
    public ListNode reverseKGroup(ListNode head, int k) {
        ListNode dummy = new ListNode(0);
        ListNode iter = dummy;
        ListNode fast = head;
        ListNode slow = head;
        int index = 0;
        while (fast != null) {
            while (index < k && fast != null) {
                fast = fast.next;
                index++;
            }
            if (index != k && fast == null) {
                iter.next = slow;
                break;
            } 
            ListNode prev = null;
            ListNode curr = slow;
            while (curr != fast) {
                ListNode temp = curr.next;
                curr.next = prev;
                prev = curr;
                curr = temp;
            }
            iter.next = prev;
            iter = slow;
            slow = fast;
            index = 0;
        }
        return dummy.next;
    }
}
