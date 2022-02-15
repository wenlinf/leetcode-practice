/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class BSTIterator {
    private int curr;
    private List<TreeNode> nodes;

    public BSTIterator(TreeNode root) {
        List<TreeNode> nodes = inorder(root);
        this.nodes = nodes;
        this.curr = -1;
    }
    
    private List<TreeNode> inorder(TreeNode root) {
        List<TreeNode> nodes = new ArrayList<>();

        if (root == null) return nodes;
        if (root.left != null) {
            nodes.addAll(inorder(root.left));
        }
        nodes.add(root);
        if (root.right != null) {
            nodes.addAll(inorder(root.right));
        }
        return nodes;
    }
    
    public int next() {
        this.curr++;
        return nodes.get(curr).val;
    }
    
    public boolean hasNext() {
        return curr != nodes.size() - 1; 
    }
}

/**
 * Your BSTIterator object will be instantiated and called as such:
 * BSTIterator obj = new BSTIterator(root);
 * int param_1 = obj.next();
 * boolean param_2 = obj.hasNext();
 */
