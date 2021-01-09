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
class RemoveElements {
    public ListNode removeElements(ListNode head, int val) {
        if (head == null) return head;
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        ListNode cur = dummy;
        ListNode tempNext = null;
        ListNode nodeToDelete = null;
        while (cur != null && cur.next != null) {
            if (cur.next.val == val) {
                tempNext = cur.next.next;
                nodeToDelete = cur.next;
                cur.next = tempNext;
                nodeToDelete.next = null;
            } else {
                cur = cur.next;
            }
        }
        return dummy.next;
    }
}
