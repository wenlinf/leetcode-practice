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
