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
    public ListNode partition(ListNode head, int x) {
        ListNode less = new ListNode(-101);
        ListNode more = new ListNode(-101);
        ListNode curr = head;
        ListNode lessPt = less;
        ListNode morePt = more;
        while (curr != null) {
            if (curr.val < x) {
                lessPt.next = curr;
                lessPt = lessPt.next;
            } else {
                morePt.next = curr;
                morePt = morePt.next;
            }
            curr = curr.next;
        }
        morePt.next = null;
        lessPt.next = more.next;
        return less.next;
    }
}
