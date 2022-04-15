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
    private Map<Integer, Integer> dict;
    public TreeNode constructFromPrePost(int[] preorder, int[] postorder) {
        this.dict = new HashMap<>();
        int m = preorder.length;
        for (int i = 0; i < m; i++) {
            dict.put(postorder[i], i);
        }
        return helper(preorder, 0, m - 1, postorder, 0, m - 1);
    }
    
    private TreeNode helper(int[] preorder, int preStart, int preEnd, 
                            int[] postorder, int postStart, int postEnd) {
        if (preStart > preEnd) return null;
        if (preStart == preEnd) return new TreeNode(preorder[preStart]);
        TreeNode root = new TreeNode(preorder[preStart]);

        int index = dict.get(preorder[preStart + 1]);
        int leftSize = index - postStart + 1;
        int rightSize = postEnd - 1 - index;
        root.left = helper(preorder, preStart + 1, preStart + leftSize, postorder, postStart, postStart + leftSize - 1);
        root.right = helper(preorder, preStart + leftSize + 1, preEnd, postorder, 
                           postStart + leftSize, postEnd - 1);
        return root;
    }
}
