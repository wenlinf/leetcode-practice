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
class BinaryTreePreorderTraversal {
    public List<Integer> preorderTraversal(TreeNode root) {
        List<Integer> result = new ArrayList<>();
        if (root == null) return result;
        result.add(root.val);
        if (root.left != null) result.addAll(preorderTraversal(root.left));
        if (root.right != null) result.addAll(preorderTraversal(root.right));
        return result;
    }
}

class Solution {
    List<Integer> nodes = new ArrayList<>();
    public List<Integer> preorderTraversal(TreeNode root) {
        if (root == null) return nodes;
        nodes.add(root.val);
        preorderTraversal(root.left);
        preorderTraversal(root.right);
        return nodes;
    }
}
