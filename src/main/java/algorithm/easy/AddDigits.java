package algorithm.easy;

/**
 * @description:
 * @author: yaobw
 * @date: 2020/8/8 9:53 上午
 */
public class AddDigits {

    public int addDigits(int num) {
        int result = 0;
        char[] nums = Integer.toString(num).toCharArray();
        for (int i = 0; i < nums.length; i++) {
            result += (nums[i] - 48);
        }
        if (result > 10) {
            addDigits(result);
        }
        return result;
    }
}
