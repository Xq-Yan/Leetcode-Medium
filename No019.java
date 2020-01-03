/*
19. Remove Nth Node From End of List

Given a linked list, remove the n-th node from the end of list and return its head.

Example:

Given linked list: 1->2->3->4->5, and n = 2.

After removing the second node from the end, the linked list becomes 1->2->3->5.
Note:

Given n will always be valid.

Follow up:

Could you do this in one pass?
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
    public ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode res = new ListNode(-1);
        res.next = head;
        ListNode f = res, s = res;
        while (n > 0) {
            f = f.next;
            n--;
        }
        while (f.next != null) {
            f = f.next;
            s = s.next;
        }
        s.next = s.next.next;
        return res.next;
    }
}
