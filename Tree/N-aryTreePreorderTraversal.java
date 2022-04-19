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
    public List<Integer> preorder(Node root) {
        result = new ArrayList<>();
        helper(root);
        return result;
    }
    private List<Integer> result;
    private void helper(Node root) {
        if (root == null) return;
        List<Node> children = root.children;
        result.add(root.val);
        for (int i = 0; i < children.size(); i++) {
            helper(children.get(i));
        }
    }
}
