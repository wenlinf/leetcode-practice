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
class HasPathSum {
    public boolean hasPathSum(TreeNode root, int targetSum) {
        boolean result = false;
        if (root != null) {
            if (targetSum == root.val && root.right == null && root.left == null) return true;
            if (root.left != null) {
                result = hasPathSum(root.left, targetSum - root.val);
            } 
            if (result) return result;
            if (root.right != null) {
                result = hasPathSum(root.right, targetSum - root.val);
            }
        }
        return result;
    }
}
