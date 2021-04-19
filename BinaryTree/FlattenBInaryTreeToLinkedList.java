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
class FlattenBInaryTreeToLinkedList {
    public void flatten(TreeNode root) {
        if (root == null) return;
        List<TreeNode> list = preOrder(root);
        for (int i = 0; i < list.size(); i++) {
            if (i != list.size() - 1) {
                list.get(i).right = list.get(i+1);
            } else {
                list.get(i).right = null;
            }
            list.get(i).left = null;
        }
    }
    
    private List<TreeNode> preOrder(TreeNode root) {
        List<TreeNode> list = new ArrayList<>();
        list.add(root);
        if (root.left != null) list.addAll(preOrder(root.left));
        if (root.right != null) list.addAll(preOrder(root.right));
        return list;
    }
}
