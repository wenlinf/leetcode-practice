/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
class Solution {

    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        List<TreeNode> nodes = postOrder(root);

        for (TreeNode node: nodes) {
            if (hasTarget(node, p) && hasTarget(node, q)) return node;
        }
        return null;
    }
    
    private List<TreeNode> postOrder(TreeNode root) {
        List<TreeNode> nodes = new ArrayList<>();
        if (root.left != null) nodes.addAll(postOrder(root.left));
        if (root.right != null) nodes.addAll(postOrder(root.right));
        nodes.add(root);
        return nodes;
    }
    
    private boolean hasTarget(TreeNode root, TreeNode target) {
        if (root == null) return false;
        if (root.val == target.val) return true;
        return hasTarget(root.left, target) || hasTarget(root.right, target);
    }
}
