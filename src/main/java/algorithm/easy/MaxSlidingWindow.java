package algorithm.easy;

import java.util.Arrays;

/**
 * @description:
 * @author: yaobw
 * @date: 2020/8/5 4:30 下午
 */
public class MaxSlidingWindow {

    public int[] maxSlidingWindow(int[] nums, int k) {
        if (nums.length == 0) {
            return new int[]{};
        }
        int len = nums.length + 1 - k;
            int[] res = new int[len];
            for (int i = 0; i < len; i++) {
                res[i] = Arrays.stream(nums, i, i + k).max().getAsInt();
        }
        return res;
    }
}
