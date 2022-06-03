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
class Solution {
    public ListNode mergeTwoLists(ListNode list1, ListNode list2) {
        if (list1 == null) return list2;
        if (list2 == null) return list1;
        ListNode pt1 = list1;
        ListNode pt2 = list2;
        ListNode dummy = new ListNode(-1);
        ListNode curr = dummy;
        while (pt1 != null && pt2 != null) {
            if (pt1.val <= pt2.val) {
                
                curr.next = pt1;
                pt1 = pt1.next;
            } else {
                curr.next = pt2;
                pt2 = pt2.next;
            }
            curr = curr.next;
        }
        if (pt1 != null) {
            curr.next = pt1;
        } else if (pt2 != null) {
            curr.next = pt2;
        }
        return dummy.next;
    }
}

// recursive solution

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
class Solution {
    public ListNode mergeTwoLists(ListNode list1, ListNode list2) {
        if (list1 == null) return list2;
        if (list2 == null) return list1;

        if (list1.val > list2.val) {
           ListNode next = mergeTwoLists(list1, list2.next);
            list2.next = next;
            return list2;
        } else {
            ListNode next = mergeTwoLists(list1.next, list2);
            list1.next = next;
            return list1;
        }
        
    }
}
