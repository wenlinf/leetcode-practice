/*
// Definition for a Node.
class Node {
    int val;
    Node next;
    Node random;

    public Node(int val) {
        this.val = val;
        this.next = null;
        this.random = null;
    }
}
*/

class Solution {
    public Node copyRandomList(Node head) {
        Node curr = head;
        Map<Node, Node> map = new HashMap<>();
        while (curr != null) {
            Node copy = new Node(curr.val);
            map.put(curr, copy);
            curr = curr.next;
        }
        Node dummy = new Node(-99999);
        Node traverse = dummy;
        curr = head;
        while (curr != null) {
            Node next = map.get(curr);
            next.random = map.get(curr.random);
            traverse.next = next;
            traverse = traverse.next;
            curr = curr.next;
        }
        return dummy.next;
    }
}
