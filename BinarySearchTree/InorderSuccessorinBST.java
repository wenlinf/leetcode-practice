/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
class Solution {
    private TreeNode previous;
    public TreeNode inorderSuccessor(TreeNode root, TreeNode p) {
        if (p.val > root.val) {
            // traverse the right subtree
            return inorderSuccessor(root.right, p);
        } else if (p == root) {
            // return leftmost node on the right subtree
            TreeNode iter = root.right;
            if (iter == null) return previous;
            while (iter.left != null) {
                iter = iter.left;
            }
            return iter;
        } else {
            previous = root;
            // if rightmost node == p, return previous
            TreeNode iter = root.left;
            while (iter.right != null) {
                iter = iter.right;
            }
            if (iter == p) {
                return previous;
            } else {
                return inorderSuccessor(root.left, p);
            }
            // return the parent of p
        }
    }
}

class Solution {    
    public TreeNode inorderSuccessor(TreeNode root, TreeNode p) {
        if (root == null) return null;
        if (root.left == null && root.right == null) return null;
        if (root == p) {
            TreeNode leftMostChild = findLeftMostChild(root.right);
            return leftMostChild;
        }
        if (p.val > root.val) {
            return inorderSuccessor(root.right, p);
        }
        if (p.val < root.val) {
            TreeNode result = inorderSuccessor(root.left, p);
            if (result == null) {
                return root;
            }
            return result;
        }
        return null;
    }
    
    private TreeNode findLeftMostChild(TreeNode root) {
        if (root == null) return null;
        TreeNode curr = root;
        while (curr.left != null) {
            curr = curr.left;
        }
        return curr;
    }
}
