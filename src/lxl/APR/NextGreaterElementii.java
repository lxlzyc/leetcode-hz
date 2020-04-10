package lxl.APR;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Stack;

/**
 * @program: leetcode-hz
 * @description: 503. 下一个更大元素 II
 * 给定一个循环数组（最后一个元素的下一个元素是数组的第一个元素），输出每个元素的下一个更大元素。数字 x 的下一个更大的元素是按数组遍历顺序，这个数字之后的第一个比它更大的数，这意味着你应该循环地搜索它的下一个更大的数。如果不存在，则输出 -1。
 * <p>
 * 示例 1:
 * <p>
 * 输入: [1,2,1]
 * 输出: [2,-1,2]
 * 解释: 第一个 1 的下一个更大的数是 2；
 * 数字 2 找不到下一个更大的数；
 * 第二个 1 的下一个最大的数需要循环搜索，结果也是 2。
 * @author: lxl
 * @create: 2020-04-10 16:53
 **/
public class NextGreaterElementii {

    static class Node {
        int offset;
        int val;

        public Node(int offset, int val) {
            this.offset = offset;
            this.val = val;
        }
    }

    public int[] nextGreaterElements(int[] nums) {
        int length = nums.length;
        if (length <= 0) {
            return nums;
        }
        Stack<Node> stack = new Stack<>();
        HashMap<Integer, Integer> numsMap = new HashMap<>();
        int max = nums[0];
        int num;
        for (int i = 0; i < length; i++) {
            num = nums[i];
            while (!stack.isEmpty() && stack.peek().val < num) {
                numsMap.put(stack.pop().offset, num);
            }
            stack.push(new Node(i, num));
            max = Math.max(nums[i], max);
        }
        for (int i = 0; i < length; i++) {
            num = nums[i];
            if (stack.peek().val == max) {
                numsMap.put(stack.pop().offset, -1);
            }
            while (!stack.isEmpty() && stack.peek().val < num) {
                numsMap.put(stack.pop().offset, num);
            }
            if (stack.isEmpty()) {
                break;
            }
        }
        for (int i = 0; i < length; i++) {
            nums[i] = numsMap.get(i);
        }
        return nums;

    }

    public static void main(String[] args) {
        NextGreaterElementii nextGreaterElementii = new NextGreaterElementii();
        int[] nums = {1, 2, 1};
        System.out.println(Arrays.toString(nextGreaterElementii.nextGreaterElements(nums)));
    }


}
