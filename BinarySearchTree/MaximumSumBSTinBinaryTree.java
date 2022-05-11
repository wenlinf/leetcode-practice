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
    public int maxSumBST(TreeNode root) {
        traverse(root);
        return maxSum;
    } 
    
    int maxSum = 0;
    
    private int[] traverse(TreeNode root) {
        if (root == null) return new int[]{1, 0, Integer.MAX_VALUE, Integer.MIN_VALUE};
        // int[] stores isBST， sum, min, max
        int[] left = traverse(root.left);
        int[] right = traverse(root.right);
        int[] res = new int[4];
        if (left[0] == 1 
            && right[0] == 1 
            && left[3] < root.val 
            && root.val < right[2]) {
            res[0] = 1;
            res[1] = left[1] + root.val + right[1];
            maxSum = Math.max(maxSum, res[1]);
            res[2] = Math.min(root.val, left[2]);
            res[3] = Math.max(root.val, right[3]);
        } else {
            res[0] = 0;
        }
        return res;
    } 
} 
