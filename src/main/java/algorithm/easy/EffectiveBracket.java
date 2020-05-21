package algorithm.easy;

import org.apache.commons.lang3.StringUtils;

import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

/**
 * @description:
 * @author: yaobw
 * @date: 2020/5/21 10:41 上午
 */
public class EffectiveBracket {

    public static void main(String[] args) {
        EffectiveBracket bracket = new EffectiveBracket();
        System.out.println(bracket.isValid("()[]{}"));
    }

    private static Map<Character, Character> map = new HashMap<Character, Character>();

    static {
        map.put('}', '{');
        map.put(']', '[');
        map.put(')', '(');
    }


    public boolean isValid(String s) {
        Stack<Character> stack = new Stack<Character>();
        char[] temp = s.toCharArray();
        for(int i = 0; i<temp.length; i++){
            if(map.containsKey(temp[i])){
                char c = map.get(temp[i]);
                char element = stack.empty() ? ' ' : stack.pop();
                if(c != element){
                    return false;
                }
                continue;
            }else {
                stack.push(temp[i]);
            }
        }
        return stack.empty();

    }
}
