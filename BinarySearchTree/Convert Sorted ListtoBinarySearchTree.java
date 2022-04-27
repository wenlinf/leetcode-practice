/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
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
    public TreeNode sortedListToBST(ListNode head) {
        ListNode curr = head;
        int size = 0;
        while (curr != null) {
            size++;
            curr = curr.next;
        }
        int[] arr = new int[size];
        int lo = 0;
        int hi = size - 1;
        
        for (int i = 0; i < size; i++) {
            arr[i] = head.val;
            head = head.next;
        }
        
        int mid = lo + (hi - lo) / 2;
        TreeNode root = build(arr, lo, hi, mid);
        return root;
    }
    
    private TreeNode build(int[] arr, int lo, int hi, int mid) {
        if (lo > hi) return null;
        if (lo == hi) return new TreeNode(arr[lo]);
        TreeNode root = new TreeNode(arr[mid]);
        root.left = build(arr, lo, mid - 1, lo + (mid - 1 - lo) / 2);
        root.right = build(arr, mid + 1, hi, mid + 1 + (hi - mid - 1) / 2);
        return root;
    }
}
