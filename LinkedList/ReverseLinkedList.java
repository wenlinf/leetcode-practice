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
class ReverseLinkedList {
    public ListNode reverseList(ListNode head) {
        if (head == null) return null;
        ListNode cur = head;
        while (cur.next != null) {
            ListNode newNext = cur.next.next;
            ListNode curNext = cur.next;
            cur.next = newNext;
            curNext.next = head;
            head = curNext;
        }
        return head;
    }
}
