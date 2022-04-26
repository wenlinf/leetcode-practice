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
    public List<Double> averageOfLevels(TreeNode root) {
        Queue<TreeNode> queue = new LinkedList<>();
        List<Double> result = new ArrayList<>();
        queue.add(root);
        while (queue.size() != 0) {
            int size = queue.size();
            double sum = 0;
            for (int i = 0; i < size; i++) {
                TreeNode pop = queue.remove();
                if (pop.left != null) {
                    queue.add(pop.left);
                }
                if (pop.right != null) {
                   queue.add(pop.right); 
                }
                sum += pop.val;
            }
            result.add(sum/size);
        }
        return result;
    }
    
    
}
