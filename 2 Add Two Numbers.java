/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
public class Solution {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        int tmp = 0;
        ListNode fakeHead = new ListNode(0);
        ListNode current = fakeHead;
        while (l1 != null && l2 != null) {
            current.next = new ListNode((l1.val + l2.val + tmp) % 10);
            tmp = (l1.val + l2.val + tmp) / 10;
            current = current.next;
            l1 = l1.next;
            l2 = l2.next;
        }
        while (l1 != null) {
            current.next = new ListNode((l1.val + tmp) % 10);
            tmp = (l1.val + tmp) / 10;
            current = current.next;
            l1 = l1.next;
        }
        while (l2 != null) {
            current.next = new ListNode((l2.val + tmp) % 10);
            tmp = (l2.val + tmp) / 10;
            current = current.next;
            l2 = l2.next;
        }
        if (tmp != 0) current.next = new ListNode(tmp);
        return fakeHead.next;
    }
    
}