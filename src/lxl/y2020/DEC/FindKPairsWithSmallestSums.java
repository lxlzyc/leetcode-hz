package lxl.y2020.DEC;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.PriorityQueue;

/**
 * @program: leetcode-hz
 * @description: 373. 查找和最小的K对数字
 * 给定两个以升序排列的整形数组 nums1 和 nums2, 以及一个整数 k。
 * <p>
 * 定义一对值 (u,v)，其中第一个元素来自 nums1，第二个元素来自 nums2。
 * <p>
 * 找到和最小的 k 对数字 (u1,v1), (u2,v2) ... (uk,vk)。
 * <p>
 * 示例 1:
 * <p>
 * 输入: nums1 = [1,7,11], nums2 = [2,4,6], k = 3
 * 输出: [1,2],[1,4],[1,6]
 * 解释: 返回序列中的前 3 对数：
 * [1,2],[1,4],[1,6],[7,2],[7,4],[11,2],[7,6],[11,4],[11,6]
 * <p>
 * 示例 2:
 * <p>
 * 输入: nums1 = [1,1,2], nums2 = [1,2,3], k = 2
 * 输出: [1,1],[1,1]
 * 解释: 返回序列中的前 2 对数：
 * [1,1],[1,1],[1,2],[2,1],[1,2],[2,2],[1,3],[1,3],[2,3]
 * <p>
 * 示例 3:
 * <p>
 * 输入: nums1 = [1,2], nums2 = [3], k = 3
 * 输出: [1,3],[2,3]
 * 解释: 也可能序列中所有的数对都被返回:[1,3],[2,3]
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/find-k-pairs-with-smallest-sums
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * @author: lxl
 * @create: 2020-12-10 10:42
 **/
public class FindKPairsWithSmallestSums {

    public List<List<Integer>> kSmallestPairs(int[] nums1, int[] nums2, int k) {
        PriorityQueue<List<Integer>> priorityQueue = new PriorityQueue<>(k + 1, new Comparator<List<Integer>>() {
            @Override
            public int compare(List<Integer> o1, List<Integer> o2) {
                return Integer.compare(o2.get(0) + o2.get(1), o1.get(0) + o1.get(1));
            }
        });
        int m = nums1.length;
        int n = nums2.length;
        int sum;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (priorityQueue.size() < k) {
                    List<Integer> index = new ArrayList<>();
                    index.add(nums1[i]);
                    index.add(nums2[j]);
                    priorityQueue.offer(index);
                } else {
                    sum = nums1[i] + nums2[j];
                    List<Integer> pre = priorityQueue.peek();
                    if (pre.get(0) + pre.get(1) > sum) {
                        priorityQueue.poll();
                        List<Integer> index = new ArrayList<>();
                        index.add(nums1[i]);
                        index.add(nums2[j]);
                        priorityQueue.offer(index);
                    } else {
                        break;
                    }
                }
            }
        }
        List<List<Integer>> ans = new ArrayList<>();
        while (!priorityQueue.isEmpty()) {
            ans.add(0, priorityQueue.poll());
        }
        return ans;
    }
}
