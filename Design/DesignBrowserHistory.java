class BrowserHistory {
    private Node head;
    private Node curr;

    public BrowserHistory(String homepage) {
        this.head = new Node(homepage);
        this.curr = this.head;
    }
    
    public void visit(String url) {
        this.curr.next = null;
        this.curr.addNode(url);
        this.curr = this.curr.next;
    }
    
    public String back(int steps) {
        while (steps > 0) {
            if (this.curr.prev == null) break;
            this.curr = this.curr.prev;
            steps--;
        }
        return this.curr.getUrl();
    }
    
    public String forward(int steps) {
        while (steps > 0) {
            if (this.curr.next == null) break;
            this.curr = this.curr.next;
            steps--;
        }
        return this.curr.getUrl();
    }
}

class Node {
    private String url;
    public Node next;
    public Node prev;

    public String getUrl() {
        return this.url;
    }

    public Node(String url) {
        this.url = url;
        this.next = null;
        this.prev = null;
    }

    public void addNode(String url) {
        Node newNode = new Node(url);
        this.next = newNode;
        newNode.prev = this;
    }

    public void removeNode() {
        Node currNext = this.next;
        this.prev.next = currNext;
        currNext.prev = this.prev;
        this.prev = null;
        this.next = null;
    }
}

/**
 * Your BrowserHistory object will be instantiated and called as such:
 * BrowserHistory obj = new BrowserHistory(homepage);
 * obj.visit(url);
 * String param_2 = obj.back(steps);
 * String param_3 = obj.forward(steps);
 */
