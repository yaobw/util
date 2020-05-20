package algorithm.easy;

/**
 * @description:
 * @author: yaobw
 * @date: 2020/5/20 8:55 上午
 */


public class LinkedListReverse {

    public ListNode reverseList(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        ListNode temp = head.next;
        ListNode newHead = reverseList(head.next);
        temp.next = head;
        head.next = null;
        return newHead;
    }



    public class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }
}
