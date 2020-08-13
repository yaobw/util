package algorithm.meidum;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.Queue;

/**
 * @description:
 * @author: yaobw
 * @date: 2020/8/10 2:07 下午
 */
public class TopKFrequent {

    public static int[] topKFrequent(int[] nums, int k) {
        Map<Integer, Integer> map = new HashMap<Integer, Integer>();
        int[] result = new int[k];
        for(int i = 0; i < nums.length; i++){
            if(map.containsKey(nums[i])){
                map.put(nums[i], map.get(nums[i]) + 1);
            }else{
                map.put(nums[i], 1);
            }
        }
        Queue<Integer> queue = new PriorityQueue<Integer>((num1, num2) -> map.get(num1) - map.get(num2));
        for(Integer key : map.keySet()){
            int num = map.get(key);
            queue.add(key);
            if(queue.size() > k){
                queue.poll();
            }
        }

        for(int i = 0; i < k; i++){
            result[i] = queue.poll();
        }
        return result;
    }

    public static void main(String[] args) {
        int[] nums = {1,1,1,2,2,3,4,5,6,6,6,6,6};
//        System.out.println(topKFrequent(nums,2));
        System.out.println(topKFrequent2(nums,2));

    }

    public static int[] topKFrequent2(int[] nums, int k) {
        Map<Integer, Integer> map = new HashMap<Integer, Integer>();
        for(int i = 0; i < nums.length; i++){
            if(map.containsKey(nums[i])){
                map.put(nums[i], map.get(nums[i]) + 1);
            }else{
                map.put(nums[i], 1);
            }
        }
        List<Integer>[] list = new List[nums.length + 1];

        for(Integer key : map.keySet()){
            int num = map.get(key);
            if(list[num] == null){
                list[num] = new ArrayList<>();
            }
            list[num].add(key);
        }
        List<Integer> result = new ArrayList<>();
        int[] res= new int[k];
        int point = 0;
        for(int i = list.length -1; i >=0 && result.size() < k; i--){
            if(list[i] == null){
                continue;
            }
            result.addAll(list[i]);
        }
        for(Integer num : result){
            res[point] = num;
            point++;
        }
        return res;
    }
}
