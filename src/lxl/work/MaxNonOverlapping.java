package lxl.work;

import java.util.Stack;

/**
 * @program: leetcode-hz
 * @description: 5471. 和为目标值的最大数目不重叠非空子数组数目 显示英文描述
 * <p>
 * <p>
 * 给你一个数组 nums 和一个整数 target 。
 * <p>
 * 请你返回 非空不重叠 子数组的最大数目，且每个子数组中数字和都为 target 。
 * <p>
 * <p>
 * <p>
 * 示例 1：
 * <p>
 * 输入：nums = [1,1,1,1,1], target = 2
 * 输出：2
 * 解释：总共有 2 个不重叠子数组（加粗数字表示） [1,1,1,1,1] ，它们的和为目标值 2 。
 * <p>
 * 示例 2：
 * <p>
 * 输入：nums = [-1,3,5,1,4,2,-9], target = 6
 * 输出：2
 * 解释：总共有 3 个子数组和为 6 。
 * ([5,1], [4,2], [3,5,1,4,2,-9]) 但只有前 2 个是不重叠的。
 * <p>
 * 示例 3：
 * <p>
 * 输入：nums = [-2,6,6,3,5,4,1,2,8], target = 10
 * 输出：3
 * <p>
 * 示例 4：
 * <p>
 * 输入：nums = [0,0,0], target = 0
 * 输出：3
 * <p>
 * <p>
 * <p>
 * 提示：
 * <p>
 * 1 <= nums.length <= 10^5
 * -10^4 <= nums[i] <= 10^4
 * 0 <= target <= 10^6
 * @author: lxl
 * @create: 2020-08-09 10:50
 **/
public class MaxNonOverlapping {

    //private int max;
    //private List<Node> nodes;
    //
    //static class Node {
    //    int left;
    //    int right;
    //    int length;
    //
    //    public Node(int left, int right) {
    //        this.left = left;
    //        this.right = right;
    //        this.length = right - left;
    //    }
    //}
    //
    //public int maxNonOverlapping2(int[] nums, int target) {
    //    nodes = new ArrayList<>();
    //    int len = nums.length;
    //    // 计算前缀和数组
    //    int[] preSum = new int[len + 1];
    //    preSum[0] = 0;
    //    for (int i = 0; i < len; i++) {
    //        preSum[i + 1] = preSum[i] + nums[i];
    //    }
    //    int preleft = -1;
    //    int preright = -1;
    //    int count = 0;
    //    Stack<Integer> stack = new Stack<>();
    //    for (int left = 0; left < len; left++) {
    //        for (int right = left; right < len; right++) {
    //            // 区间和 [left..right]，注意下标偏移
    //            if (preSum[right + 1] - preSum[left] == target) {
    //                if(stack.isEmpty()){
    //                    stack.push(right);
    //                }else{
    //                    if(stack.peek()<left){
    //                        stack.push(right);
    //                    }else if(stack.peek()>right){
    //                        stack.pop();
    //                        stack.push(right);
    //                    }else{
    //
    //                    }
    //                }
    //                nodes.add(new Node(left, right));
    //                System.out.println(left+"-"+right);
    //                break;
    //            }
    //        }
    //    }
    //    System.out.println(JSONUtil.toJson(nodes));
    //    return stack.size();
    //}
    public int maxNonOverlapping(int[] nums, int target) {
        int len = nums.length;
        // 计算前缀和数组
        int[] preSum = new int[len + 1];
        preSum[0] = 0;
        for (int i = 0; i < len; i++) {
            preSum[i + 1] = preSum[i] + nums[i];
        }
        Stack<Integer> stack = new Stack<>();
        int nextleft;
        for (int left = 0; left < len; left++) {
            nextleft = -1;
            for (int right = left; right < len; right++) {
                if (!stack.isEmpty() && left <= stack.peek() && right >= stack.peek()) {
                    continue;
                }
                if (right < len && nums[right] < 0 && nextleft < 0) {
                    nextleft = right;
                }
                // 区间和 [left..right]，注意下标偏移
                if (preSum[right + 1] - preSum[left] == target) {
                    if (stack.isEmpty()) {
                        stack.push(right);
                    } else {
                        if (stack.peek() < left) {
                            stack.push(right);
                        } else if (stack.peek() > right) {
                            stack.pop();
                            stack.push(right);
                        } else {

                        }
                    }
                    if (nextleft < 0) {
                        left = right;
                    }
                    break;
                }

            }
        }
        return stack.size();
    }

    public static void main(String[] args) {
        int[] nums = {-1, -2, 8, -3, 8, -5, 5, -4, 5, 4, 1};
        //[-1,-2,8,-3,8,-5,5,-4,5,4,1]
        //5
        MaxNonOverlapping minCost = new MaxNonOverlapping();
        //System.out.println(Arrays.stream(nums).sum());
        System.out.println(minCost.maxNonOverlapping(nums, 5));
    }

}
