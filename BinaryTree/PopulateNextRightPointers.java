/*
// Definition for a Node.
class Node {
    public int val;
    public Node left;
    public Node right;
    public Node next;

    public Node() {}
    
    public Node(int _val) {
        val = _val;
    }

    public Node(int _val, Node _left, Node _right, Node _next) {
        val = _val;
        left = _left;
        right = _right;
        next = _next;
    }
};
*/

class PopulateNextRightPointers {
    public Node connect(Node root) {
        if (root == null) return null;
        List<Node> queue = new ArrayList<>();
        queue.add(root);
        Node firstNode;
        while (queue.size() != 0) {
            int currentSize = queue.size();
            for (int i = 0; i < currentSize; i++) {
                firstNode = queue.remove(0);
                if (i != currentSize - 1) {
                    firstNode.next = queue.get(0);
                }
                if (firstNode.left != null) {
                    queue.add(firstNode.left);
                }
                if (firstNode.right != null) {
                    queue.add(firstNode.right);
                }
            }
        }
        return root;
    }
}

//better solution: https://leetcode.com/problems/populating-next-right-pointers-in-each-node/discuss/37461/Java-solution-with-O(1)-memory%2B-O(n)-time
