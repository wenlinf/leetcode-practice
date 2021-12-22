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
class KthSmallestElementInABST {
    public int kthSmallest(TreeNode root, int k) {
        List<Integer> nodes = inorder(root);
        return nodes.get(k - 1);
    }
    
    public List<Integer> inorder(TreeNode root) {
        if (root == null) return null;
        List<Integer> nodes = new ArrayList<>();
        if (root.left != null) {
            nodes.addAll(inorder(root.left));
        }
        nodes.add(root.val);
        if (root.right != null) {
           nodes.addAll(inorder(root.right)); 
        }
        return nodes;
    }
}
