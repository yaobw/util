package algorithm;

import org.apache.commons.lang3.StringUtils;

/**
 * @description:
 * @author: yaobw
 * @date: 2020/5/20 4:26 下午
 */
public class IntegerReverse {


//    public static int reverse(int x) {
//        char[] temp = String.valueOf(x).toCharArray();
//        char[] resultChar = new char[temp.length];
//        if(temp[0] == '-'){
//            resultChar[0] = '-';
//        }
//        int length = resultChar[0] == '-' ? temp.length-1 :temp.length;
//        for(int i = 0; i < length; i++){
//            if(resultChar[0] == '-'){
//                resultChar[i+1] = temp[temp.length-1-i];
//            }else {
//                resultChar[i] = temp[temp.length - 1 - i];
//            }
//        }
//
//        int result = 0;
//        try {
//            result = Integer.parseInt(String.valueOf(resultChar));
//        }catch (Exception e){
//            return result;
//        }
//        return result;
//    }

    public static int reverse(int x) {
        int result = 0;
        while (x != 0) {
//            if (result > 214748364 || result < -214748364) {
            if (result > Integer.MAX_VALUE/10 || result < Integer.MIN_VALUE/10 ) {
                return 0;
            }
            result = result * 10 + x % 10 ;
            x = x / 10;
        }

        return result;
    }

//    public static int reverse(int x) {
//        int y = 0;
//        while (x != 0) {
//            // 如果y = y * 10 + x % 10溢出，则 y>=214748364 ，
//            // 当y=214748364时，输入的值只能为：1463847412，此时不溢出
//            // 即：y > 214748364 || y < -214748364 必定溢出
//            if (y > Integer.MAX_VALUE || y < Integer.MIN_VALUE) {
//                return 0;
//            }
//            y = y * 10 + x % 10;
//            x = x / 10;
//        }
//        return y;
//    }

    public static void main(String[] args) {
        int a = 153423649;
        System.out.println(reverse(a));
//        System.out.println(0 % 10);

    }
}
