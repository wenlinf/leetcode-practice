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
    public int pseudoPalindromicPaths (TreeNode root) {
        dfs(root, 0);
        return res;
    }

    private int res;

    private void dfs(TreeNode root, int path) {
        if (root == null) return;
        path = path ^ (1 << root.val);
        if (root.left == null && root.right == null) {
            if ((path & (path - 1)) == 0) {
                res++;
            }
        } else {
            dfs(root.left, path);
            dfs(root.right, path);
        }
    }
}
