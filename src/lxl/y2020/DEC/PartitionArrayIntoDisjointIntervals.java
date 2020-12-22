package lxl.y2020.DEC;

import java.util.PriorityQueue;

/**
 * @program: leetcode-hz
 * @description: 915. 分割数组
 * 给定一个数组 A，将其划分为两个不相交（没有公共元素）的连续子数组 left 和 right， 使得：
 * <p>
 * left 中的每个元素都小于或等于 right 中的每个元素。
 * left 和 right 都是非空的。
 * left 要尽可能小。
 * <p>
 * 在完成这样的分组后返回 left 的长度。可以保证存在这样的划分方法。
 * <p>
 * <p>
 * <p>
 * 示例 1：
 * <p>
 * 输入：[5,0,3,8,6]
 * 输出：3
 * 解释：left = [5,0,3]，right = [8,6]
 * <p>
 * 示例 2：
 * <p>
 * 输入：[1,1,1,0,6,12]
 * 输出：4
 * 解释：left = [1,1,1,0]，right = [6,12]
 * <p>
 * <p>
 * <p>
 * 提示：
 * <p>
 * 2 <= A.length <= 30000
 * 0 <= A[i] <= 10^6
 * 可以保证至少有一种方法能够按题目所描述的那样对 A 进行划分。
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/partition-array-into-disjoint-intervals
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * @author: lxl
 * @create: 2020-12-22 10:35
 **/
public class PartitionArrayIntoDisjointIntervals {

    public int partitionDisjoint(int[] A) {
        int len = A.length;
        PriorityQueue<Integer> priorityQueue = new PriorityQueue<>(len);
        for (int i = 1; i < len; i++) {
            priorityQueue.add(A[i]);
        }
        int ansLen = 1;
        int max = A[0];
        int temp;
        while (max > priorityQueue.peek()) {
            temp = A[ansLen];
            ansLen++;
            max = Math.max(max, temp);
            priorityQueue.remove(temp);
        }
        return ansLen;
    }

    public int partitionDisjoint2(int[] A) {
        int N = A.length;
        int[] maxleft = new int[N];
        int[] minright = new int[N];

        int m = A[0];
        for (int i = 0; i < N; ++i) {
            m = Math.max(m, A[i]);
            maxleft[i] = m;
        }

        m = A[N - 1];
        for (int i = N - 1; i >= 0; --i) {
            m = Math.min(m, A[i]);
            minright[i] = m;
        }

        for (int i = 1; i < N; ++i)
            if (maxleft[i - 1] <= minright[i])
                return i;

        throw null;
    }
}
