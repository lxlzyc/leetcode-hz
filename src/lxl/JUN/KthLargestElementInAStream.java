package lxl.JUN;

import java.util.PriorityQueue;

/**
 * @program: leetcode-hz
 * @description: 703. 数据流中的第K大元素
 * 设计一个找到数据流中第K大元素的类（class）。注意是排序后的第K大元素，不是第K个不同的元素。
 * <p>
 * 你的 KthLargest 类需要一个同时接收整数 k 和整数数组nums 的构造器，它包含数据流中的初始元素。每次调用 KthLargest.add，返回当前数据流中第K大的元素。
 * <p>
 * 示例:
 * <p>
 * int k = 3;
 * int[] arr = [4,5,8,2];
 * KthLargest kthLargest = new KthLargest(3, arr);
 * kthLargest.add(3);   // returns 4
 * kthLargest.add(5);   // returns 5
 * kthLargest.add(10);  // returns 5
 * kthLargest.add(9);   // returns 8
 * kthLargest.add(4);   // returns 8
 * <p>
 * 说明:
 * 你可以假设 nums 的长度≥ k-1 且k ≥ 1。
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/kth-largest-element-in-a-stream
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * @author: lxl
 * @create: 2020-06-08 14:20
 **/
public class KthLargestElementInAStream {

    private PriorityQueue<Integer> queue;
    private int limit;

    public KthLargestElementInAStream(int k, int[] nums) {
        limit = k;
        queue = new PriorityQueue<>(k);
        for (int num : nums) {
            add(num);
        }
    }

    public int add(int val) {
        if (queue.size() < limit) {
            queue.add(val);
        } else if (val > queue.peek()) {
            queue.poll();
            queue.add(val);
        }

        return queue.peek();
    }


    //["KthLargest","add","add","add","add","add"]
    //[[1,[]],[-3],[-2], [-4],[0],[4]]
    public static void main(String[] args) {
        int k = 1;
        int[] nums = {};
        KthLargestElementInAStream kthLargestElementInAStream = new KthLargestElementInAStream(k, nums);
        System.out.println(kthLargestElementInAStream.add(-1));
        System.out.println(kthLargestElementInAStream.add(1));
        System.out.println(kthLargestElementInAStream.add(-2));
        System.out.println(kthLargestElementInAStream.add(-3));
        System.out.println(kthLargestElementInAStream.add(10));

    }
}
