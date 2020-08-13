package algorithm.easy;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @description:
 * @author: yaobw
 * @date: 2020/8/3 3:41 下午
 */
public class Intersect {

    public static int[] intersect(int[] nums1, int[] nums2) {
        if(nums1 == null || nums2 == null){
            return new int[0];
        }
        int size = nums1.length > nums2.length ? nums1.length : nums2.length;
        int[] result = new int[size];
        Map<Integer, Integer> map = new HashMap<Integer, Integer>();
        for(int i = 0; i < nums1.length; i++){
            if(map.containsKey(nums1[i])){
                map.put(nums1[i], map.get(nums1[i]) + 1);
            } else {
                map.put(nums1[i], 1);
            }
        }
        int point = 0;
        for(int i = 0; i < nums2.length; i++){
            if(map.containsKey(nums2[i])){
                if(map.get(nums2[i]) > 0){
                    result[point] = nums2[i];
                    point++;
                    map.put(nums2[i], map.get(nums2[i]) - 1);
                }
            }
        }
        return Arrays.copyOfRange(result, 0, point);
    }

    public static void main(String[] args) {
        int[] nums1 = {1,2,2,1};
        int[] nums2 = {2,2};
        int[] a = intersect(nums1, nums2);
        for (Integer num : a) {
            System.out.println(num);
        }

    }
}
