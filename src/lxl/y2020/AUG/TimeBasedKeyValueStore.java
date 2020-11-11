package lxl.y2020.AUG;

import lxl.util.JSONUtil;

import java.util.*;

/**
 * @program: leetcode-hz
 * @description: 981. 基于时间的键值存储
 * 创建一个基于时间的键值存储类 TimeMap，它支持下面两个操作：
 * <p>
 * 1. set(string key, string value, int timestamp)
 * <p>
 * 存储键 key、值 value，以及给定的时间戳 timestamp。
 * <p>
 * 2. get(string key, int timestamp)
 * <p>
 * 返回先前调用 set(key, value, timestamp_prev) 所存储的值，其中 timestamp_prev <= timestamp。
 * 如果有多个这样的值，则返回对应最大的  timestamp_prev 的那个值。
 * 如果没有值，则返回空字符串（""）。
 * <p>
 * <p>
 * <p>
 * 示例 1：
 * <p>
 * 输入：inputs = ["TimeMap","set","get","get","set","get","get"], inputs = [[],["foo","bar",1],["foo",1],["foo",3],["foo","bar2",4],["foo",4],["foo",5]]
 * 输出：[null,null,"bar","bar",null,"bar2","bar2"]
 * 解释：
 * TimeMap kv;
 * kv.set("foo", "bar", 1); // 存储键 "foo" 和值 "bar" 以及时间戳 timestamp = 1
 * kv.get("foo", 1);  // 输出 "bar"
 * kv.get("foo", 3); // 输出 "bar" 因为在时间戳 3 和时间戳 2 处没有对应 "foo" 的值，所以唯一的值位于时间戳 1 处（即 "bar"）
 * kv.set("foo", "bar2", 4);
 * kv.get("foo", 4); // 输出 "bar2"
 * kv.get("foo", 5); // 输出 "bar2"
 * <p>
 * 示例 2：
 * <p>
 * 输入：inputs = ["TimeMap","set","set","get","get","get","get","get"], inputs = [[],["love","high",10],["love","low",20],["love",5],["love",10],["love",15],["love",20],["love",25]]
 * 输出：[null,null,null,"","high","high","low","low"]
 * <p>
 * <p>
 * <p>
 * 提示：
 * <p>
 * 所有的键/值字符串都是小写的。
 * 所有的键/值字符串长度都在 [1, 100] 范围内。
 * 所有 TimeMap.set 操作中的时间戳 timestamps 都是严格递增的。
 * 1 <= timestamp <= 10^7
 * TimeMap.set 和 TimeMap.get 函数在每个测试用例中将（组合）调用总计 120000 次。
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/time-based-key-value-store
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * @author: lxl
 * @create: 2020-08-19 14:52
 **/
public class TimeBasedKeyValueStore {

    /**
     * Initialize your data structure here.
     */
    private Map<String, ArrayList<Node>> times;

    public TimeBasedKeyValueStore() {
        times = new HashMap<>();
    }

    public void set(String key, String value, int timestamp) {
        if (!times.containsKey(key)) {
            ArrayList<Node> timeList = new ArrayList<>();
            timeList.add(new Node(timestamp, value));
            times.put(key, timeList);
            return;
        }
        times.get(key).add(new Node(timestamp, value));
    }


    public String get(String key, int timestamp) {
        if (!times.containsKey(key)) {
            return "";
        }
        ArrayList<Node> timeList = times.get(key);
        int offset = Collections.binarySearch(timeList, new Node(timestamp, "{"), new Comparator<Node>() {
            @Override
            public int compare(Node o1, Node o2) {
                return Integer.compare(o1.timestamp, o2.timestamp);
            }
        });
        if (offset >= 0) {
            return timeList.get(offset).value;
        } else if (offset == -1) {
            return "";
        } else {
            return timeList.get(-offset - 2).value;
        }
    }

    static class Node {
        int timestamp;
        String value;

        public Node(int timestamp, String value) {
            this.timestamp = timestamp;
            this.value = value;
        }
    }


    public static void main(String[] args) {
        TimeBasedKeyValueStore time = new TimeBasedKeyValueStore();
        //["TimeMap","set","get","get","set","get","get"], inputs = [[],["foo","bar",1],["foo",1],["foo",3],["foo","bar2",4],["foo",4],["foo",5]]
        time.set("foo", "bar", 1);
        System.out.println(time.get("foo", 1));
        System.out.println(time.get("foo", 3));
        time.set("foo", "bar2", 4);
        System.out.println(time.get("foo", 4));
        System.out.println(time.get("foo", 5));
        System.out.println(time.get("foo", 3));
        System.out.println(time.get("foo", 2));


        List<Integer> list = new ArrayList<>();
        list.add(1);
        list.add(3);
        list.add(4);
        list.add(5);
        list.add(6);
        list.add(8);
        list.add(10);
        list.add(12);
        System.out.println(JSONUtil.toJson(list));
        System.out.println(Collections.binarySearch(list, 0));
        System.out.println(Collections.binarySearch(list, 1));
        System.out.println(Collections.binarySearch(list, 2));
        System.out.println(Collections.binarySearch(list, 3));
        System.out.println(Collections.binarySearch(list, 13));


    }

}
