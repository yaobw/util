package algorithm.meidum;

import java.util.HashMap;
import java.util.Map;

/**
 * @description:
 * @author: yaobw
 * @date: 2020/8/13 10:55 上午
 */
public class BuildTreeByPreIn {

    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    public TreeNode buildTree(int[] preorder, int[] inorder) {
        return buildTreeHelper(preorder, 0, preorder.length, inorder, 0, inorder.length);
    }

    private TreeNode buildTreeHelper(int[] preorder, int p_start, int p_end, int[] inorder, int i_start, int i_end) {
        // preorder 为空，直接返回 null
        if (p_start == p_end) {
            return null;
        }
        int root_val = preorder[p_start];
        TreeNode root = new TreeNode(root_val);
        //在中序遍历中找到根节点的位置
        int i_root_index = 0;
        for (int i = i_start; i < i_end; i++) {
            if (root_val == inorder[i]) {
                i_root_index = i;
                break;
            }
        }
        int leftNum = i_root_index - i_start;
        //递归的构造左子树
        root.left = buildTreeHelper(preorder, p_start + 1, p_start + leftNum + 1, inorder, i_start, i_root_index);
        //递归的构造右子树
        root.right = buildTreeHelper(preorder, p_start + leftNum + 1, p_end, inorder, i_root_index + 1, i_end);
        return root;
    }

    public TreeNode buildTree2(int[] preorder, int[] inorder) {
        if(preorder == null || inorder == null){
            return null;
        }
        Map<Integer, Integer> map = new HashMap<Integer, Integer>(preorder.length);
        for(int i = 0; i < inorder.length; i++){
            map.put(inorder[i],i);
        }
        return build(preorder, 0, preorder.length-1, map, 0, inorder.length-1);
    }

    private TreeNode build(int[] preorder, int preIndex, int preLast, Map<Integer, Integer> map,
                           int inIndex, int inLast){
        if(preIndex > preLast || inIndex > inLast){
            return null;
        }
        int rootVlaue = preorder[preIndex];
        int pIndex = map.get(rootVlaue);

        TreeNode root = new TreeNode(rootVlaue);
        root.left = build(preorder, preIndex + 1, pIndex-inIndex+preIndex, map, inIndex, pIndex-1);
        root.right = build(preorder, pIndex-inIndex + preIndex +1, preLast, map, pIndex + 1, inLast);
        return root;
    }

}
