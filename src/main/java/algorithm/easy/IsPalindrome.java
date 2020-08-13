package algorithm.easy;

import java.util.LinkedHashSet;
import java.util.Stack;

/**
 * @description:
 * @author: yaobw
 * @date: 2020/8/6 5:08 下午
 */
public class IsPalindrome {

    public static boolean isPalindrome(int x) {
        if(x < 0){
            return false;
        }
        int size =  String.valueOf(x).length();
        int half =  size/2;
        char[] nums = String.valueOf(x).toCharArray();
        for(int i = 0 ; i <= half; i++){
            if(nums[i] == nums[size-1-i]){
                continue;
            }
            return false;
        }
        return true;

    }

    public static void main(String[] args) {
        System.out.println(isPalindrome(12121));
    }

    public boolean isPalindrome2(int x) {
        String num = (new StringBuilder(x + "")).reverse().toString();
        if(Integer.valueOf(num) == x){
            return true;
        }
        return false;
    }


    public boolean isPalindrome3(int x) {
        if(x < 0){
            return false;
        }
        int firstNum = 1;
        while(x/firstNum>=10){
            firstNum*=10;
        }
        while(x>0){
            if(x%10 != x/firstNum){
                return false;
            }
            //目的为了消除比较过的第一位和最后一位
            x=x%firstNum/10;
            firstNum/=100;
        }
        return true;
    }

    public boolean isPalindrome4(int x) {
        if(x < 0){
            return false;
        }
        int temp = 0;
        int num = x;
        while (num != 0){
            temp = temp*10 + num%10;
            num/=10;
        }
        return temp == x;
    }

}
