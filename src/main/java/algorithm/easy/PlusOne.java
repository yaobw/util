package algorithm.easy;

/**
 * @description:
 * @author: yaobw
 * @date: 2020/7/28 11:47 上午
 */
public class PlusOne {

    public static int[] plusOne(int[] digits) {
        for (int i = digits.length - 1; i >= 0; i--) {
            if (digits[i] == 9) {
                digits[i] = 0;
            } else {
                digits[i] += 1;
                return digits;
            }

        }
        //如果所有位都是进位，则长度+1
        digits= new int[digits.length + 1];
        digits[0] = 1;
        return digits;
    }

    public static void main(String[] args) {
        int[] digits = new int[3];
        digits[0] = 1;
        digits[1] = 9;
        digits[2] = 9;
        plusOne(digits);
    }
}
