package algorithm.meidum;

import java.util.Collections;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.PriorityQueue;

/**
 * @description:
 * @author: yaobw
 * @date: 2020/8/27 7:58 下午
 */
public class FindItinerary {

    Map<String, PriorityQueue<String>> map = new HashMap<>();

    List<String> result = new LinkedList<>();

    public List<String> findItinerary(List<List<String>> tickets){
        for(List<String> ticket : tickets){
            String starting = ticket.get(0);
            String aiming = ticket.get(1);
            if(!map.containsKey(starting)){
                map.put(starting, new PriorityQueue<>());
            }
            map.get(starting).offer(aiming);
        }
        dfs("JFK");
        Collections.reverse(result);
        return result;
    }

    private void dfs(String destination){
        while(map.containsKey(destination) && map.get(destination).size() > 0){
            String address = map.get(destination).poll();
            dfs(address);
        }
        result.add(destination);
    }
}
