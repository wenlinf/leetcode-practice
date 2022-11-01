class Node {
    Node prev;
    Node next;
    int key;
    int value;
    
    public Node() {
        
    }
    
    public Node(int key, int value) {
        this.key = key;
        this.value = value;
    }
}

class LRUCache {
    private Node head;
    private Node tail;
    private Map<Integer, Node> map;
    private int capacity;
    
    public LRUCache(int capacity) {
        this.capacity = capacity;
        this.map = new HashMap<>();
        this.head = new Node();
        this.tail = new Node();
        this.head.next= tail;
        this.tail.prev = head;
    }
    
    private void addToTail(Node node) {
        this.tail.prev.next = node;
        node.prev = this.tail.prev;
        
        this.tail.prev = node;
        node.next = this.tail;
    }
    
    private void removeNode(Node node) {
        node.prev.next = node.next;
        node.next.prev = node.prev;
    }
    
    private void removeFromHead() {
        this.map.remove(this.head.next.key);
        removeNode(this.head.next);
    }
    
    public int get(int key) {
        // if not in map return -1
        // if in map, get the node in the linked list 
        // remove it from the list
        // add it to the end of the list
        if (!this.map.containsKey(key)) return -1;
        Node node = map.get(key);
        removeNode(node);
        addToTail(node);
        return node.value;
    }
    
    public void put(int key, int value) {
        // if in map, remove it from the linked list
        // create a new node with the key value
        // append it to the tail
        if (map.containsKey(key)) {
            removeNode(map.get(key));
        }
        Node node = new Node(key, value);
        addToTail(node);
         map.put(key, node);
        if (map.size() > this.capacity) {
            removeFromHead();
        }
    }
}

/**
 * Your LRUCache object will be instantiated and called as such:
 * LRUCache obj = new LRUCache(capacity);
 * int param_1 = obj.get(key);
 * obj.put(key,value);
 */
