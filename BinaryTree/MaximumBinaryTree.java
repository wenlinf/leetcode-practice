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
    public TreeNode constructMaximumBinaryTree(int[] nums) {
        if (nums.length == 0) return null;
        int pivot = findMax(nums);
        TreeNode root = new TreeNode(nums[pivot]);
        root.left = constructMaximumBinaryTree(Arrays.copyOfRange(nums, 0, pivot));
        root.right = constructMaximumBinaryTree(Arrays.copyOfRange(nums, pivot + 1, nums.length));
        return root;
    }
    
    private int findMax(int[] nums) {
        int max = nums[0];
        int result = 0;
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] > max) {
                max = nums[i];
                result = i;
            }
        }
        return result;
    }
}
