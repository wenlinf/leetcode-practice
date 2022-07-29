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
    public ListNode mergeNodes(ListNode head) {
        ListNode dummy = new ListNode();
        ListNode iter = dummy;
        ListNode curr = head;
        int acc = 0;
        while (curr != null) {
            if (curr.val != 0) {
                acc += curr.val;
            } else {
                if (acc != 0) {
                    iter.next = new ListNode(acc);
                    acc = 0;
                    iter = iter.next;
                } 
            }
            curr = curr.next;
        }
        return dummy.next;
    }
}

// O(1) space
class Solution {
    public ListNode mergeNodes(ListNode head) {
        ListNode fast = head;
        ListNode dummy = new ListNode();
        dummy.next = head;
        ListNode slow = dummy;
        int acc = 0;
        while (fast != null) {
            if (fast.val != 0) {
                acc += fast.val;
            } else {
                if (acc != 0) {
                    slow = slow.next;
                    slow.val = acc;
                    acc = 0;
                }
            }
            fast = fast.next;
        }
        slow.next = null;
        return dummy.next;
    }
}
