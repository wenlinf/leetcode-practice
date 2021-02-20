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
class ConvertSortedArraytoBST {
    public TreeNode sortedArrayToBST(int[] nums) {
        if(nums.length == 0) return null;
        TreeNode root = new TreeNode(nums[nums.length/2]);
        if (nums.length == 1) return root;
        int[] leftArr = Arrays.copyOfRange(nums, 0, nums.length/2);
        int[] rightArr = Arrays.copyOfRange(nums, nums.length/2+1, nums.length);
        root.left = sortedArrayToBST(leftArr);
        root.right = sortedArrayToBST(rightArr);
        return root;
    }
}
