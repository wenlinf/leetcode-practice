/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
class DeleteNode {
    public void deleteNode(ListNode node) {
        ListNode nextNode = node.next;
        int nextNodeVal = nextNode.val;
        node.val = nextNodeVal;
        node.next = nextNode.next;
        nextNode.next = null;
    }
}
