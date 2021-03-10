/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */

class LowestCommonAncestor {
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        TreeNode result = root;
        if (root.left != null) {
            if (hasNode(root.left, p) && hasNode(root.left, q)) {
                result = lowestCommonAncestor(root.left, p, q);
            }
        }
        if (root.right != null) {
            if (hasNode(root.right, p) && hasNode(root.right, q)) {
                result = lowestCommonAncestor(root.right, p, q);
            }  
        }
        return result;
    }
    
    private boolean hasNode(TreeNode root, TreeNode randomNode) {
        if (root == randomNode) return true;
        boolean result = false;
        if (root.left != null) {
            result = hasNode(root.left, randomNode);
        } 
        if (!result && root.right != null) {
            result = hasNode(root.right, randomNode);
        }
        return result;
    }
    public TreeNode lowestCommonAncestor2(TreeNode root, TreeNode p, TreeNode q) {
        TreeNode result = root;
        if ((p.val <= root.val && q.val >= root.val) || (q.val <= root.val && p.val >= root.val)) {
            return result;
        }
        if (p.val < root.val && q.val < root.val) {
            result = lowestCommonAncestor(root.left, p, q);
        } else if (p.val > root.val && q.val > root.val) {
            result = lowestCommonAncestor(root.right, p, q);
        }
        return result;
    }   
}


