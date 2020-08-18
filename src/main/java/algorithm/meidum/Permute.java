package algorithm.meidum;

import java.util.LinkedList;
import java.util.List;

/**
 * @description:46全排列
 * @author: yaobw
 * @date: 2020/8/17 10:15 上午
 */
public class Permute {

    List<List<Integer>> ans = new LinkedList<>();   // 结果answer
    public List<List<Integer>> permute(int[] nums) {
        LinkedList<Integer> path = new LinkedList<>();  // 路径
        backtrack(nums, path);
        return ans;
    }

    public void backtrack(int[] nums, LinkedList<Integer> path) {
        // 结束条件
        if (path.size() == nums.length) {
            ans.add(new LinkedList(path));
            return;
        }

        for (int i = 0; i < nums.length; i++) {
            if (path.contains(nums[i])) {   // 这个数被选过了
                continue;   // 跳过
            }
            path.add(nums[i]);  // 当前位做选择
            backtrack(nums, path);  // 继续对下一位选择
            // 下一位无法选择递归返回了且没满足结束条件
            // 说明当前位的选择导致了下一位无论怎么选都不能到达结束条件
            // 所以当前位的选择是错误的，撤销当前位选择
            path.removeLast();
        }
    }

}
