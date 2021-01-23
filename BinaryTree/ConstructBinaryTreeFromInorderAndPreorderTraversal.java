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
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        if (preorder.length == 0 || inorder.length == 0) return null;
        if (preorder.length == 1 || inorder.length == 1) return new TreeNode(preorder[0]);
        TreeNode root = new TreeNode(preorder[0]);
        int i;
        for (i = 0; i < inorder.length; i++) {
            if (inorder[i] == root.val) break;
        }
        int[] subLeftTreeInorder;
        int[] subRightTreeInorder;
        int[] subLeftTreePreorder;
        int[] subRightTreePreorder;
        subLeftTreeInorder = Arrays.copyOfRange(inorder, 0, i);
        subLeftTreePreorder = Arrays.copyOfRange(preorder, 1, i + 1);
        subRightTreeInorder = Arrays.copyOfRange(inorder, i + 1, inorder.length);
        subRightTreePreorder = Arrays.copyOfRange(preorder, i + 1, preorder.length);
        root.left = buildTree(subLeftTreePreorder, subLeftTreeInorder);
        root.right = buildTree(subRightTreePreorder, subRightTreeInorder);
        return root;
    }
}
