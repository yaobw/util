package algorithm.easy;

import java.util.Stack;

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



    public static class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }


    public static ListNode getRealNum(ListNode node){
        Stack<Integer> stack = new Stack<Integer>();
        ListNode after = null;
        while (true){
            if(node == null){
                break;
            }
            after = node.next;
            stack.push(node.val);
            if(after == null){
                break;
            }
            node = after;
        }
        int size = stack.size();
        int result = 0;
        for(int i = 0; i<size; i++){
            result = result * 10 + stack.pop();
        }
        char[] c = String.valueOf(result).toCharArray();
        ListNode listNode = null;
        ListNode temp = null;
        for (int i = c.length - 1; i >= 0; i--) {
            final int x = Integer.parseInt(String.valueOf(c[i]));
            if (listNode == null) {
                listNode = new ListNode(x);
                temp = listNode;
            } else {
                temp.next = new ListNode(x);
                temp = temp.next;
            }
        }
        return listNode;


    }

    public static void main(String[] args) {
        ListNode node = new ListNode(2);
        ListNode node2 = new ListNode(4);
        ListNode node3 = new ListNode(3);
        node2.next = node3;
        node.next = node2;
        getRealNum(node);
    }
}
