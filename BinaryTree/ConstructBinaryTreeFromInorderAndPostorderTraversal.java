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
class ConstructBinaryTreeFromInorderAndPostorderTraversal {
    public TreeNode buildTree(int[] inorder, int[] postorder) {
        if (inorder.length == 0 || postorder.length == 0) return null;
        if (inorder.length == 1 || postorder.length == 1) return new TreeNode(inorder[0]);
        TreeNode root = new TreeNode(postorder[postorder.length - 1]);
        int i;
        for (i = 0; i < inorder.length; i++) {
            if (inorder[i] == root.val) break;
        }
        int[] subLeftTreeInorder;
        int[] subRightTreeInorder;
        int[] subLeftTreePostorder;
        int[] subRightTreePostorder;
        if (i == inorder.length - 1) {
            root.right = null;
        } else {
            subRightTreeInorder = Arrays.copyOfRange(inorder, i+1, inorder.length);
            subRightTreePostorder = Arrays.copyOfRange(postorder, i, postorder.length - 1);
            root.right = buildTree(subRightTreeInorder, subRightTreePostorder);
        }
        subLeftTreeInorder = Arrays.copyOfRange(inorder, 0, i);
        subLeftTreePostorder = Arrays.copyOfRange(postorder, 0, i);
        root.left = buildTree(subLeftTreeInorder, subLeftTreePostorder);          
        return root;
    }
}
