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
    public int widthOfBinaryTree(TreeNode root) {
        if (root == null) return 0;
        Queue<Pair<TreeNode, Integer>> queue = new LinkedList<>();
        int count = 0;
        queue.offer(new Pair<TreeNode, Integer>(root, count));
        int maxWidth = 0;
        while (!queue.isEmpty()) {
            int levelSize = queue.size();
            Pair<TreeNode, Integer> head = queue.peek();
            for (int i = 0; i < levelSize; i++) {
                Pair<TreeNode, Integer> pair = queue.poll();
                int index = pair.getValue();
                TreeNode node = pair.getKey();
                if (node.left != null) {
                    queue.offer(new Pair<>(node.left, index * 2 + 1));
                }      
                if (node.right != null) {
                    queue.offer(new Pair<>(node.right, index * 2 + 2));
                }
                if (i == levelSize - 1) {
                    maxWidth = Math.max(maxWidth, index - head.getValue() + 1);
                }
            }  
        }
        return maxWidth;
    }
}
