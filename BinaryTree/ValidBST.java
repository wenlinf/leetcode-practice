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
class ValidBST {
    public boolean isValidBST(TreeNode root) {
        List<Integer> list = inorderTraversal(root);
        int prev = list.get(0);
        for (int i = 1; i < list.size(); i++) {
            if (list.get(i) <= prev) return false;
            prev = list.get(i);
        }
        return true;
    }
    private List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> list = new ArrayList<Integer>();
        if (root == null) return list;
        list.addAll(inorderTraversal(root.left));
        list.add(root.val);
        list.addAll(inorderTraversal(root.right));
        return list;
    }
}


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
    public boolean isValidBST(TreeNode root) {
        if (root.left == null && root.right == null) return true;
        return helper(root, null, null);
    }
    
    private boolean helper(TreeNode root, TreeNode min, TreeNode max) {
        if (root == null) return true;
        if (min != null && root.val <= min.val) return false;
        if (max != null && root.val >= max.val) return false;
        return helper(root.left, min, root) && helper(root.right, root, max);
    }
}
