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
class MinDepthOfBinaryTree {
    public int minDepth(TreeNode root) {
        if (root == null) return 0;
        if (root.left == null && root.right == null) return 1;
        int leftDepth = 1;
        int rightDepth = 1;
        if (root.left != null) leftDepth += minDepth(root.left);
        if (root.right != null) rightDepth += minDepth(root.right);
        if (leftDepth == 1 || rightDepth == 1) return Math.max(leftDepth, rightDepth);
        return Math.min(leftDepth, rightDepth);
    }
}
