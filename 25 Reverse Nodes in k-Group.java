/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
public class Solution {
    public ListNode reverseKGroup(ListNode head, int k) {
        if (head == null) return null;
        if (head.next == null || k == 1) return head;
        ListNode fakeHead = new ListNode(0);
        fakeHead.next = head;
        ListNode current = fakeHead;
        while (current.next != null && satisfyKGroup(current, k)) {
            for (int i = k - 1; i > 0; i--) exchListNode(current, i);
            for (int i = 0; i < k; i++) current = current.next;
            if (current == null) break;
        }
        fakeHead = fakeHead.next;
        return fakeHead;
    }
    public boolean satisfyKGroup(ListNode head, int k) {
        ListNode current = head;
        for (int i = 0; i < k - 1; i++) {
            current = current.next;
            if (current.next == null) return false;
        }
        return true;
    }
    public void exchListNode(ListNode ex, int k) {
        ListNode saveNext = ex.next;
        //Attention IndexOufRange
        ex.next = ex.next.next;
        for (int i = 0; i < k; i++) {
            ex = ex.next;
        }
        ListNode tmp = ex.next;
        ex.next = saveNext;
        ex.next.next = tmp;
    }
}