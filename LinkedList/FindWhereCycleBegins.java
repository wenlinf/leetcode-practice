/**
 * Definition for singly-linked list.
 * class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) {
 *         val = x;
 *         next = null;
 *     }
 * }
 */
public class FindWhereCycleBegins {
    public ListNode detectCycle(ListNode head) {
        if (head == null) return null;
        Set<ListNode> seen = new HashSet<>();
        while (head.next != null) {
            if (seen.contains(head)) {
                return head;
            }
            seen.add(head);
            head = head.next;
        }
        return null;
    }
}
