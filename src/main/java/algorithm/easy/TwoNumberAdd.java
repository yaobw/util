package algorithm.easy;

import java.util.HashMap;
import java.util.Map;

/**
 * @description:
 * @author: yaobw
 * @date: 2020/5/21 6:09 下午
 */
public class TwoNumberAdd {

    /**
     * 给定 nums = [2, 7, 11, 15], target = 9
     *
     * 因为 nums[0] + nums[1] = 2 + 7 = 9
     * 所以返回 [0, 1]
     *
     * @param nums
     * @param target
     * @return
     * @throws Exception
     */
    public int[] twoSum(int[] nums, int target) throws Exception{
        Map<Integer, Integer> map = new HashMap<Integer, Integer>();
        for(int i = 0; i<nums.length; i++){
            int temp = target - nums[i];
            if(map.containsKey(temp)){
                return new int[]{i, map.get(temp)};
            }
            map.put(nums[i], i);
        }
        throw new Exception("no such two numbers in the array");
    }
}
