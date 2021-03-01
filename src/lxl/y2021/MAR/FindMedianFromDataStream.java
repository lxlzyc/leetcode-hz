package lxl.y2021.MAR;

import java.util.Comparator;
import java.util.PriorityQueue;

/**
 * @author lxl
 * @program leetcode-hz
 * @description: 295. 数据流的中位数
 * 中位数是有序列表中间的数。如果列表长度是偶数，中位数则是中间两个数的平均值。
 * <p>
 * 例如，
 * <p>
 * [2,3,4] 的中位数是 3
 * <p>
 * [2,3] 的中位数是 (2 + 3) / 2 = 2.5
 * <p>
 * 设计一个支持以下两种操作的数据结构：
 * <p>
 * void addNum(int num) - 从数据流中添加一个整数到数据结构中。
 * double findMedian() - 返回目前所有元素的中位数。
 * <p>
 * 示例：
 * <p>
 * addNum(1)
 * addNum(2)
 * findMedian() -> 1.5
 * addNum(3)
 * findMedian() -> 2
 * <p>
 * 进阶:
 * <p>
 * 如果数据流中所有整数都在 0 到 100 范围内，你将如何优化你的算法？
 * 如果数据流中 99% 的整数都在 0 到 100 范围内，你将如何优化你的算法？
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/find-median-from-data-stream
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * @date 2021/3/1 10:04
 * @Version 1.0
 */
public class FindMedianFromDataStream {
    /**
     * initialize your data structure here.
     */
    private PriorityQueue<Integer> small;
    private PriorityQueue<Integer> big;

    public FindMedianFromDataStream() {
        small = new PriorityQueue<>(new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return Integer.compare(o2, o1);
            }
        });
        big = new PriorityQueue<>();
    }

    public void addNum(int num) {
        if (big.isEmpty() || num >= big.peek()) {
            big.offer(num);
        } else {
            small.offer(num);
        }
        while (small.size() > big.size()) {
            big.offer(small.poll());
        }
        while (big.size() > small.size() + 1) {
            small.offer(big.poll());
        }
    }

    public double findMedian() {
        if (big.size() == small.size()) {
            return ((double) big.peek() + (double) small.peek()) / 2D;
        } else {
            return big.peek();
        }
    }
}