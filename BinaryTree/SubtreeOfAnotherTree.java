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
class SubtreeOfAnotherTree {
    public boolean isSubtree(TreeNode root, TreeNode subRoot) {
         if (root == null) {
             if (subRoot == null) return true;
             return false;
         }
        List<TreeNode> traversal = new ArrayList<>();
        traversal.add(root);
        TreeNode currNode = root;
        while (traversal.size() != 0) {
            currNode = traversal.remove(0);
            if (currNode.val == subRoot.val) {
                if (isSameTree(currNode, subRoot)) return true;
            }
            if (currNode.left != null) {
                traversal.add(currNode.left);
            }
            if (currNode.right != null) {
                traversal.add(currNode.right);
            }
        }
        return false;
    }
    public boolean isSameTree(TreeNode root1, TreeNode root2) {
        if (root1 == null && root2 == null) return true;
        if (root1 == null || root2 == null) return false;
        if (root1.val != root2.val) return false;
        return isSameTree(root1.left, root2.left) && isSameTree(root1.right, root2.right);
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
    public boolean isSubtree(TreeNode root, TreeNode subRoot) {
        if (root == null && subRoot == null) return true;
        if (root == null) return false;
        if (subRoot == null) return false;
        boolean result = false;
        if (root.val == subRoot.val) {
            result = isSameTree(root, subRoot);
            if (result) return result;
        }
        result = isSubtree(root.left, subRoot) || isSubtree(root.right, subRoot);

        return result;
    }
    
    private boolean isSameTree(TreeNode root1, TreeNode root2) {
        if (root1 == null && root2 == null) return true;
        if (root1 == null || root2 == null) return false;
        if (root1.val == root2.val) return isSameTree(root1.left, root2.left) && isSameTree(root1.right, root2.right);
        return false;
    }
}
