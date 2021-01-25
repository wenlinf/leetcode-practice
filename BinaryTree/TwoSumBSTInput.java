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
class TwoSumBSTInput {
    public boolean findTarget(TreeNode root, int k) {
        //inorder traversal -> get all the sorted nodes in an array
        //use two pointers
        List<Integer> nodes = inorderTraversal(root);
        int pt1 = 0;
        int pt2 = nodes.size() - 1;
        while (pt1 < pt2) {
            if (nodes.get(pt1) + nodes.get(pt2) < k) {
                pt1++;
            } else if (nodes.get(pt1) + nodes.get(pt2) > k) {
                pt2--;
            } else {
                return true;
            }
        }
        return false;    
    }
    private List<Integer> inorderTraversal(TreeNode root) {
        if (root == null) return null;
        List<Integer> list = new ArrayList<>();
        if (root.left != null) list.addAll(inorderTraversal(root.left));
        list.add(root.val);
        if (root.right != null) list.addAll(inorderTraversal(root.right));
        return list;
    }
}
