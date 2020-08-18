package algorithm.meidum;

/**
 * @description:有序链表转换二叉搜索树
 * @author: yaobw
 * @date: 2020/8/18 5:15 下午
 */
public class SortedListToBST {

    public class ListNode {
        int val;
        ListNode next;

        ListNode() {
        }

        ListNode(int val) {
            this.val = val;
        }

        ListNode(int val, ListNode next) {
            this.val = val;
            this.next = next;
        }
    }

    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode() {
        }

        TreeNode(int val) {
            this.val = val;
        }

        TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }

    public TreeNode sortedListToBST(ListNode head) {
        if (head == null) {
            return new TreeNode();
        }
        if (head.next == null) {
            return new TreeNode(head.val);
        }
        return buildBst(head, null);
    }

    private TreeNode buildBst(ListNode head, ListNode last) {
        if (head == last) {
            return null;
        }
        ListNode slow = head, fast = slow;
        while (fast != last && fast.next != last) {
            slow = slow.next;
            fast = fast.next.next;
        }
        TreeNode result = new TreeNode(slow.val);
        result.left = buildBst(head, slow);
        result.right = buildBst(slow.next, last);
        return result;
    }

}
