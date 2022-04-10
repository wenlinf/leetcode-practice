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
    private Map<String, Integer> seen;
    private List<TreeNode> result;
    
    public List<TreeNode> findDuplicateSubtrees(TreeNode root) {
        this.seen = new HashMap<>();
        this.result = new ArrayList<>();
        traverse(root);
        return result;
    }
    
    private String traverse(TreeNode root) {
        if (root == null) return "#";
        String left = traverse(root.left);
        String right = traverse(root.right);
        String subtree = left + "," + right + "," + root.val;
        if (this.seen.containsKey(subtree)) {
            if (seen.get(subtree) == 1) {
                result.add(root);
            }
        } 
        seen.put(subtree, seen.getOrDefault(subtree, 0) + 1);
        return subtree;
    }
}
