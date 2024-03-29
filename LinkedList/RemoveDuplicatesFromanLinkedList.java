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
    public ListNode deleteDuplicatesUnsorted(ListNode head) {
        Map<Integer,Integer> map = new HashMap<>();
        ListNode curr = head;
        while (curr != null) {
            map.put(curr.val, map.getOrDefault(curr.val, 0) + 1);
            curr = curr.next;
        }
        ListNode dummy = new ListNode();
        ListNode iter = dummy;
        curr = head;
        while (curr != null) {
            if (map.get(curr.val) == 1) {
                iter.next = curr;
                iter = iter.next;
            }
            curr = curr.next;
        }
        iter.next = null;
        return dummy.next;
    }
}
