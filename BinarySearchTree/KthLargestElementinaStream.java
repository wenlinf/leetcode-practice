class KthLargest {

    
    public Node insertNode(Node root, int val) {
        if (root == null) {
            return new Node(val, 1);
        }
        if (root.getVal() < val) {
            root.right = insertNode(root.right, val);
        } else {
            root.left = insertNode(root.left, val);
        }
        root.count++;
        return root;
    }
    
    private int searchKth(Node root, int k) {
        int rightSubTreeSize = root.right == null? 0 : root.right.count;
        
        if (rightSubTreeSize + 1 == k) return root.getVal();
        
        if (rightSubTreeSize >= k) {
            return searchKth(root.right, k);
        } else {
            return searchKth(root.left, k - rightSubTreeSize - 1);
        }
    }
    private Node root;
    private int k;

    public KthLargest(int k, int[] nums) {
        root = null;
        this.k = k;
        for (int i = 0; i < nums.length; i++) {
            root = insertNode(root, nums[i]);
        }
    }
    
    public int add(int val) {
        root = insertNode(root, val);
        return searchKth(root, k);
    }
    

}

class Node {
    public Node left;
    public Node right;
    public int count;
    private int val;
    
    public Node(int val, int count) {
        this.val = val;
        this.count = count;
        this.left = null;
        this.right = null;
    }
    
    public int getCount() {
        return this.count;
    }
    
    public void setCount(int count) {
        this.count = count;
    }
    
    public int getVal() {
        return this.val;
    }
}

/**
 * Your KthLargest object will be instantiated and called as such:
 * KthLargest obj = new KthLargest(k, nums);
 * int param_1 = obj.add(val);
 */
