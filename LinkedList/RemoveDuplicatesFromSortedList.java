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
class RemoveDuplicatesFromSortedList {
    public ListNode deleteDuplicates(ListNode head) {
        if (head == null) return null;
        ListNode curr = head;
        while (curr != null) {
            if (curr.next != null && curr.next.val == curr.val) {
                if (curr.next.next != null) {
                    ListNode temp = curr.next;
                    curr.next = curr.next.next;
                    temp.next = null;
                } else {
                    curr.next = null;
                }
            } else {
                curr = curr.next;
            }   
        }
        return head;
    }
}
