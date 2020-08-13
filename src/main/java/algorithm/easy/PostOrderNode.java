package algorithm.easy;

import java.util.ArrayList;
import java.util.List;

/**
 * @description:
 * @author: yaobw
 * @date: 2020/8/6 8:13 下午
 */
public class PostOrderNode {
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

    public List<Integer> postorder(Node root) {
        List<Integer> list = new ArrayList<Integer>();
        traversal(root, list);
        return list;
    }

    public void traversal(Node node, List<Integer> list){
        if(node == null){
            return;
        }
        for(int i = 0; i < node.children.size(); i++){
            if(node.children.get(i) != null) {
                traversal(node.children.get(i), list);
            }
        }
        list.add(node.val);
    }
}
