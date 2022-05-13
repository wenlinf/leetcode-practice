/*
// Definition for a Node.
class Node {
    public int val;
    public Node left;
    public Node right;
    public Node parent;
};
*/

class Solution {
    public Node lowestCommonAncestor(Node p, Node q) {
        if (p == null || q == null) return null;
        Node pt1 = p;
        Node pt2 = q;
        while (pt1 != pt2) {
            if (pt1 == null) {
                pt1 = q;
            } else {
                pt1 = pt1.parent;
            }
            if (pt2 == null) {
                pt2 = p;
            } else {
                pt2 = pt2.parent;
            }
        }
        return pt1;
    }
}
