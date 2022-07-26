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
    public List<List<Integer>> verticalOrder(TreeNode root) {
        TreeMap<Integer, TreeMap<Integer, List<Integer>>> map = new TreeMap<>();
        helper(root, 0, 0, map);
        List<List<Integer>> list = new ArrayList<>();
        for (Map.Entry<Integer, TreeMap<Integer, List<Integer>>> entry : map.entrySet()) {
            TreeMap<Integer, List<Integer>> cols = entry.getValue();
            List<Integer> vertical = new ArrayList<>();
            for (Map.Entry<Integer, List<Integer>> col : cols.entrySet()) {
                // List<Integer> subList = col.getValue();
                vertical.addAll(col.getValue());
            }
            list.add(vertical);
        }
        return list;
    }
    
    
    private void helper(TreeNode root, int row, int col, TreeMap<Integer, TreeMap<Integer, List<Integer>>> map) {
        if (root == null) return;
        if (map.get(col) == null) {
            map.put(col, new TreeMap<Integer, List<Integer>>());
        }
        if (map.get(col).get(row) == null) {
            map.get(col).put(row, new ArrayList<>());
        }
        map.get(col).get(row).add(root.val);
        helper(root.left, row + 1, col - 1, map);
        helper(root.right, row + 1, col + 1, map);
    }
}
