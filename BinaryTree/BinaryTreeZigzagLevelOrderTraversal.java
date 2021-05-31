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
class BinaryTreeZigzagLevelOrderTraversal {
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        Stack<TreeNode> stack = new Stack<>();
        stack.push(root);
        List<List<Integer>> result = new ArrayList<>();
        if (root == null) return result;
        boolean reverse = false;
        while (stack.size() != 0) {
            int count = stack.size();
            int i = 0;
            List<Integer> level = new ArrayList<>();
            Stack<TreeNode> temp = new Stack<>();
            while (i < count) {
                TreeNode node = stack.pop();
                level.add(node.val);
                if (reverse) {
                    if (node.right != null) temp.push(node.right);
                    if (node.left != null) temp.push(node.left);
                } else {
                    if (node.left != null) temp.push(node.left);
                    if (node.right != null) temp.push(node.right); 
                }
                i++;
            }
            reverse = !reverse;
            result.add(level);
            stack.addAll(temp);
        }
        return result;
    }
}
