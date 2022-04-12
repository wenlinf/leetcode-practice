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
class Solution {
    public int sumOfLeftLeaves(TreeNode root) {
        this.sum = 0;
        traverse(root);
        return sum;
    }
    
    private int sum;
    private void traverse(TreeNode root) {
        if (!hasChild(root)) return;
        if (root.left != null) {
            if (!hasChild(root.left)) {
                sum += root.left.val;
            } else {
                traverse(root.left);
            }
        }
        traverse(root.right);
    }
    
    private boolean hasChild(TreeNode root) {
        if (root == null) return false;
        return root.left != null || root.right != null;
    }
}
