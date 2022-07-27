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
    public ListNode mergeKLists(ListNode[] lists) {
        if (lists.length == 0) return null;
        PriorityQueue<ListNode> pq = new PriorityQueue<>((a,b) -> a.val - b.val);
        int size = lists.length;
        for (int i = 0; i < size; i++) {
            if (lists[i] != null) pq.add(lists[i]);
        }
        ListNode dummy = new ListNode(0);
        ListNode curr = dummy;
        while (!pq.isEmpty()) {
            ListNode top = pq.poll();
            curr.next = top;
            if (top.next != null) {
                top = top.next;
                pq.add(top);
            } 
            curr = curr.next;
        }
        return dummy.next;
    }
}
