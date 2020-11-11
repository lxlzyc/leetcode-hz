package lxl.y2020.JUN;

/**
 * @program: leetcode-hz
 * @description: 746. 使用最小花费爬楼梯
 * 数组的每个索引作为一个阶梯，第 i个阶梯对应着一个非负数的体力花费值 cost[i](索引从0开始)。
 * <p>
 * 每当你爬上一个阶梯你都要花费对应的体力花费值，然后你可以选择继续爬一个阶梯或者爬两个阶梯。
 * <p>
 * 您需要找到达到楼层顶部的最低花费。在开始时，你可以选择从索引为 0 或 1 的元素作为初始阶梯。
 * <p>
 * 示例 1:
 * <p>
 * 输入: cost = [10, 15, 20]
 * 输出: 15
 * 解释: 最低花费是从cost[1]开始，然后走两步即可到阶梯顶，一共花费15。
 * <p>
 * 示例 2:
 * <p>
 * 输入: cost = [1, 100, 1, 1, 1, 100, 1, 1, 100, 1]
 * 输出: 6
 * 解释: 最低花费方式是从cost[0]开始，逐个经过那些1，跳过cost[3]，一共花费6。
 * <p>
 * 注意：
 * <p>
 * cost 的长度将会在 [2, 1000]。
 * 每一个 cost[i] 将会是一个Integer类型，范围为 [0, 999]。
 * @author: lxl
 * @create: 2020-06-16 10:24
 **/
public class MinCostClimbingStairs {
    public int minCostClimbingStairs(int[] cost) {
        int l = cost.length;
        int pre = cost[0];
        int next = cost[1];
        int index;
        for (int i = 2; i < l; i++) {
            index = Math.min(pre, next) + cost[i];
            pre = next;
            next = index;
        }
        return Math.min(pre, next);
    }

    public static void main(String[] args) {
        MinCostClimbingStairs min = new MinCostClimbingStairs();
        int[] cost = {1, 2};
        System.out.println(min.minCostClimbingStairs(cost));
    }
}
