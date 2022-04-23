/*
// Definition for a Node.
class Node {
    public int val;
    public List<Node> children;

    public Node() {}

    public Node(int _val) {
        val = _val;
    }

    public Node(int _val, List<Node> _children) {
        val = _val;
        children = _children;
    }
};
*/

class Solution {
    public int maxDepth(Node root) {
        return helper(root);
    }
    
    private int helper(Node root) {
        if (root == null) return 0;
        List<Node> childNodes = root.children;
        int size = childNodes.size();
        int maxDepth = 0;
        for (int i = 0; i < size; i++) {
            maxDepth = Math.max(helper(root.children.get(i)), maxDepth);
        }
        return 1 + maxDepth;
    }
}
