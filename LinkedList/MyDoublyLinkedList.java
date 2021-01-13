class MyDoublyLinkedList {
        private class Node {
            public int val;
            public Node next;
            public Node prev;
            public Node(int val) {
                this.val = val;
                this.next = null;
                this.prev = null;
            }
        }

        private Node head;
        private int size;

        /** Initialize your data structure here. */
        public MyLinkedList() {
            this.head = null;
            this.size = 0;
        }

        /** Get the value of the index-th node in the linked list. If the index is invalid, return -1. */
        public int get(int index) {
            if (index < 0 || index >= this.size) return -1;
            Node result = this.head;
            for (int i = 0; i < index; i++) {
                result = result.next;
            }
            return result.val;
        }

        /** Add a node of value val before the first element of the linked list. After the insertion, the new node will be the first node of the linked list. */
        public void addAtHead(int val) {
            Node newHead = new Node(val);
            if(this.head != null) {
                Node currentHead = this.head;
                newHead.next = currentHead;
                currentHead.prev = newHead;
            }

            this.head = newHead;
            this.size++;
        }

        /** Append a node of value val to the last element of the linked list. */
        public void addAtTail(int val) {
            Node newTail = new Node(val);
            if (this.size == 0) {
                this.head = newTail;
            } else {
                Node currentTail = this.head;
                for (int i = 0; i < this.size - 1; i++) {
                    currentTail = currentTail.next;
                }
                currentTail.next = newTail;
                newTail.prev = currentTail;
            }
            this.size++;
        }

        /** Add a node of value val before the index-th node in the linked list. If index equals to the length of linked list, the node will be appended to the end of linked list. If index is greater than the length, the node will not be inserted. */
        public void addAtIndex(int index, int val) {
            if (index < 0 || index > this.size) return;
            if (index == 0) {
                addAtHead(val);
                return;
            } else if (index == this.size) {
                addAtTail(val);
                return;
            } else {
                Node newNode = new Node(val);
                Node currentNode = this.head;
                for (int i = 0; i < index - 1; i++) {
                    currentNode = currentNode.next;
                }
                Node nextNode = currentNode.next;
                currentNode.next = newNode;
                newNode.prev = currentNode;
                newNode.next = nextNode;
                nextNode.prev = newNode;
            }
            this.size++;
        }

        /** Delete the index-th node in the linked list, if the index is valid. */
        public void deleteAtIndex(int index) {
            if (index < 0 || index >= this.size) return;
            if (this.size == 1) {
                this.head = null;
            } else if (index == 0) {
                Node newHead = this.head.next;
                this.head.next = null;
                this.head = newHead;
            } else if (index == size - 1) {
                Node currentNode = this.head;
                for (int i = 0; i < index-1; i++) {
                    currentNode = currentNode.next;
                }
                Node nodeToDelete = currentNode.next;
                nodeToDelete.prev = null;
                currentNode.next = null;
            } else {
                Node currentNode = this.head;
                for (int i = 0; i < index-1; i++) {
                    currentNode = currentNode.next;
                }
                Node nodeToDelete = currentNode.next;
                Node nextNode = nodeToDelete.next;
                currentNode.next = nextNode;
                nextNode.prev = currentNode;
                nodeToDelete.next = null;
                nodeToDelete.prev = null;
            }
            this.size--;
        }

/**
 * Your MyLinkedList object will be instantiated and called as such:
 * MyLinkedList obj = new MyLinkedList();
 * int param_1 = obj.get(index);
 * obj.addAtHead(val);
 * obj.addAtTail(val);
 * obj.addAtIndex(index,val);
 * obj.deleteAtIndex(index);
 */

    /**
     * Your MyLinkedList object will be instantiated and called as such:
     * MyLinkedList obj = new MyLinkedList();
     * int param_1 = obj.get(index);
     * obj.addAtHead(val);
     * obj.addAtTail(val);
     * obj.addAtIndex(index,val);
     * obj.deleteAtIndex(index);
     */

    public static void main(String[] args) {
        MyLinkedList myLinkedList = new MyLinkedList();
        myLinkedList.addAtHead(2);
        myLinkedList.deleteAtIndex(1);
        myLinkedList.addAtHead(2);
        myLinkedList.addAtHead(7);
        myLinkedList.addAtHead(3);
        myLinkedList.addAtHead(2);
        myLinkedList.addAtHead(5);
//        myLinkedList.addAtHead(5);
        myLinkedList.addAtTail(5);
//        myLinkedList.addAtIndex(3, 0);
//        myLinkedList.addAtIndex(0, 2);
//        myLinkedList.addAtIndex(1, 2);
        myLinkedList.get(5);
//        myLinkedList.addAtIndex(5, 0);
//        myLinkedList.get(0);
       // myLinkedList.addAtHead(1);
      //  myLinkedList.addAtHead(2);
      //  int i = myLinkedList.get(1);
        myLinkedList.deleteAtIndex(6);
        myLinkedList.deleteAtIndex(4);
        //System.out.println(i);
    }
}

/**
 * Your MyLinkedList object will be instantiated and called as such:
 * MyLinkedList obj = new MyLinkedList();
 * int param_1 = obj.get(index);
 * obj.addAtHead(val);
 * obj.addAtTail(val);
 * obj.addAtIndex(index,val);
 * obj.deleteAtIndex(index);
 */
