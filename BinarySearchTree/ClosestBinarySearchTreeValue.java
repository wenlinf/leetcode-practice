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
    public int closestValue(TreeNode root, double target) {
        nodes = new ArrayList<>();
        inorder(root);
        for (int i = 0; i < nodes.size(); i++) {
            if (target < nodes.get(i)) {
                if (i - 1 < 0) return nodes.get(i);
                if (Math.abs(target - nodes.get(i - 1)) > Math.abs(target - nodes.get(i))) {
                    return nodes.get(i);
                } else {
                    return nodes.get(i - 1);
                }
            }
        }
        return nodes.get(nodes.size() - 1);
    }
    private  List<Integer> nodes;

    private void inorder(TreeNode root) {
        if (root == null) return;
        inorder(root.left);
        nodes.add(root.val);
        inorder(root.right);
        
    }
}
