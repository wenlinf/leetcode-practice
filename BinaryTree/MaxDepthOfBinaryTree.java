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
class MaxDepthOfBinaryTree {
    public int maxDepth(TreeNode root) {
        if (root == null) return 0;
        if (root.left == null && root.right == null) return 1;
        int maxLeft = maxDepth(root.left);
        int maxRight = maxDepth(root.right);
        return Math.max(maxLeft,maxRight)+1;
    }
    
    public int maxDepth2(TreeNode root) {
        if (root == null) return 0;
        int depth = 1;
        int subMaxDepth = Math.max(maxDepth(root.left), maxDepth(root.right));
        return depth + subMaxDepth;
    }
}
