package algorithm.easy;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @description:
 * @author: yaobw
 * @date: 2020/8/3 9:20 下午
 */
public class GroupAnagrams {

    public static List<List<String>> groupAnagrams(String[] strs) {
        List<List<String>> result = new ArrayList<List<String>>();
        Map<String, List<String>> map = new HashMap<String, List<String>>();
        for(int i = 0; i < strs.length; i++){
            char[] strArray = strs[i].toCharArray();
            Arrays.sort(strArray);
            String str = new String(strArray);
            if(map.containsKey(str)){
                map.get(str).add(strs[i]);
            } else{
                List<String> list = new ArrayList<String>();
                list.add(strs[i]);
                map.put(str, list);
            }

        }
//        for(String key : map.keySet()){
//            result.add(map.get(key));
//            System.out.println(map.get(key).toString());
//        }
        return new ArrayList(map.values());
    }

    public static void main(String[] args) {
        String[] strs = {"eat","tea","tan","ate","nat","bat"};
        groupAnagrams(strs);
    }
}
