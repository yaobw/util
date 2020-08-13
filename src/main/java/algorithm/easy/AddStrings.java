package algorithm.easy;

/**
 * @description:
 * @author: yaobw
 * @date: 2020/8/3 5:29 下午
 */
public class AddStrings {

    public static String addStrings(String num1, String num2) {
        StringBuilder s = new StringBuilder();
        int i = num1.length() - 1;
        int j = num2.length() - 1;
        int carry = 0;
        char[] num1Char = num1.toCharArray();
        char[] num2Char = num2.toCharArray();
        while (i >= 0 || j >= 0 || carry != 0) {
            int first = i < 0 ? 0 : num1Char[i--] - '0';
            int second = j < 0 ? 0 : num2Char[j--] - '0';
            int sum = first + second + carry;
            s.append(sum % 10);
            carry = sum / 10;
        }
        return s.reverse().toString();
    }

    public static String addStrings2(String num1, String num2) {
        char[] char1 = num1.toCharArray();
        char[] char2 = num2.toCharArray();
        int point = 0;
        int i = num1.length()-1;
        int j = num2.length()-1;
        StringBuffer sb = new StringBuffer();
        while(i >=0||j>=0||point !=0){
            int first = i<0 ? 0 : char1[i];
            int second = j<0 ? 0 : char2[j];
            i--;
            j--;
            int sum = first + second + point;
            sb.append(sum%10);
            point = sum > 10 ? 1 : 0;
        }
        return sb.reverse().toString();
    }

    public static void main(String[] args) {
        System.out.println(addStrings2("0", "9"));
    }
}
