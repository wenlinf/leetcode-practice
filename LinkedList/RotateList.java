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
class RotateList {
    public ListNode rotateRight(ListNode head, int k) {
        if (head == null || k == 0) return head;
        int length = 0;
        ListNode pointer = head;
        ListNode tail = head;
        while (pointer != null) {
            if (pointer.next == null) tail = pointer;
            pointer = pointer.next;
            length++;
        }
        k %= length;
        if (k == 0 || length == 1) return head;
        int index = 0;
        pointer = head;
        while (index < length - k - 1) {
            pointer = pointer.next;
            index++;
        }
        ListNode newHead = pointer.next;
        pointer.next = null;
        tail.next = head;
        return newHead;
    }
}
