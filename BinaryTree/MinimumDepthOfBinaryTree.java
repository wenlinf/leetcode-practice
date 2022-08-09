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
class MinDepthOfBinaryTree {
    public int minDepth(TreeNode root) {
        if (root == null) return 0;
        int leftDepth = minDepth(root.left);
        int rightDepth = minDepth(root.right);
        if (leftDepth == 0 || rightDepth == 0) return Math.max(leftDepth, rightDepth) + 1;
        return Math.min(leftDepth, rightDepth) + 1;
    }
}


// BFS solution
class Solution {
    public int minDepth(TreeNode root) {
        if (root == null) return 0;
        LinkedList<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        int depth = 0;
        while (!queue.isEmpty()) {
            int levelSize = queue.size();
            depth++;
            while (levelSize > 0) {
                TreeNode start = queue.poll();
                if (start.left == null && start.right == null) {
                    return depth;
                }
                if (start.left != null) {
                    queue.add(start.left);
                }
                if (start.right != null) {
                    queue.add(start.right);
                }
                levelSize--;
            }
        }
        return -1;
    }
}
