package lxl.y2020.JUN;

import java.util.HashMap;
import java.util.Map;

/**
 * @program: leetcode-hz
 * @description: 677. 键值映射
 * 实现一个 MapSum 类里的两个方法，insert 和 sum。
 * <p>
 * 对于方法 insert，你将得到一对（字符串，整数）的键值对。字符串表示键，整数表示值。如果键已经存在，那么原来的键值对将被替代成新的键值对。
 * <p>
 * 对于方法 sum，你将得到一个表示前缀的字符串，你需要返回所有以该前缀开头的键的值的总和。
 * <p>
 * 示例 1:
 * <p>
 * 输入: insert("apple", 3), 输出: Null
 * 输入: sum("ap"), 输出: 3
 * 输入: insert("app", 2), 输出: Null
 * 输入: sum("ap"), 输出: 5
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/map-sum-pairs
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * @author: lxl
 * @create: 2020-06-03 13:34
 **/
public class MapSumPairs {
    /**
     * Initialize your data structure here.
     */

    private Map<String, Integer> result;
    private Map<String, Integer> keys;

    public MapSumPairs() {
        result = new HashMap<>();
        keys = new HashMap<>();
    }

    public void insert(String key, int val) {
        int keyValue = keys.getOrDefault(key, 0);
        for (int i = 1, l = key.length(); i <= l; i++) {
            String indexkey = key.substring(0, i);
            int count = result.getOrDefault(indexkey, 0);
            result.put(indexkey, count + val - keyValue);
        }
        keys.put(key, val);
    }

    public int sum(String prefix) {
        return result.getOrDefault(prefix, 0);
    }

    public static void main(String[] args) {
        MapSumPairs mapSumPairs = new MapSumPairs();
        mapSumPairs.insert("apple", 3);
        System.out.println(mapSumPairs.sum("ap"));
        mapSumPairs.insert("applf", 4);
        System.out.println(mapSumPairs.sum("ap"));

        mapSumPairs.insert("apple", 4);
        System.out.println(mapSumPairs.sum("ap"));

    }
}
