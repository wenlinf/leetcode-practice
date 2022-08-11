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
    private int maxCount = 0;
    public int[] findMode(TreeNode root) {
        Map<Integer, Integer> count = new HashMap<>();
        helper(root, count);
        List<Integer> result = new ArrayList<>();
        for (Map.Entry<Integer, Integer> entry : count.entrySet()) {
            if (entry.getValue() == maxCount) {
                result.add(entry.getKey());
            }
        }
        int[] modes = new int[result.size()];
        for (int i = 0; i < result.size(); i++) {
            modes[i] = result.get(i);
        }
        return modes;
    }
    
    private void helper(TreeNode root, Map<Integer, Integer> map) {
        if (root == null) return;

        map.put(root.val, map.getOrDefault(root.val, 0) + 1);
        if (map.get(root.val) > maxCount) {
            maxCount = map.get(root.val);
        }
        helper(root.left, map);
        helper(root.right, map);
    }
}
