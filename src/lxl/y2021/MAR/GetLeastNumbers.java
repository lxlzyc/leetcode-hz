package lxl.y2021.MAR;

import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;

/**
 * @author lxl
 * @program leetcode-hz
 * @description: 剑指 Offer 40. 最小的k个数
 * 输入整数数组 arr ，找出其中最小的 k 个数。例如，输入4、5、1、6、2、7、3、8这8个数字，则最小的4个数字是1、2、3、4。
 * <p>
 * <p>
 * <p>
 * 示例 1：
 * <p>
 * 输入：arr = [3,2,1], k = 2
 * 输出：[1,2] 或者 [2,1]
 * <p>
 * 示例 2：
 * <p>
 * 输入：arr = [0,1,2,1], k = 1
 * 输出：[0]
 * <p>
 * <p>
 * <p>
 * 限制：
 * <p>
 * 0 <= k <= arr.length <= 10000
 * 0 <= arr[i] <= 10000
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/zui-xiao-de-kge-shu-lcof
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * @date 2021/3/17 10:50
 * @Version 1.0
 */
public class GetLeastNumbers {
    public int[] getLeastNumbers(int[] arr, int k) {
        PriorityQueue<Integer> priorityQueue = new PriorityQueue<>(new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return Integer.compare(o2, o1);
            }
        });
        for (int item : arr) {
            priorityQueue.offer(item);
            if (priorityQueue.size() > k) {
                priorityQueue.poll();
            }
        }
        int[] re = new int[k];
        for (int i = 0; i < k; i++) {
            re[i] = priorityQueue.poll();
        }
        return re;
    }

    public static void main(String[] args) {
        GetLeastNumbers getLeastNumbers = new GetLeastNumbers();
        int[] arr = {0, 1, 2, 1, 2, 33, 1, 21, 3};
        System.out.println(Arrays.toString(getLeastNumbers.getLeastNumbers(arr, 3)));
    }
}