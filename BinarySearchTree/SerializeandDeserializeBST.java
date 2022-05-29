/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
public class Codec {

    private String SEP = "#";
    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
        StringBuilder sb = new StringBuilder();
        serializeHelper(sb, root);
        return sb.toString();
    }
    
    public void serializeHelper(StringBuilder sb, TreeNode root) {
        if (root == null) return;
        sb.append(root.val).append(SEP);
        serializeHelper(sb, root.left);
        serializeHelper(sb, root.right);
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        if (data.length() == 0) return null;
        
        String[] nodes = data.substring(0, data.length() - 1).split(SEP, -1);
        return builder(nodes, Integer.MIN_VALUE, Integer.MAX_VALUE);
    }
    
    private int index = 0;
    private TreeNode builder(String[] nodes, int min, int max) {
        if (index >= nodes.length) return null;
        int rootVal = Integer.parseInt(nodes[index]);
        if (rootVal < min ||rootVal > max) return null;    
        TreeNode root = new TreeNode(rootVal);
        index++;
        root.left = builder(nodes, min, rootVal);
        root.right = builder(nodes, rootVal, max);
        return root;
    }
}

// Your Codec object will be instantiated and called as such:
// Codec ser = new Codec();
// Codec deser = new Codec();
// String tree = ser.serialize(root);
// TreeNode ans = deser.deserialize(tree);
// return ans;
