package algorithm.meidum;

import algorithm.easy.PostOrderNode;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Stack;

/**
 * @description:
 * @author: yaobw
 * @date: 2020/8/9 3:51 下午
 */
public class LevelOrder {

    class Node {
        public int val;
        public List<Node> children;

        public Node() {
        }

        public Node(int _val) {
            val = _val;
        }

        public Node(int val, List<Node> children) {
            val = val;
            children = children;
        }
    }

    public List<List<Integer>> levelOrder(Node root) {
        List<List<Integer>> result = new ArrayList<>();
        if(root == null){
            return result;
        }
        Queue<Node> queue = new LinkedList<Node>();
        queue.add(root);
        while(!queue.isEmpty()){
            List<Integer> list = new ArrayList<Integer>();
            int size = queue.size();
            for(int i = 0; i<size; i++){
                Node node = queue.poll();
                list.add(node.val);
                queue.addAll(node.children);
            }
            result.add(list);
        }
        return result;
    }

}
