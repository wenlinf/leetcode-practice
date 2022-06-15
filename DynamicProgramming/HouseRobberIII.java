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
    private Map<TreeNode, Integer> map = new HashMap<>();
    public int rob(TreeNode root) {
       
        if (root == null) return 0;
        if (map.containsKey(root)) return map.get(root);
        if (root.left == null && root.right == null) {
            map.put(root, root.val);
            return map.get(root);
        }
        if (root.left == null) {
            map.put(root, Math.max(root.val + rob(root.right.right) + rob(root.right.left), rob(root.right)));
            
        } else if (root.right == null) {
            map.put(root, Math.max(root.val + rob(root.left.left) + rob(root.left.right), rob(root.left)));
            
        } else {
            map.put(root, Math.max(root.val + rob(root.left.left) + rob(root.left.right) + rob(root.right.right) + rob(root.right.left), rob(root.left) + rob(root.right)));
        }
    
        return map.get(root);
    }
}
