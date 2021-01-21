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
class SymmetricTree {
    public boolean isSymmetric(TreeNode root) {
        if (root == null) return true;
        if (root.left == null && root.right == null) return true;
        if (root.left == null || root.right == null) return false;
        if (root.left.val != root.right.val) return false;
        List<Integer> leftTraversal = new ArrayList<>();
        List<Integer> rightTraversal = new ArrayList<>();
        leftTraversal = traverseFromLeft(root, leftTraversal);
        rightTraversal = traverseFromRight(root, rightTraversal);
        for (int i = 0; i < leftTraversal.size(); i++) {
            if (leftTraversal.get(i) != rightTraversal.get(i)) return false;
        }
        return true;
    }
    private List<Integer> traverseFromLeft(TreeNode root, List<Integer> list) {
        if (root == null) return null;
        if (root.left == null && root.right == null) {
            list.add(root.val);
            return list;
        }
        if (root.left == null) list.add(null);
        if (root.left != null) traverseFromLeft(root.left, list);
        list.add(root.val);
        if (root.right == null) list.add(null);
        if (root.right != null) traverseFromLeft(root.right, list);
        return list;
    }
    private List<Integer> traverseFromRight(TreeNode root, List<Integer> list) {
        if (root == null) return null;
        if (root.left == null && root.right == null) {
            list.add(root.val);
            return list;
        }
        if (root.right == null) list.add(null);
        if (root.right != null) traverseFromRight(root.right, list);
        list.add(root.val);
        if (root.left == null) list.add(null);
        if (root.left != null) traverseFromRight(root.left, list);
        return list;
    }
}
