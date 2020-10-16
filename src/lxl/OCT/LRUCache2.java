package lxl.OCT;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;

/**
 * @program: leetcode-hz
 * @description: 146. LRU缓存机制
 * @author: lxl
 * @create: 2020-10-16 10:37
 **/
public class LRUCache2 {

    private int capacity;
    private Map<Integer, Integer> offsets;
    private LinkedList<Integer> keys;

    public LRUCache2(int capacity) {
        this.capacity = capacity;
        offsets = new HashMap<>(capacity);
        keys = new LinkedList<>();
    }

    public int get(int key) {
        if (offsets.containsKey(key)) {
            keys.remove(Integer.valueOf(key));
            keys.addFirst(key);
            return offsets.get(key);
        }
        return -1;
    }

    public void put(int key, int value) {
        if (offsets.containsKey(key)) {
            keys.remove(Integer.valueOf(key));
        }
        offsets.put(key, value);
        keys.addFirst(key);
        if (keys.size() > capacity) {
            Integer last = keys.removeLast();
            offsets.remove(last);
        }
    }

    public static void main(String[] args) {
        LRUCache2 lruCache = new LRUCache2(2);
        lruCache.put(1, 1);
        lruCache.put(2, 2);
        System.out.println(lruCache.get(1));
        lruCache.put(3, 3);
        System.out.println(lruCache.get(2));
        lruCache.put(4, 4);
        System.out.println(lruCache.get(1));
        System.out.println(lruCache.get(3));
        System.out.println(lruCache.get(4));
    }
}
