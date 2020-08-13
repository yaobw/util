package algorithm.design;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.LinkedList;

/**
 * @description:
 * @author: yaobw
 * @date: 2020/8/4 1:59 下午
 */
public class LRUCache {

    private LinkedHashMap<Integer, Integer> cache = null;

    private Integer size;


    public LRUCache(int capacity) {
        cache = new LinkedHashMap<Integer, Integer>(capacity);
        this.size = capacity;
    }

    public int get(int key) {
        if (size == 0) {
            return -1;
        }
        if (cache.containsKey(key)) {
            int result = cache.get(key);
            cache.remove(key);
            cache.put(key, result);
            return result;
        }
        return -1;
    }

    public void put(int key, int value) {
        if (cache.containsKey(key)) {
            cache.remove(key);
            cache.put(key, value);
            return;
        }
        if (cache.values().size() >= size) {
            cache.remove(cache.entrySet().iterator().next().getKey());
        }
        cache.put(key, value);
    }
}
