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
class PalindromeLinkedList {
    public boolean isPalindrome(ListNode head) {
        if (head == null || head.next == null) return true;
        ListNode fast = head;
        ListNode slow = head;
        int size = 1;
        while (fast != null) {
            fast = fast.next;
            size++;
        }
        ListNode headOfSecondHalf;
        if (size % 2 == 0) {
            //1 2 2 1
            for (int i = 0; i < size/2; i++) {
                slow = slow.next;
            }
            headOfSecondHalf = reverseList(slow);
        } else {
            //1 2 3 2 1
            for (int i = 0; i < Math.ceil(size/2); i++) {
                slow = slow.next;
            }
            headOfSecondHalf = reverseList(slow);
        }
        slow = head;
        while (headOfSecondHalf != null) {
            if (headOfSecondHalf.val != slow.val) return false;
            headOfSecondHalf = headOfSecondHalf.next;
            slow = slow.next;
        }
        return true;
        
    }
    private ListNode reverseList(ListNode head) {
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
