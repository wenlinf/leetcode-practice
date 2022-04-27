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
    public List<Integer> rightSideView(TreeNode root) {
        List<Integer> result = new ArrayList<>();
        TreeNode curr = root;
        Queue<TreeNode> queue = new LinkedList<>();
        if (root != null) queue.add(root);
        
        while (queue.size() != 0) {
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                TreeNode pop = queue.remove();
                if (pop.left != null) queue.add(pop.left);
                if (pop.right != null) queue.add(pop.right);
                if (i == size - 1) result.add(pop.val);
            }
        }
        return result;
    }
}
