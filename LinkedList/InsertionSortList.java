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
    public ListNode insertionSortList(ListNode head) {
        if (head.next == null) return head;
        
        ListNode dummy = new ListNode(-9999);
        dummy.next = head;
        ListNode curr = head.next;
        ListNode iter = dummy;
        ListNode prev = head;
        while (curr != null) {
            while (!(curr.val >= iter.val && curr.val <= iter.next.val) && iter.next != curr) {
                iter = iter.next;
            }
            if (iter.next == curr) {
                prev = curr;
                curr = curr.next;
                
                iter = dummy;
            } else {
                ListNode temp = curr.next;
                curr.next = iter.next;
                iter.next = curr;
                prev.next = temp;
                curr = temp;
                iter = dummy;
            } 
        }
        return dummy.next;
    }
}
