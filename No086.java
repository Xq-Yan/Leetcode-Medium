/*
86. Partition List

Given a linked list and a value x, partition it such that all nodes less than x come before nodes greater than or equal to x.

You should preserve the original relative order of the nodes in each of the two partitions.

Example:

Input: head = 1->4->3->2->5->2, x = 3
Output: 1->2->2->4->3->5
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
    public ListNode partition(ListNode head, int x) {
        if (head == null || head.next == null) return head;
        ListNode list1 = new ListNode(0);
        ListNode list2 = new ListNode(0);
        ListNode l1 = list1;
        ListNode l2 = list2;
        while (head != null) {
            if (head.val < x) {
                l1.next = head;
                head = head.next;
                l1 = l1.next;
                l1.next = null;
            } else {
                l2.next = head;
                head = head.next;
                l2 = l2.next;
                l2.next = null;
            }
        }
        l1.next = list2.next;
        return list1.next;
    }
}
