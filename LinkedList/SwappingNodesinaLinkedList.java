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
    public ListNode swapNodes(ListNode head, int k) {
        ListNode pt1 = head;
        ListNode pt2 = head;
        for (int i = 0; i < k - 1; i++) {
            pt2 = pt2.next;
        }
        ListNode firstNode = pt2;
        int firstVal = pt2.val;
        while (pt2.next != null) {
            pt1 = pt1.next;
            pt2 = pt2.next;
        }
        int secondVal = pt1.val;
        firstNode.val = secondVal;
        pt1.val = firstVal;
        return head;
    }
}
