package algorithm.easy;

/**
 * @description:
 * @author: yaobw
 * @date: 2020/7/28 3:53 下午
 */
public class RemoveDuplicates {

    public static int removeDuplicates(int[] nums) {
        if(nums.length == 0) return 0;
        int result = 0;
        int pointer = 0;
        for (int i = 1; i < nums.length; i++) {

            if (nums[i] != nums[pointer]) {
                pointer++;
                nums[pointer] = nums[i];
                result++;
            }

        }
        return result + 1;
    }


    public int removeDuplicates1(int[] nums) {
        if (nums.length == 0) {
            return 0;
        }
        int i = 0;
        for (int j = 1; j < nums.length; j++) {
            if (nums[j] != nums[i]) {
                i++;
                nums[i] = nums[j];
            }
        }
        return i + 1;
    }

    public static void main(String[] args) {
        int[] nums = {1, 1, 2, 2, 2, 3, 3, 4, 5};
        System.out.println(removeDuplicates(nums));
    }
}
