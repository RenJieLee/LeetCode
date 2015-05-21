/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
public class Solution {
    public ListNode removeNthFromEnd(ListNode head, int n) {
        int total = 1;
        ListNode current = head;
        while (current.next != null) {
            total++;
            current = current.next;
        }
        int index = total - n;
        if (index == 0) {
            head = head.next;
            return head;
        }
        current = head;
        while (current.next != null) {
            if (index == 1) {
                current.next = current.next.next;
                break;
            }
            index--;
            current = current.next;
        }
        return head;
    }
}