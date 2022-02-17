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
    public TreeNode deleteNode(TreeNode root, int key) {
        if (root == null) return null;
        if (root.val == key) {
            if (root.left == null & root.right == null) {
                root = null;
            } else if (root.right != null) {
                TreeNode successor = findSuccessor(root);
                root.val = successor.val;
                root.right = deleteNode(root.right, root.val);
            } else if (root.right == null) {
                TreeNode predecessor = findPredecessor(root);
                root.val = predecessor.val;
                root.left = deleteNode(root.left, root.val);
            }
        } else if (root.val > key) {
            root.left = deleteNode(root.left, key);
        } else {
            root.right = deleteNode(root.right, key);
        }
        return root;
    }
    
    private TreeNode findSuccessor(TreeNode root) {
        TreeNode curr = root.right;
        while (curr.left != null) {
            curr = curr.left;
        }
        return curr;
    }
    
    private TreeNode findPredecessor(TreeNode root) {
        TreeNode curr = root.left;
        while (curr.right != null) {
            curr = curr.right;
        }
        return curr;
    }
}
