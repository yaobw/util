package algorithm.easy;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * @description:
 * @author: yaobw
 * @date: 2020/8/3 8:36 下午
 */
public class IsAnagram {

    public static boolean isAnagram(String s, String t) {
        if (s.length() != t.length()) {
            return false;
        }
        char[] s1 = s.toCharArray();
        char[] t1 = t.toCharArray();
        Arrays.sort(s1);
        Arrays.sort(t1);
        return Arrays.equals(s1, t1);
    }

    public static boolean isAnagram2(String s, String t) {
        if (s.length() != t.length()) {
            return false;
        }
        char[] s1 = s.toCharArray();
        Map<Character , Integer> map =new HashMap<Character, Integer>();
        for(int i = 0; i < s1.length; i++){
            if(map.containsKey(s1[i])){
                map.put(s1[i], map.get(s1[i]) + 1);
            }else {
                map.put(s1[i], 1);
            }
        }
        char[] t1 = t.toCharArray();
        for(int i = 0; i < t1.length; i++){
            if(map.containsKey(t1[i])){
                map.put(t1[i], map.get(t1[i]) - 1);
            } else {
                return false;
            }
            if(i == t1.length -1){
                for(Integer num : map.values()){
                    if (num != 0){
                        return false;
                    }
                }
            }
        }
        return true;
    }

    public static void main(String[] args) {
        System.out.println(isAnagram2("aacc", "ccac"));

    }
}
