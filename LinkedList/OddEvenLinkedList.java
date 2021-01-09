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
class OddEvenLinkedList {
    public ListNode oddEvenList(ListNode head) {
        if (head == null || head.next == null || head.next.next == null) return head;
        ListNode odd = head;
        ListNode oddHead = head;
        ListNode even = head.next;
        ListNode evenHead = head.next;
        ListNode cur = head.next.next;
        int counter = 3;
        while (cur != null) {
            if (counter % 2 == 0) {
                even.next = cur;
                even = even.next;
            } else {
                odd.next = cur;
                odd = odd.next;
            }
            counter++;
            cur = cur.next;
        }
        odd.next = evenHead;
        even.next = null;
        return oddHead;
    }
}
