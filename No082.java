/*
82. Remove Duplicates from Sorted List II

Given a sorted linked list, delete all nodes that have duplicate numbers, leaving only distinct numbers from the original list.

Return the linked list sorted as well.

Example 1:

Input: 1->2->3->3->4->4->5
Output: 1->2->5
Example 2:

Input: 1->1->1->2->3
Output: 2->3
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
    public ListNode deleteDuplicates(ListNode head) {
        if (head == null || head.next == null) return head;
        ListNode res = new ListNode(-1);
        res.next = head;
        ListNode l = res;
        ListNode r = head;
        while (r != null && r.next != null) {
            if (l.next.val != r.next.val) {
                l = l.next;
                r = r.next;
            } else {
                while (r != null && r.next != null && l.next.val == r.next.val) r = r.next;
                l.next = r.next;
                r = r.next;
            }
        }
        return res.next;
    }
}
