package lxl.y2021.JAN;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.PriorityQueue;

/**
 * @author lxl
 * @program leetcode-hz
 * @description: 1202. 交换字符串中的元素
 * 给你一个字符串 s，以及该字符串中的一些「索引对」数组 pairs，其中 pairs[i] = [a, b] 表示字符串中的两个索引（编号从 0 开始）。
 * <p>
 * 你可以 任意多次交换 在 pairs 中任意一对索引处的字符。
 * <p>
 * 返回在经过若干次交换后，s 可以变成的按字典序最小的字符串。
 * <p>
 * <p>
 * <p>
 * 示例 1:
 * <p>
 * 输入：s = "dcab", pairs = [[0,3],[1,2]]
 * 输出："bacd"
 * 解释：
 * 交换 s[0] 和 s[3], s = "bcad"
 * 交换 s[1] 和 s[2], s = "bacd"
 * <p>
 * 示例 2：
 * <p>
 * 输入：s = "dcab", pairs = [[0,3],[1,2],[0,2]]
 * 输出："abcd"
 * 解释：
 * 交换 s[0] 和 s[3], s = "bcad"
 * 交换 s[0] 和 s[2], s = "acbd"
 * 交换 s[1] 和 s[2], s = "abcd"
 * <p>
 * 示例 3：
 * <p>
 * 输入：s = "cba", pairs = [[0,1],[1,2]]
 * 输出："abc"
 * 解释：
 * 交换 s[0] 和 s[1], s = "bca"
 * 交换 s[1] 和 s[2], s = "bac"
 * 交换 s[0] 和 s[1], s = "abc"
 * <p>
 * <p>
 * <p>
 * 提示：
 * <p>
 * 1 <= s.length <= 10^5
 * 0 <= pairs.length <= 10^5
 * 0 <= pairs[i][0], pairs[i][1] < s.length
 * s 中只含有小写英文字母
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/smallest-string-with-swaps
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * @date 2021/1/11 9:42
 * @Version 1.0
 */
public class SmallestStringWithSwaps {
    public String smallestStringWithSwaps(String s, List<List<Integer>> pairs) {
        int len = s.length();
        UnionFound unionFound = new UnionFound(len);
        //构建并查集
        for (List<Integer> item : pairs) {
            unionFound.unionElements(item.get(0), item.get(1));
        }
        int[] unions = unionFound.unions;
        //key-offset,value统一分组的优先级队列
        Map<Integer, PriorityQueue<Character>> priorityQueueMap = new HashMap<>();
        for (int i = 0; i < len; i++) {
            PriorityQueue<Character> characters = priorityQueueMap.getOrDefault(unionFound.find(i), new PriorityQueue<>());
            characters.offer(s.charAt(i));
            priorityQueueMap.put(unionFound.find(i), characters);
        }
        StringBuilder stringBuilder = new StringBuilder();
        for (int i = 0; i < len; i++) {
            stringBuilder.append(priorityQueueMap.get(unionFound.find(i)).poll());
        }
        return stringBuilder.toString();
    }

    class UnionFound {
        private int[] unions;
        private int size;
        /**
         * 以 i 为根结点的子树的高度（引入了路径压缩以后该定义并不准确）
         */
        private int[] rank;

        UnionFound(int size) {
            this.size = size;
            unions = new int[size];
            this.rank = new int[size];
            for (int i = 0; i < size; i++) {
                unions[i] = i;
                rank[i] = i;
            }
        }

        //查看元素属于哪个集合
        public int find(int offset) {
            if (offset != unions[offset]) {
                unions[offset] = find(unions[offset]);
            }
            return unions[offset];

        }

        //查看俩元素属于同一个集合
        public boolean isConnected(int firstElement, int secondElement) {
            return find(firstElement) == find(secondElement);
        }

        public void unionElements(int x, int y) {
            int rootX = find(x);
            int rootY = find(y);
            if (rootX == rootY) {
                return;
            }

            if (rank[rootX] == rank[rootY]) {
                unions[rootX] = rootY;
                // 此时以 rootY 为根结点的树的高度仅加了 1
                rank[rootY]++;
            } else if (rank[rootX] < rank[rootY]) {
                unions[rootX] = rootY;
                // 此时以 rootY 为根结点的树的高度不变
            } else {
                // 同理，此时以 rootX 为根结点的树的高度不变
                unions[rootY] = rootX;
            }
        }

    }
}