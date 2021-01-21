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
        int maxDepth = 1;
        int maxLeftDepth = 1;
        int maxRightDepth = 1;
        if (root.left != null) {
            maxLeftDepth = maxDepth(root.left);
        }
        if (root.right != null) {
            maxRightDepth = maxDepth(root.right);
        }
        maxDepth += Math.max(maxLeftDepth, maxRightDepth);
        return maxDepth;
    }
}
