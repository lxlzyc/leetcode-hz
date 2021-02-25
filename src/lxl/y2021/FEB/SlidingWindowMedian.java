package lxl.y2021.FEB;

import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;

/**
 * @author lxl
 * @program leetcode-hz
 * @description: 480. 滑动窗口中位数
 * 中位数是有序序列最中间的那个数。如果序列的长度是偶数，则没有最中间的数；此时中位数是最中间的两个数的平均数。
 * <p>
 * 例如：
 * <p>
 * [2,3,4]，中位数是 3
 * [2,3]，中位数是 (2 + 3) / 2 = 2.5
 * <p>
 * 给你一个数组 nums，有一个长度为 k 的窗口从最左端滑动到最右端。窗口中有 k 个数，每次窗口向右移动 1 位。你的任务是找出每次窗口移动后得到的新窗口中元素的中位数，并输出由它们组成的数组。
 * <p>
 * <p>
 * <p>
 * 示例：
 * <p>
 * 给出 nums = [1,3,-1,-3,5,3,6,7]，以及 k = 3。
 * <p>
 * 窗口位置                      中位数
 * ---------------               -----
 * [1  3  -1] -3  5  3  6  7       1
 * 1 [3  -1  -3] 5  3  6  7      -1
 * 1  3 [-1  -3  5] 3  6  7      -1
 * 1  3  -1 [-3  5  3] 6  7       3
 * 1  3  -1  -3 [5  3  6] 7       5
 * 1  3  -1  -3  5 [3  6  7]      6
 * <p>
 * 因此，返回该滑动窗口的中位数数组 [1,-1,-1,3,5,6]。
 * <p>
 * <p>
 * <p>
 * 提示：
 * <p>
 * 你可以假设 k 始终有效，即：k 始终小于等于输入的非空数组的元素个数。
 * 与真实值误差在 10 ^ -5 以内的答案将被视作正确答案。
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/sliding-window-median
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * @date 2021/2/25 11:42
 * @Version 1.0
 */
public class SlidingWindowMedian {
    public double[] medianSlidingWindow(int[] nums, int k) {
        int len = nums.length;
        //平衡二叉树--过于复杂
        //拆成两个堆，小于中位数的和大于中位数的 使用优先级队列
        PriorityQueue<Integer> smallQueue = new PriorityQueue<>(new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return Integer.compare(o2, o1);
            }
        });
        PriorityQueue<Integer> bigQueue = new PriorityQueue<>();
//        初始化
        for (int i = 0; i < k; i++) {
            bigQueue.offer(nums[i]);
        }
        for (int i = 0; i < k / 2; i++) {
            smallQueue.offer(bigQueue.poll());
        }
        double[] mids = new double[len - k + 1];
        mids[0] = this.getMid(smallQueue, bigQueue);
        for (int i = 0; i < len - k; i++) {
            int item = nums[i + k];
            int pre = nums[i];
            if (item == pre) {
                mids[i + 1] = mids[i];
                continue;
            }
            if (item >= bigQueue.peek()) {
                bigQueue.offer(item);
            } else {
                smallQueue.offer(item);
            }
            if (pre >= bigQueue.peek()) {
                bigQueue.remove(pre);
            } else {
                smallQueue.remove(pre);
            }
            while (smallQueue.size() > bigQueue.size()) {
                bigQueue.offer(smallQueue.poll());
            }
            while (bigQueue.size() - smallQueue.size() > 1) {
                smallQueue.offer(bigQueue.poll());
            }
            //调整堆大小
            mids[i + 1] = this.getMid(smallQueue, bigQueue);
        }
        return mids;
    }

    private double getMid(PriorityQueue<Integer> smallQueue, PriorityQueue<Integer> bigQueue) {
        if (smallQueue.size() == bigQueue.size()) {
            return (smallQueue.peek() / 2.0) + (bigQueue.peek() / 2.0);
        } else {
            return bigQueue.peek();
        }
    }

    public static void main(String[] args) {
//        int[] nums = {-2147483648,-2147483648,2147483647,-2147483648,-2147483648,-2147483648,2147483647,2147483647,2147483647,2147483647,-2147483648,2147483647,-2147483648
//        };
        int[] nums = {-2, -2, 1, -2, -2, -2, 1, 1, 1};

//        PriorityQueue<Integer> priorityQueue = new PriorityQueue<>();
//        priorityQueue.offer(2);
//        priorityQueue.offer(1);
//        priorityQueue.offer(3);
//        System.out.println(priorityQueue.poll());
        SlidingWindowMedian slidingWindowMedian = new SlidingWindowMedian();
        System.out.println(Arrays.toString(slidingWindowMedian.medianSlidingWindow(nums, 2)));
    }

}