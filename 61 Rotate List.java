/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
public class Solution {
    public ListNode rotateRight(ListNode head, int k) {
        if (head == null || head.next == null) return head;
        ListNode current = head;
        int count = 0;
        while (current != null) {
            count++;
            current = current.next;
        }
        current = head;
        int changeIndex = k % count;
        if (changeIndex == 0) return head;
        for (int i = 0; i < count - changeIndex - 1; i++) current = current.next;
        ListNode newHead = current.next;
        current.next = null;
        current = newHead;
        while (current.next != null) current = current.next;
        current.next = head;
        return newHead;
    }
}