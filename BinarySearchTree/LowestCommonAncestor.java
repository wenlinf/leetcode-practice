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
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        // if one of them is the root, return the root
        if (root.val == p.val || root.val == q.val) {
            return root;
        }
        // if one is greater than root, the other is less than root, return root
        if ((root.val > p.val && root.val < q.val) 
            || (root.val < p.val && root.val > q.val)) {
            return root;
        } else if (p.val > root.val && q.val > root.val) {
            // if both greater than root, root.= root.right, and repeat
            return lowestCommonAncestor(root.right, p, q);
        } else {
            // if (p.val < root.val && q.val < root.val)
            return lowestCommonAncestor(root.left, p, q);
        }
        // if both smaller than root, root=root.left, and repeat
    }
}
