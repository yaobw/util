package algorithm.meidum;

import com.google.common.collect.Lists;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @description:
 * @author: yaobw
 * @date: 2020/8/26 2:24 下午
 */
public class LetterCombinations {

    private static Map<Character, String> map = null;

    static {
        map = new HashMap<>();
        map.put('2', "abc");
        map.put('3', "def");
        map.put('4', "ghi");
        map.put('5', "jkl");
        map.put('6', "mno");
        map.put('7', "pqrs");
        map.put('8', "tuv");
        map.put('9', "wxyz");
    }

    public static List<String> letterCombinations(String digits) {
        List<String> result = new ArrayList<String>();
        if (digits == null || digits == "") {
            return result;
        }
        digits = digits.replace("1", "");
        bfs(result, digits, 0, new StringBuffer());
        return result;
    }

    private static void bfs(List<String> list, String digits, int index, StringBuffer result) {
        if (index == digits.length()) {
            list.add(result.toString());
        } else {
            char num = digits.charAt(index);
            String code = map.get(num);
            for (int i = 0; i < code.length(); i++) {
                result.append(code.charAt(i));
                bfs(list, digits, index + 1, result);
                result.deleteCharAt(index);
            }
        }
    }

    public static void main(String[] args) {
        System.out.println(letterCombinations(""));
    }

}
