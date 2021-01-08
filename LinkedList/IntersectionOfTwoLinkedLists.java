/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) {
 *         val = x;
 *         next = null;
 *     }
 * }
 */
public class IntersectionOfTwoLinkedLists {
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        if (headA == null || headB == null) return null;
        ListNode ptA = headA;
        ListNode ptB = headB;
        while (ptA != ptB) {
            if(ptA == null) {
                ptA = headB;
            } else {
                ptA = ptA.next;
            }
            if (ptB == null) {
                ptB = headA; 
            } else {
               ptB = ptB.next; 
            } 
            //if ( tailA != null && tailB != null) return null;
            //if (ptA.next == null && ptB.next == null && ptA != ptB) return null;
        }
        return ptA;
    }
}
