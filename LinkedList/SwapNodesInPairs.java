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
class SwapNodesInPairs {
    public ListNode swapPairs(ListNode head) {
        ListNode newHead = helper(head);
        return newHead;
    }
    
    public ListNode helper(ListNode head) {
        if (head == null) return null;
        if (head.next == null) return head;
        ListNode temp = head.next;
        head.next = temp.next;
        temp.next = head;
        head.next = helper(temp.next.next);
        return temp;
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
    public ListNode swapPairs(ListNode head) {
        if (head == null || head.next == null) return head;
        ListNode dummy = new ListNode();
        dummy.next = head;
        ListNode slow = dummy;
        ListNode fast = slow.next.next;
        while (fast != null) {
            // swap
            ListNode newNext = fast.next;
            ListNode temp = slow.next;
            slow.next = temp.next;
            slow.next.next = temp;
            temp.next = newNext;
            
            slow = slow.next.next;
            if (slow == null || (slow.next == null)) break;
            fast = slow.next.next;
        }
        return dummy.next;
    }
}
