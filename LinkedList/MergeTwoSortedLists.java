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
class MergeTwoSortedLists {
    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        if (l1 == null && l2 == null) return null;
        if (l1 == null && l2 != null) return l2;
        if (l2 == null && l1 != null) return l1;
        ListNode pt1 = l1;
        ListNode pt2 = l2;
        ListNode dummy = new ListNode(0);
        ListNode head = dummy;
        while (pt1 != null && pt2 != null) {
            if (pt1.val < pt2.val) {
                dummy.next = pt1;
                pt1 = pt1.next;
            } else {
                dummy.next = pt2;
                pt2 = pt2.next;
            }
            dummy = dummy.next;
        }
        if (pt1 == null && pt2 != null) {
            dummy.next = pt2;
        } else if (pt2 == null && pt1 != null) {
            dummy.next = pt1;
        }
        return head.next;
    }
}
