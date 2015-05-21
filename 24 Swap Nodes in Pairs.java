/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
public class Solution {
    public ListNode swapPairs(ListNode head) {
        if (head == null) return null;
        if (head.next == null) return head;
        ListNode fakeHead = new ListNode(0);
        fakeHead.next = head;
        ListNode current = fakeHead;
        while (current.next != null && current.next.next != null) {
            exchListNode(current, 1);
            current = current.next.next;
            if (current == null) break;
        }
        fakeHead = fakeHead.next;
        return fakeHead;
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