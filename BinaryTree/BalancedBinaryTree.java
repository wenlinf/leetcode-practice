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
class BalancedBinaryTree {
    boolean result = true;
    public boolean isBalanced(TreeNode root) {
        findMaxDepth(root);
        return result;
    }
    private int findMaxDepth(TreeNode root) {
        if (root == null) return 0;
        if (root.left == null && root.right == null) return 1;
        int maxLeft = findMaxDepth(root.left);
        int maxRight = findMaxDepth(root.right);
        if (Math.abs(maxRight - maxLeft) > 1) result = false;
        return Math.max(maxRight, maxLeft)+1;
    }
    
}
