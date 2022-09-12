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


/*
// Definition for a Node.
class Node {
    public int val;
    public Node prev;
    public Node next;
    public Node child;
};
*/

class Solution {
    public Node flatten(Node head) {
        Node curr = head;
        Node tempNext = null;
        while (curr != null) {
            if (curr.child != null) {
                tempNext = curr.next;
                Node childIter = curr.child;
                curr.next = childIter;
                childIter.prev = curr;
                curr.child = null;
                while (childIter.next != null) {
                    childIter = childIter.next;
                }
                childIter.next = tempNext;
                if (tempNext != null) {
                    tempNext.prev = childIter;
                }
                
            } 
            curr = curr.next;
        }
        return head;
    }
}
