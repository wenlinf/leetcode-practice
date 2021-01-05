/**
 * Definition for singly-linked list.
 * class HasCycle {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) {
 *         val = x;
 *         next = null;
 *     }
 * }
 */
public class Solution {
    public boolean hasCycle(ListNode head) {
        Set<ListNode> seen = new HashSet<>();
        while (head != null) {
            if (seen.contains(head)) return true;
            seen.add(head);
            head = head.next;
        }
        return false;
    }
    public boolean hasCycleTwoPointer(ListNode head) {
        /*
        if (head == null || head.next == null) return false;
        int fast = 2;
        int slow = 1;
        ListNode slowHead = head; //???
        while (head != null) {
            for (int i = 0; i < fast; i++) {
                if (head.next == null) return false;
                head = head.next;
            }
            fast += 2;
            for (int i = 0; i < slow; i++) {
                slowHead = slowHead.next;
            }
            slow++;
            if (head == slowHead) return true;
        }
        return false;
        */
        if (head == null) return false;
        ListNode slow = head;
        ListNode fast = head.next;
        while (fast != null && fast.next != null) {
            fast = fast.next.next;
            slow = slow.next;
            if (fast == slow) return true;
        }
        return false;
    }
}
