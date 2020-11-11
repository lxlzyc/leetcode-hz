package lxl.y2020.JAN;

import lxl.util.JSONUtil;

import java.util.Collections;
import java.util.LinkedList;

/**
 * @program: leetcode-hz
 * @description: 239. 滑动窗口最大值
 * 给定一个数组 nums，有一个大小为 k 的滑动窗口从数组的最左侧移动到数组的最右侧。你只可以看到在滑动窗口内的 k 个数字。滑动窗口每次只向右移动一位。
 * <p>
 * 返回滑动窗口中的最大值。
 * <p>
 * <p>
 * <p>
 * 示例:
 * <p>
 * 输入: nums = [1,3,-1,-3,5,3,6,7], 和 k = 3
 * 输出: [3,3,5,5,6,7]
 * 解释:
 * <p>
 * 滑动窗口的位置                最大值
 * ---------------               -----
 * [1  3  -1] -3  5  3  6  7       3
 * 1 [3  -1  -3] 5  3  6  7       3
 * 1  3 [-1  -3  5] 3  6  7       5
 * 1  3  -1 [-3  5  3] 6  7       5
 * 1  3  -1  -3 [5  3  6] 7       6
 * 1  3  -1  -3  5 [3  6  7]      7
 * <p>
 * <p>
 * <p>
 * 提示：
 * <p>
 * 你可以假设 k 总是有效的，在输入数组不为空的情况下，1 ≤ k ≤ 输入数组的大小。
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/sliding-window-maximum
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * @author: lxl
 * @create: 2020-01-13 15:31
 **/
public class SlidingWindowMaximum {

    public int[] maxSlidingWindow(int[] nums, int k) {
        if (nums.length <= 1 || k == 1) {
            return nums;
        }
        LinkedList<Integer> linkedList = new LinkedList<>();
        for (int i = 0; i < k; i++) {
            linkedList.add(nums[i]);
        }
        Collections.sort(linkedList);
        int length = nums.length;
        int[] maxs = new int[length - k + 1];
        maxs[0] = linkedList.getLast();
        for (int i = k; i < length; i++) {
            linkedList.remove(Integer.valueOf(nums[i - k]));
            System.out.println(nums[i]);
            maxs[i - k + 1] = this.getMax(linkedList, nums[i]);
        }
        return maxs;
    }

    private int getMax(LinkedList<Integer> linkedList, int num) {
        if (linkedList.getLast() > num) {
            for (int i = 0, l = linkedList.size(); i < l; i++) {
                if (linkedList.get(i) > num) {
                    linkedList.add(i, num);
                    break;
                }
            }
        } else {
            linkedList.add(num);
        }
        return linkedList.getLast();
    }

    public static void main(String[] args) {
        SlidingWindowMaximum slidingWindowMaximum = new SlidingWindowMaximum();
        int[] nums = {1, 3, 1, 2, 0, 5};
        System.out.println(JSONUtil.toJson(slidingWindowMaximum.maxSlidingWindow(nums, 1)));
    }
}
