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
    public void reorderList(ListNode head) {
        ListNode middle = findMiddle(head);
        ListNode newMiddle = reverseList(middle);
        ListNode dummy = new ListNode(-1);
        ListNode dummyPt = dummy;
        ListNode curr1 = head;
        ListNode curr2 = newMiddle;
        int index = 0;
        while (curr2 != null) {
            if (index % 2 == 0) {
                if (curr1.next == null) break;
                dummyPt.next = curr1;
                curr1 = curr1.next;
            } else {
                dummyPt.next = curr2;
                curr2 = curr2.next;
            }
            dummyPt = dummyPt.next;
            index++;
        }
        dummyPt.next = curr1;
        dummyPt = dummyPt.next;
        dummyPt.next = null;
    }
    
    private ListNode reverseList(ListNode head) {
        if (head == null || head.next == null) return head;
        ListNode newHead = reverseList(head.next);
        head.next.next = head;
        head.next = null;
        return newHead;
    }
    
    private ListNode findMiddle(ListNode head) {
        ListNode slow = head;
        ListNode fast = head;
        while (fast != null && fast.next != null) {
            fast = fast.next.next;
            slow = slow.next;
        }
        return slow;
    }
}
