/*
24. Swap Nodes in Pairs

Given a linked list, swap every two adjacent nodes and return its head.

You may not modify the values in the list's nodes, only nodes itself may be changed.
 
Example:

Given 1->2->3->4, you should return the list as 2->1->4->3.
*/

/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
class Solution {
    public ListNode swapPairs(ListNode head) {
        if (head == null || head.next == null) return head;
        ListNode dum = new ListNode(-1);
        dum.next = head;
        ListNode f = dum;
        ListNode s = dum;
        ListNode temp = dum;
        while (temp.next != null && temp.next.next != null) {
            s = s.next;
            f = f.next.next;
            s.next = s.next.next;
            f.next = s;
            temp.next = f;

            temp = temp.next.next;
            s = temp;
            f = temp;
        }
        return dum.next;
    }
}
