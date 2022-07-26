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
    public int sumNumbers(TreeNode root) {
        List<String> nums = new ArrayList<>();
        helper(root, new StringBuilder(), nums);
        int sum = 0;
        for (int i = 0; i < nums.size(); i++) {
            sum += Integer.valueOf(nums.get(i));
        }
        return sum;
    }
    
    private void helper(TreeNode root, StringBuilder sb, List<String> nums) {
        if (root == null) return;
        if (root.left == null && root.right == null) {
            sb.append(root.val);
            nums.add(sb.toString());
            sb.setLength(sb.length() - 1);
            return;
        }
        sb.append(root.val);
        helper(root.left, sb, nums);
        helper(root.right, sb, nums);
        sb.setLength(sb.length() - 1);
    }
    
}
