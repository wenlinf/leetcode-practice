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
    public int rangeSumBST(TreeNode root, int low, int high) {
        List<Integer> inorderList = inorder(root);
        int sum = 0;
        int start = inorderList.size();
        for (int i = 0; i < inorderList.size(); i++) {
            if (inorderList.get(i) == low) {
                sum += inorderList.get(i);
                start = i;
            } 
            if (i > start && inorderList.get(i) <= high) {
                sum += inorderList.get(i);
            } 
        }
        return sum;
    }
    
    private List<Integer> inorder(TreeNode root) {
        List<Integer> nodes = new ArrayList<>();
        if (root == null) return nodes;
        if (root.left == null && root.right == null) {
            nodes.add(root.val);
            return nodes;
        }
        nodes.addAll(inorder(root.left));
        nodes.add(root.val);
        nodes.addAll(inorder(root.right));
        return nodes;        
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
    public int rangeSumBST(TreeNode root, int low, int high) {
        int sum = 0;
        if (root == null) return sum;
          if (root.val > high) {
            sum = rangeSumBST(root.left, low, high);
          } else if (root.val < low) {
            sum = rangeSumBST(root.right, low, high);
          } else {
            sum += root.val;
            sum += rangeSumBST(root.left, low, high);
            sum += rangeSumBST(root.right, low, high);
          }
          return sum;
    }
}
