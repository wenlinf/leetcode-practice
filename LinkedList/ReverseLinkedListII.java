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
    public ListNode reverseBetween(ListNode head, int left, int right) {
        if (left == right) return head;
        ListNode curr = head;
        
        if (left == 1) {
            ListNode reverse = reverseN(curr, right - left + 1);
            return reverse;
        }
        
        int index = 1;
        while (index < left - 1) {
            curr = curr.next;
            index++;
        }
        ListNode reverse = reverseN(curr.next, right - left + 1);
        curr.next = reverse;
        return head;
    }
    
    private ListNode successor = null;
    private ListNode reverseN(ListNode head, int n) {
        if (n == 1) {
            successor = head.next;
            return head;
        }
        ListNode newHead = reverseN(head.next, n - 1);
        head.next.next = head;
        head.next = successor;
        return newHead;
    }
}
