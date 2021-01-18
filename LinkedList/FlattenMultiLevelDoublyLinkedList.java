/*
// Definition for a Node.
class Node {
    public int val;
    public Node prev;
    public Node next;
    public Node child;
};
*/

class FlattenMultiLevelDoublyLinkedList {
    public Node flatten(Node head) {
        if (head == null) return head;
        Node pointer = head;
        Node temp = null;
        while (pointer != null) {
            if (pointer.child != null) {
                temp = pointer.child;
                while (temp.next != null) {
                    temp = temp.next;
                }
                temp.next = pointer.next;
                if (pointer.next != null) {
                    temp.next.prev = temp;
                }
                pointer.next = pointer.child;
                pointer.next.prev = pointer;
                pointer.child = null;
            } else {
                pointer = pointer.next;
            }     
        }
        return head;
    }
}
