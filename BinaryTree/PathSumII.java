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
    public List<List<Integer>> pathSum(TreeNode root, int targetSum) {
        // if root == null return []
        // do dfs on each path and check the sum
        // if the sum == targetSum, put all nodes in a list and add to result
        // else go up one node and add its other child
        // if sum == target, create a list
        // otherwise keep going up one node
        List<List<Integer>> result = new ArrayList<>();
        if (root == null) return result;
        int pathSum = 0;
        Stack<TreeNode> stack = new Stack<>();
        stack.push(root);
        Set<TreeNode> visited = new HashSet<>();
        List<Integer> path = new ArrayList<>();
        while (stack.size() != 0) {
            // only peek not pop
            TreeNode pop = stack.peek();
            if (!visited.contains(pop)) {
                path.add(pop.val);
                pathSum+=pop.val;
                if (pop.left == null && pop.right == null) {
                    if (pathSum == targetSum) {
                        List<Integer> copy = new ArrayList<>();
                        copy.addAll(path);
                        result.add(copy);
                    }
                    path.remove(path.size() - 1);
                    pathSum -= pop.val;
                    stack.pop();
                } else {
                    if (pop.right != null) {
                        stack.push(pop.right);
                    }
                    if (pop.left != null) {
                        stack.push(pop.left);
                    }
                } 
                visited.add(pop);
            } else {
                stack.pop();
                path.remove(path.size() - 1);
                pathSum -= pop.val;
            }     
        }
        return result;
    }

}


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
    List<List<Integer>> result = new ArrayList<>();
    public List<List<Integer>> pathSum(TreeNode root, int targetSum) {
        if (root == null) return result;
        backtrack(root, targetSum, new LinkedList<>());
        return result;
    }

    private void backtrack(TreeNode root, int targetSum, LinkedList<Integer> path) {
        if (root == null) {
            return;
        }
        if (root.left == null && root.right == null) {
            if (targetSum == root.val) {
                path.add(root.val);
                this.result.add(new ArrayList<>(path));
                path.removeLast();
            }
            return;
        }
        targetSum -= root.val;
        path.add(root.val);
        backtrack(root.left, targetSum, path);
        backtrack(root.right, targetSum, path);
        path.removeLast();
        targetSum += root.val;
    }
}
