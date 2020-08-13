package algorithm.easy;

import java.util.ArrayList;
import java.util.List;

/**
 * @description:
 * @author: yaobw
 * @date: 2020/8/7 11:34 上午
 */
public class IsSameTree {

    public static class TreeNode {
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


//    public static boolean isSameTree(TreeNode p, TreeNode q) {
//        List<Integer> listP = new ArrayList<Integer>();
//        List<Integer> listQ = new ArrayList<Integer>();
//        traversal(p, listP);
//        traversal(q, listQ);
//        return listQ.equals(listP);
//    }
//
//    public static void traversal(TreeNode node, List<Integer> list) {
//        if (node != null) {
//            if (node.left != null) {
//                traversal(node.left, list);
//            }
//            list.add(node.val);
//            if (node.right != null) {
//                traversal(node.right, list);
//            }
//        }
//    }

    public static boolean isSameTree(TreeNode p, TreeNode q) {
        if(p == q){
            return true;
        }
        if(p ==null ||  q==null){
            return false;
        }
        if(!isSameTree(p.left,  q.left)){
            return false;
        }
        if(p.val != q.val){
            return false;
        }
        if(!isSameTree(p.right, q.right)){
            return false;
        }
        return true;
    }

    public static void main(String[] args) {
        TreeNode firstLeft = new TreeNode(1);
        TreeNode first = new TreeNode(1, firstLeft, null);
        TreeNode secondRight = new TreeNode(1);
        TreeNode second = new TreeNode(1, null, secondRight);
        System.out.println(isSameTree(first, second));


    }

}
