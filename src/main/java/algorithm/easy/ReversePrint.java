package algorithm.easy;

import java.util.Stack;

/**
 * @description:
 * @author: yaobw
 * @date: 2020/8/12 6:01 下午
 */
public class ReversePrint {

    public class ListNode {
     int val;
     ListNode next;
     ListNode(int x) { val = x; }
 }

    public int[] reversePrint(ListNode head) {
        Stack<Integer> stack = new Stack();
        pull(head, stack);
        int[] result = new int[stack.size()];
        int i = 0;
        while(!stack.isEmpty()){
            result[i] = stack.pop();
            i++;
        }
        return result;
    }

    public void pull(ListNode node, Stack<Integer> stack){
        if(node == null){
            return;
        }
        if(node.next != null){
            stack.push(node.val);
            return;
        }
        stack.push(node.val);
        pull(node.next, stack);
    }
}
