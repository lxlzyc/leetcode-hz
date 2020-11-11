package lxl.y2020.MAR;

import java.util.Comparator;
import java.util.TreeMap;

/**
 * @program: leetcode-hz
 * @description: 432. 全 O(1) 的数据结构
 * 实现一个数据结构支持以下操作：
 * <p>
 * Inc(key) - 插入一个新的值为 1 的 key。或者使一个存在的 key 增加一，保证 key 不为空字符串。
 * Dec(key) - 如果这个 key 的值是 1，那么把他从数据结构中移除掉。否者使一个存在的 key 值减一。如果这个 key 不存在，这个函数不做任何事情。key 保证不为空字符串。
 * GetMaxKey() - 返回 key 中值最大的任意一个。如果没有元素存在，返回一个空字符串""。
 * GetMinKey() - 返回 key 中值最小的任意一个。如果没有元素存在，返回一个空字符串""。
 * <p>
 * 挑战：以 O(1) 的时间复杂度实现所有操作。
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/all-oone-data-structure
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * @author: lxl
 * @create: 2020-03-24 10:45
 **/
public class AllOoneDataStructure {
    private TreeMap<String, Integer> treeMap;

    public AllOoneDataStructure() {
        treeMap = new TreeMap<>(
                new Comparator<String>() {
                    @Override
                    public int compare(String obj1, String obj2) {
                        return obj2.compareTo(obj1);
                    }
                }
        );
    }

    /**
     * Inserts a new key <Key> with value 1. Or increments an existing key by 1.
     */
    public void inc(String key) {
        treeMap.put(key, treeMap.getOrDefault(key, 0) + 1);
    }

    /**
     * Decrements an existing key by 1. If Key's value is 1, remove it from the data structure.
     */
    public void dec(String key) {
        int count = treeMap.getOrDefault(key, 0);
        if (count > 1) {
            treeMap.put(key, count - 1);
        } else {
            treeMap.remove(key);
        }
    }

    /**
     * Returns one of the keys with maximal value.
     */
    public String getMaxKey() {
        return treeMap.isEmpty() ? "" : treeMap.lastKey();
    }

    /**
     * Returns one of the keys with Minimal value.
     */
    public String getMinKey() {
        return treeMap.isEmpty() ? "" : treeMap.firstKey();
    }

}
