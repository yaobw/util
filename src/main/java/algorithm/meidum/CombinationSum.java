package algorithm.meidum;

import java.util.ArrayList;
import java.util.List;

/**
 * @description:39 组合总和
 * @author: yaobw
 * @date: 2020/8/17 5:59 下午
 */
public class CombinationSum {

    public static List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> result = new ArrayList();
        recrusion(result,new ArrayList<Integer>(), candidates, target, 0);
        return result;
    }

    private static void recrusion(List<List<Integer>> result, List<Integer> list, int[] candidates, int             target, int start){
        if(target == 0){
            result.add(new ArrayList(list));
            return;
        }
        for(int i = start; i < candidates.length; i++){
            if(candidates[i]>target){
                continue;
            }
            list.add(candidates[i]);
            recrusion(result, list, candidates, target - candidates[i], i);
            list.remove(list.size()-1);
        }
    }

    public static void main(String[] args) {
        int[] candidates = {2,3,6,7};
        System.out.println(combinationSum(candidates, 7));
    }
}
